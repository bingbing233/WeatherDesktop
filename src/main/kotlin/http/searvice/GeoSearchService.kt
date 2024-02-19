package http.searvice

import http.WeatherConst
import http.module.LocationBean
import retrofit2.http.GET
import retrofit2.http.Query

interface GeoSearchService {

    @GET("city/lookup")
    suspend fun searchCity(
        @Query("location") location:String,
        @Query("key") key:String = WeatherConst.WEATHER_KEY
    ):LocationBean
}