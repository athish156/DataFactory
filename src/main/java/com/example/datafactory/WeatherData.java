package com.example.datafactory;

import java.util.Date;

public class WeatherData {

    private static int nextId = 1; // Initialize the ID counter

    private int id;
    private String precipitation;
    private Date date;
    private String stationCity;
    private String stationCode;
    private String stationLocation;
    private String stationState;
    private String avgTemperature;
    private String windSpeed;

    public WeatherData(String precipitation, String stationCity, String stationCode,
                       String stationLocation, String stationState, String avgTemperature, String windSpeed) {
        this.id = nextId++; // Assign the next available ID and increment the counter
        this.precipitation = precipitation;
        this.stationCity = stationCity;
        this.stationCode = stationCode;
        this.stationLocation = stationLocation;
        this.stationState = stationState;
        this.avgTemperature = avgTemperature;
        this.windSpeed = windSpeed;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getStationCity() {
        return stationCity;
    }

    public void setStationCity(String stationCity) {
        this.stationCity = stationCity;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }

    public String getStationState() {
        return stationState;
    }

    public void setStationState(String stationState) {
        this.stationState = stationState;
    }

    public String getAvgTemperature() {
        return avgTemperature;
    }

    public void setAvgTemperature(String avgTemperature) {
        this.avgTemperature = avgTemperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
