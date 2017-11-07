package com.example.horo.model.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;

import java.util.List;




@Dao
public interface HoroDao {


    @Insert
    void insertDailyHoro(List<DailyHoroscope> horo);


    @Insert
    void insertWeeklyHoro(List<WeeklyHoroscope> horo);


    @Query("SELECT * FROM daily")
    public List<DailyHoroscope> getAllDailyHoroDB();


    @Query("SELECT * FROM weekly")
    public List<WeeklyHoroscope> getAllWeeklyHoroDB();


    @Query("SELECT * FROM daily WHERE typeHoro = :type")
    public List<DailyHoroscope> getTypeDailyHoro(String type);

    @Query("SELECT * FROM weekly WHERE typeWeek = :type")
    public List<WeeklyHoroscope> getTypeWeeklyHoro(String type);


    @Query("UPDATE daily SET dateYesterday = :new_dateYesterday," +
            "dateToday = :new_dateToday," +
            "dateTomorrow = :new_dateTomorrow," +
            "dateTomorrow02 = :new_dateTomorrow02," +
            "horoYesterday = :new_horoYesterday," +
            "horoToday = :new_horoToday," +
            "horoTomorrow = :new_horoTomorrow," +
            "horoTomorrow02 = :new_horoTomorrow02 WHERE typeHoro = :type and zodiac = :znac")
    void updateDailyDB(String type, String znac,
                       String new_dateYesterday,
                       String new_dateToday,
                       String new_dateTomorrow,
                       String new_dateTomorrow02,
                       String new_horoYesterday,
                       String new_horoToday,
                       String new_horoTomorrow,
                       String new_horoTomorrow02
    );


    @Query("UPDATE weekly SET date = :new_date," +
            "businessHoro = :new_businessHoro," +
            "commonHoro = :new_commonHoro," +
            "loveHoro = :new_loveHoro," +
            "healthHoro = :new_healthHoro," +
            "carHoro = :new_carHoro," +
            "beautyHoro = :new_beautyHoro," +
            "eroticHoro = :new_eroticHoro," +
            "goldHoro = :new_goldHoro WHERE typeWeek = :type and zodiac = :znac")
    void updateWeeklyDB(String type, String znac,
                        String new_date,
                        String new_businessHoro,
                        String new_commonHoro,
                        String new_loveHoro,
                        String new_healthHoro,
                        String new_carHoro,
                        String new_beautyHoro,
                        String new_eroticHoro,
                        String new_goldHoro
    );

}
