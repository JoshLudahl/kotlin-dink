data class CurrentWeather(
    val coord: WeatherCoord,
    val name: String,
    val id: Long,
    val timezone: Number,
    val main: WeatherMain,
    val weather: List<WeatherDetails>,
    val wind: WeatherWind
)

data class WeatherCoord(
    val lon: Double,
    val lat: Double
)

data class WeatherWind(
    val speed: Double,
    val deg: Double
)

data class WeatherMain(
    val temp: Double,
    val pressure: Double,
    val humidity: Double,
    val temp_min: Double,
    val temp_max: Double
)

data class WeatherDetails(
    val main: String,
    val description: String,
    val icon: String
)