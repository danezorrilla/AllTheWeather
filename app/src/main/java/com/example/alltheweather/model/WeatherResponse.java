package com.example.alltheweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("totalCitiesFound")
    @Expose
    private Integer totalCitiesFound;
    @SerializedName("startIndex")
    @Expose
    private Integer startIndex;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public Integer getTotalCitiesFound() {
        return totalCitiesFound;
    }

    public void setTotalCitiesFound(Integer totalCitiesFound) {
        this.totalCitiesFound = totalCitiesFound;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
