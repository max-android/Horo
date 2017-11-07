package com.example.horo.model.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;





@Entity(tableName="daily")
public class DailyHoroscope implements Serializable {

    @PrimaryKey (autoGenerate = true)
    private int hid;

    private String typeHoro;
    private String zodiac;

    private String dateYesterday;
    private String dateToday;
    private String dateTomorrow;
    private String dateTomorrow02;

    private String horoYesterday;
    private String horoToday;
    private String horoTomorrow;
    private String horoTomorrow02;


    public DailyHoroscope(String typeHoro, String zodiac, String dateYesterday, String dateToday, String dateTomorrow, String dateTomorrow02, String horoYesterday, String horoToday, String horoTomorrow, String horoTomorrow02) {
        this.typeHoro = typeHoro;
        this.zodiac = zodiac;
        this.dateYesterday = dateYesterday;
        this.dateToday = dateToday;
        this.dateTomorrow = dateTomorrow;
        this.dateTomorrow02 = dateTomorrow02;
        this.horoYesterday = horoYesterday;
        this.horoToday = horoToday;
        this.horoTomorrow = horoTomorrow;
        this.horoTomorrow02 = horoTomorrow02;
    }

    public int getHid() {
        return hid;
    }

    public String getTypeHoro() {
        return typeHoro;
    }

    public String getZodiac() {
        return zodiac;
    }

    public String getDateYesterday() {
        return dateYesterday;
    }

    public String getDateToday() {
        return dateToday;
    }

    public String getDateTomorrow() {
        return dateTomorrow;
    }

    public String getDateTomorrow02() {
        return dateTomorrow02;
    }

    public String getHoroYesterday() {
        return horoYesterday;
    }

    public String getHoroToday() {
        return horoToday;
    }

    public String getHoroTomorrow() {
        return horoTomorrow;
    }

    public String getHoroTomorrow02() {
        return horoTomorrow02;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    public void setTypeHoro(String typeHoro) {
        this.typeHoro = typeHoro;
    }

    public void setZodiac(String zodiac) {
        this.zodiac = zodiac;
    }

    public void setDateYesterday(String dateYesterday) {
        this.dateYesterday = dateYesterday;
    }

    public void setDateToday(String dateToday) {
        this.dateToday = dateToday;
    }

    public void setDateTomorrow(String dateTomorrow) {
        this.dateTomorrow = dateTomorrow;
    }

    public void setDateTomorrow02(String dateTomorrow02) {
        this.dateTomorrow02 = dateTomorrow02;
    }

    public void setHoroYesterday(String horoYesterday) {
        this.horoYesterday = horoYesterday;
    }

    public void setHoroToday(String horoToday) {
        this.horoToday = horoToday;
    }

    public void setHoroTomorrow(String horoTomorrow) {
        this.horoTomorrow = horoTomorrow;
    }

    public void setHoroTomorrow02(String horoTomorrow02) {
        this.horoTomorrow02 = horoTomorrow02;
    }
}
