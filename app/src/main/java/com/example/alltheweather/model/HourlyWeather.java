package com.example.alltheweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HourlyWeather {

    @SerializedName("windSpeed")
    @Expose
    private Double windSpeed;
    @SerializedName("temperature")
    @Expose
    private Integer temperature;
    @SerializedName("weatherType")
    @Expose
    private String weatherType;
    @SerializedName("humidity")
    @Expose
    private Double humidity;
    @SerializedName("hour")
    @Expose
    private Integer hour;
    @SerializedName("rainChance")
    @Expose
    private Double rainChance;

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double getRainChance() {
        return rainChance;
    }

    public void setRainChance(Double rainChance) {
        this.rainChance = rainChance;
    }
}
