package com.example.horo.model.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;



@Entity(tableName="weekly")
public class WeeklyHoroscope implements Serializable {



    @PrimaryKey (autoGenerate = true)
    private int hid;

    private String typeWeek;

    private String date;
    private String zodiac;

    private String businessHoro;

    private String commonHoro;

    private String loveHoro;

    private String healthHoro;

    private String carHoro;

    private String beautyHoro;

    private String eroticHoro;

    private String goldHoro;


    public WeeklyHoroscope(String typeWeek, String date, String zodiac, String businessHoro, String commonHoro, String loveHoro, String healthHoro, String carHoro, String beautyHoro, String eroticHoro, String goldHoro) {
        this.typeWeek = typeWeek;
        this.date = date;
        this.zodiac = zodiac;
        this.businessHoro = businessHoro;
        this.commonHoro = commonHoro;
        this.loveHoro = loveHoro;
        this.healthHoro = healthHoro;
        this.carHoro = carHoro;
        this.beautyHoro = beautyHoro;
        this.eroticHoro = eroticHoro;
        this.goldHoro = goldHoro;
    }

    public int getHid() {
        return hid;
    }

    public String getTypeWeek() {
        return typeWeek;
    }

    public String getDate() {
        return date;
    }

    public String getZodiac() {
        return zodiac;
    }

    public String getBusinessHoro() {
        return businessHoro;
    }

    public String getCommonHoro() {
        return commonHoro;
    }

    public String getLoveHoro() {
        return loveHoro;
    }

    public String getHealthHoro() {
        return healthHoro;
    }

    public String getCarHoro() {
        return carHoro;
    }

    public String getBeautyHoro() {
        return beautyHoro;
    }

    public String getEroticHoro() {
        return eroticHoro;
    }

    public String getGoldHoro() {
        return goldHoro;
    }


    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setTypeWeek(String typeWeek) {
        this.typeWeek = typeWeek;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public void setBusinessHoro(String businessHoro) {
        this.businessHoro = businessHoro;
    }

    public void setCommonHoro(String commonHoro) {
        this.commonHoro = commonHoro;
    }

    public void setLoveHoro(String loveHoro) {
        this.loveHoro = loveHoro;
    }

    public void setHealthHoro(String healthHoro) {
        this.healthHoro = healthHoro;
    }

    public void setCarHoro(String carHoro) {
        this.carHoro = carHoro;
    }

    public void setBeautyHoro(String beautyHoro) {
        this.beautyHoro = beautyHoro;
    }

    public void setEroticHoro(String eroticHoro) {
        this.eroticHoro = eroticHoro;
    }

    public void setGoldHoro(String goldHoro) {
        this.goldHoro = goldHoro;
    }
}
