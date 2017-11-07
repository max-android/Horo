package com.example.horo.model;

import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;

import java.util.ArrayList;




public interface TransmitterList {

    void transferWeeklyHoroscopes(ArrayList<WeeklyHoroscope> weeklyHoroList);
    void transferDailyHoroscopes(ArrayList<DailyHoroscope> dailyHoroList);
    void showError(String error);



}
