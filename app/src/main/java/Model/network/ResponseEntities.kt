package Model.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import retrofit2.http.Field

data class Main(

    @Json(name = "temp") val temp: Double,
    @Json(name = "feels_like") val feelsLike: Double,
    @Json(name = "humidity") val humidity: Int
)

data class Weather(

    @Json(name = "id") val id: Int,
    @Json(name = "main") val main: String,
    @Json(name = "description") val description: String,
    @Json(name = "icon") val icon: String
)

data class currentCoord(var lat: String, var lon: String)


data class CurrentWeather(
    @Json(name = "main") val main: Main,
    @Json(name = "dt") val dt: Long,
    @Json(name = "name") val name: String,
    @Json(name = "weather") val weatherList: List<Weather>
)