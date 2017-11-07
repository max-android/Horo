package com.example.horo.model.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;


@Database(entities = {DailyHoroscope.class,
        WeeklyHoroscope.class,}, version = 1)
public abstract class AppBase extends RoomDatabase {

    public abstract HoroDao getHoroDao();

}
