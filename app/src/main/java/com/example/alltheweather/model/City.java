package com.example.alltheweather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country code")
    @Expose
    private String countryCode;
    @SerializedName("alternatenames")
    @Expose
    private String alternatenames;
    @SerializedName("admin4 code")
    @Expose
    private String admin4Code;
    @SerializedName("elevation")
    @Expose
    private Integer elevation;

    @SerializedName("geonameid")
    @Expose
    private Integer geonameid;
    @SerializedName("modification date")
    @Expose
    private String modificationDate;
    @SerializedName("feature code")
    @Expose
    private String featureCode;
    @SerializedName("dem")
    @Expose
    private Integer dem;
    @SerializedName("feature class")
    @Expose
    private String featureClass;
    @SerializedName("admin2 code")
    @Expose
    private Integer admin2Code;
    @SerializedName("admin3 code")
    @Expose
    private Object admin3Code;
    @SerializedName("longitude")
    @Expose
    private Double longitude;
    @SerializedName("asciiname")
    @Expose
    private String asciiname;
    @SerializedName("latitude")
    @Expose
    private Double latitude;
    @SerializedName("timezone")
    @Expose
    private String timezone;
    @SerializedName("population")
    @Expose
    private Integer population;
    @SerializedName("cc2")
    @Expose
    private String cc2;
    @SerializedName("admin1 code")
    @Expose
    private String admin1Code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAlternatenames() {
        return alternatenames;
    }

    public void setAlternatenames(String alternatenames) {
        this.alternatenames = alternatenames;
    }

    public String getAdmin4Code() {
        return admin4Code;
    }

    public void setAdmin4Code(String admin4Code) {
        this.admin4Code = admin4Code;
    }

    public Integer getElevation() {
        return elevation;
    }

    public void setElevation(Integer elevation) {
        this.elevation = elevation;
    }

    public Integer getGeonameid() {
        return geonameid;
    }

    public void setGeonameid(Integer geonameid) {
        this.geonameid = geonameid;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public void setFeatureCode(String featureCode) {
        this.featureCode = featureCode;
    }

    public Integer getDem() {
        return dem;
    }

    public void setDem(Integer dem) {
        this.dem = dem;
    }

    public String getFeatureClass() {
        return featureClass;
    }

    public void setFeatureClass(String featureClass) {
        this.featureClass = featureClass;
    }

    public Integer getAdmin2Code() {
        return admin2Code;
    }

    public void setAdmin2Code(Integer admin2Code) {
        this.admin2Code = admin2Code;
    }

    public Object getAdmin3Code() {
        return admin3Code;
    }

    public void setAdmin3Code(Object admin3Code) {
        this.admin3Code = admin3Code;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAsciiname() {
        return asciiname;
    }

    public void setAsciiname(String asciiname) {
        this.asciiname = asciiname;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getCc2() {
        return cc2;
    }

    public void setCc2(String cc2) {
        this.cc2 = cc2;
    }

    public String getAdmin1Code() {
        return admin1Code;
    }

    public void setAdmin1Code(String admin1Code) {
        this.admin1Code = admin1Code;
    }
}
