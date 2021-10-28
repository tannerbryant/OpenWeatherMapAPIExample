package bryant;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class WeatherForecast {
    @SerializedName("forecastList")
    private Map<String, Object> forecastList;

    public WeatherForecast(Map<String, Object> forecastList) {
        this.forecastList = forecastList;
    }



}
