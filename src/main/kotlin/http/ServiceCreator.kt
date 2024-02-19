package http

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object ServiceCreator {
    private const val GEO_BASE_URL = "https://geoapi.qweather.com/v2/"
    private const val WEATHER_BASE_URL = "https://devapi.qweather.com/v7/"
    private const val CONNECT_TIMEOUT = 30L
    private const val READ_TIMEOUT = 10L


    private fun create(url: String): Retrofit {
        val client = OkHttpClient.Builder().connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS).build()

        return Retrofit.Builder().baseUrl(url).client(client).addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> createWeather(service: Class<T>): T = create(WEATHER_BASE_URL).create(service)
    fun <T> createGeo(service: Class<T>): T = create(GEO_BASE_URL).create(service)
}