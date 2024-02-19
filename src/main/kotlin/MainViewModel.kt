import http.ServiceCreator
import http.module.LocationBean
import http.module.WeatherNowBean
import http.searvice.GeoSearchService
import http.searvice.WeatherService
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.coroutines.CoroutineContext

object MainViewModel : CoroutineScope {

    private val weatherService by lazy {
        ServiceCreator.createWeather(WeatherService::class.java)
    }

    private val geoService by lazy {
        ServiceCreator.createGeo(GeoSearchService::class.java)
    }

    private val _searchResultFlow = MutableStateFlow<LocationBean?>(null)
    val searchResultFlow = _searchResultFlow.asStateFlow()

    private val _weatherNowFlow = MutableStateFlow<WeatherNowBean?>(null)
    val weatherNowFlow = _weatherNowFlow.asStateFlow()

    // 搜索城市
    fun search(keyWord: String) = launch(Dispatchers.IO) {
        val locationBean = geoService.searchCity(keyWord)
        println("binghao:$locationBean")
        _searchResultFlow.emit(locationBean)
    }

    // 获取实时天气
    fun getWeatherNow(location: String) = launch(Dispatchers.IO) {
        val weather = weatherService.getWeatherNow(location = location)
        _weatherNowFlow.emit(weather)
    }

    override val coroutineContext: CoroutineContext
        get() = Job()
}