package http.searvice

import http.WeatherConst
import http.module.WeatherNowBean
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    /**
     * @param location locationID 参考GEO API
     */
    @GET("weather/now")
    suspend fun getWeatherNow(
        @Query("key") key: String = WeatherConst.WEATHER_KEY,
        @Query("location") location: String,
    ):WeatherNowBean
}