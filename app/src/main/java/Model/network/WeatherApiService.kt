package Model.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private val API_KEY = "43467c54fc8acf92ca78163314b77131"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory()).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WeatherApiService {
    @GET("weather?")
    suspend fun getCurrentWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = API_KEY,
        @Query("lang") lang: String = "ru"
    ): CurrentWeather

    @GET("reverse?")
    suspend fun getCity(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = API_KEY
    ): ReverseGeocoding
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}

