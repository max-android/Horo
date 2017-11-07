package com.example.horo.screen.detailhoro;

import java.io.Serializable;



public class DetailWeekHoro implements Serializable {

    private String sign;
    private String typeForecast;
    private String forecast;

    public DetailWeekHoro(String sign, String typeForecast, String forecast) {
        this.sign = sign;
        this.typeForecast = typeForecast;
        this.forecast = forecast;
    }

    public DetailWeekHoro(String typeForecast, String forecast) {
        this.typeForecast = typeForecast;
        this.forecast = forecast;
    }

    public String getTypeForecast() {
        return typeForecast;
    }

    public String getForecast() {
        return forecast;
    }


    public void setTypeForecast(String typeForecast) {
        this.typeForecast = typeForecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
