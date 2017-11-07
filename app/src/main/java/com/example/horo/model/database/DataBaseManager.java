package com.example.horo.model.database;

import android.util.Log;

import com.example.horo.model.Constants;
import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;

import java.util.ArrayList;
import java.util.List;




public class DataBaseManager {



    private AppBase  database;

    public DataBaseManager(AppBase database) {
        this.database = database;
    }

    public void saveDailyHoroIntoDB(List<DailyHoroscope> dailyHoroList){

        String typeHoro=dailyHoroList.get(0).getTypeHoro();

        if(database.getHoroDao().getAllDailyHoroDB().size()!=0){

            List<DailyHoroscope> listDB = database.getHoroDao().getAllDailyHoroDB();


            String type="";

            for(DailyHoroscope dailyHoro:listDB){

                if(dailyHoro.getTypeHoro().equals(typeHoro)){

                    type=typeHoro;

                    break;
                }

            }

            if(type.equals(typeHoro)){

                updateDailyHoroDB(dailyHoroList,typeHoro);

            }else{

                database.getHoroDao().insertDailyHoro(dailyHoroList);
            }

        }else{
            database.getHoroDao().insertDailyHoro(dailyHoroList);

        }

        List<DailyHoroscope> listDBafter = database.getHoroDao().getAllDailyHoroDB();

        for(DailyHoroscope dailyHoro:listDBafter) {
            Log.d("DailyHoroDB-after", dailyHoro.getTypeHoro() + " ПРОБЕЛ " + dailyHoro.getZodiac()+ " ПРОБЕЛ " + dailyHoro.getDateYesterday() + "ПРОБЕЛ" + dailyHoro.getHoroYesterday() + "ПРОБЕЛ" + dailyHoro.getDateToday() + "ПРОБЕЛ" + dailyHoro.getHoroToday());
        }
    }

    private void updateDailyHoroDB(List<DailyHoroscope> dailyHoroList, String typeHoro) {

        DailyHoroscope aries =  dailyHoroList.get(0);
        DailyHoroscope taurus =  dailyHoroList.get(1);
        DailyHoroscope gemini =  dailyHoroList.get(2);
        DailyHoroscope cancer =  dailyHoroList.get(3);
        DailyHoroscope leo =  dailyHoroList.get(4);
        DailyHoroscope virgo =  dailyHoroList.get(5);
        DailyHoroscope libra =  dailyHoroList.get(6);
        DailyHoroscope scorpio =  dailyHoroList.get(7);
        DailyHoroscope sagittarius =  dailyHoroList.get(8);
        DailyHoroscope capricorn =  dailyHoroList.get(9);
        DailyHoroscope aquarius =  dailyHoroList.get(10);
        DailyHoroscope pisces =  dailyHoroList.get(11);

        database.getHoroDao().updateDailyDB(typeHoro, Constants.ARIES,aries.getDateYesterday(),aries.getDateToday(),aries.getDateTomorrow(),aries.getDateTomorrow02(),aries.getHoroYesterday(),aries.getHoroToday(),aries.getHoroTomorrow(),aries.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.TAURUS,taurus.getDateYesterday(),taurus.getDateToday(),taurus.getDateTomorrow(),taurus.getDateTomorrow02(),taurus.getHoroYesterday(),taurus.getHoroToday(),taurus.getHoroTomorrow(),taurus.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.GEMINI, gemini.getDateYesterday(), gemini.getDateToday(),gemini.getDateTomorrow(),gemini.getDateTomorrow02(),gemini.getHoroYesterday(),gemini.getHoroToday(),gemini.getHoroTomorrow(),gemini.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.CANCER,cancer.getDateYesterday(),cancer.getDateToday(),cancer.getDateTomorrow(),cancer.getDateTomorrow02(),cancer.getHoroYesterday(),cancer.getHoroToday(),cancer.getHoroTomorrow(),cancer.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.LEO,leo.getDateYesterday(),leo.getDateToday(),leo.getDateTomorrow(),leo.getDateTomorrow02(),leo.getHoroYesterday(),leo.getHoroToday(),leo.getHoroTomorrow(),leo.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.VIRGO,virgo.getDateYesterday(),virgo.getDateToday(),virgo.getDateTomorrow(),virgo.getDateTomorrow02(),virgo.getHoroYesterday(),virgo.getHoroToday(),virgo.getHoroTomorrow(),virgo.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.LIBRA,libra.getDateYesterday(),libra.getDateToday(),libra.getDateTomorrow(),libra.getDateTomorrow02(),libra.getHoroYesterday(),libra.getHoroToday(),libra.getHoroTomorrow(),libra.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.SCORPIO,scorpio.getDateYesterday(),scorpio.getDateToday(),scorpio.getDateTomorrow(),scorpio.getDateTomorrow02(),scorpio.getHoroYesterday(),scorpio.getHoroToday(),scorpio.getHoroTomorrow(),scorpio.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.SAGITTARIUS,sagittarius.getDateYesterday(),sagittarius.getDateToday(),sagittarius.getDateTomorrow(),sagittarius.getDateTomorrow02(),sagittarius.getHoroYesterday(),sagittarius.getHoroToday(),sagittarius.getHoroTomorrow(),sagittarius.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.CAPRICORN,capricorn.getDateYesterday(),capricorn.getDateToday(),capricorn.getDateTomorrow(),capricorn.getDateTomorrow02(),capricorn.getHoroYesterday(),capricorn.getHoroToday(),capricorn.getHoroTomorrow(),capricorn.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.AQUARIUS,aquarius.getDateYesterday(),aquarius.getDateToday(),aquarius.getDateTomorrow(),aquarius.getDateTomorrow02(),aquarius.getHoroYesterday(),aquarius.getHoroToday(),aquarius.getHoroTomorrow(),aquarius.getHoroTomorrow02());
        database.getHoroDao().updateDailyDB(typeHoro,Constants.PISCES,pisces.getDateYesterday(),pisces.getDateToday(),pisces.getDateTomorrow(),pisces.getDateTomorrow02(),pisces.getHoroYesterday(),pisces.getHoroToday(),pisces.getHoroTomorrow(),pisces.getHoroTomorrow02());

    }


    public ArrayList<DailyHoroscope> launchDailyHoroFromBD(String typeHoro){

        ArrayList<DailyHoroscope> listHoroInten=null;

        switch (typeHoro){

            case Constants.COMMON:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.COMMON));

                break;
            case Constants.EROTIC:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.EROTIC));

                break;
            case Constants.ANTI:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.ANTI));

                break;
            case Constants.BISNESS:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.BISNESS));

                break;
            case Constants.HEALTH:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.HEALTH));

                break;
            case Constants.COOK:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.COOK));

                break;
            case Constants.LOVE:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.LOVE));

                break;
            case Constants.MOBILE:

                listHoroInten=new ArrayList<>(database.getHoroDao().getTypeDailyHoro(Constants.MOBILE));

                break;
        }

             return listHoroInten;
    }

    public void saveWeeklyHoroIntoDB(List<WeeklyHoroscope> weeklyHoroList){

        String typeWeek = weeklyHoroList.get(0).getTypeWeek();

        if(database.getHoroDao().getAllWeeklyHoroDB().size()!=0){

            List<WeeklyHoroscope> listDB = database.getHoroDao().getAllWeeklyHoroDB();

            for(WeeklyHoroscope weeklyHoro:listDB) {
                Log.d("DailyHoroDB-before", weeklyHoro.getTypeWeek() + " ПРОБЕЛ "+weeklyHoro.getDate() +" ПРОБЕЛ "+ weeklyHoro.getZodiac()+ " ПРОБЕЛ " + weeklyHoro.getCommonHoro() + "ПРОБЕЛ" +  weeklyHoro.getBusinessHoro()  + "ПРОБЕЛ" +weeklyHoro.getEroticHoro() );
            }

            String type="";

            for(WeeklyHoroscope weeklyHoro:listDB){

                if(weeklyHoro.getTypeWeek().equals(typeWeek)){

                    type=typeWeek;

                    break;
                }

            }

            if(type.equals(typeWeek)){

                updateWeeklyHoroDB(weeklyHoroList,typeWeek);

            }else{

                database.getHoroDao().insertWeeklyHoro(weeklyHoroList);

            }
        }else{

            database.getHoroDao().insertWeeklyHoro(weeklyHoroList);

        }

        List<WeeklyHoroscope> listDBafter = database.getHoroDao().getAllWeeklyHoroDB();

        for(WeeklyHoroscope weeklyHoro:listDBafter) {
            Log.d("DailyHoroDB-after", weeklyHoro.getTypeWeek() + " ПРОБЕЛ "+weeklyHoro.getDate() +" ПРОБЕЛ "+ weeklyHoro.getZodiac()+ " ПРОБЕЛ " + weeklyHoro.getCommonHoro() + "ПРОБЕЛ" +  weeklyHoro.getBusinessHoro()  + "ПРОБЕЛ" +weeklyHoro.getEroticHoro() );
        }

    }

    private void updateWeeklyHoroDB(List<WeeklyHoroscope> weeklyHoroList, String typeWeek) {

        WeeklyHoroscope aries =  weeklyHoroList.get(0);
        WeeklyHoroscope taurus =  weeklyHoroList.get(1);
        WeeklyHoroscope gemini =  weeklyHoroList.get(2);
        WeeklyHoroscope cancer =  weeklyHoroList.get(3);
        WeeklyHoroscope leo =  weeklyHoroList.get(4);
        WeeklyHoroscope virgo =  weeklyHoroList.get(5);
        WeeklyHoroscope libra =  weeklyHoroList.get(6);
        WeeklyHoroscope scorpio =  weeklyHoroList.get(7);
        WeeklyHoroscope sagittarius =  weeklyHoroList.get(8);
        WeeklyHoroscope capricorn =  weeklyHoroList.get(9);
        WeeklyHoroscope aquarius =  weeklyHoroList.get(10);
        WeeklyHoroscope pisces =  weeklyHoroList.get(11);
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.ARIES,aries.getDate(),aries.getBusinessHoro(),aries.getCommonHoro(),aries.getLoveHoro(),aries.getHealthHoro(),aries.getCarHoro(),aries.getBeautyHoro(),aries.getEroticHoro(),aries.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.TAURUS,taurus.getDate(),taurus.getBusinessHoro(),taurus.getCommonHoro(),taurus.getLoveHoro(),taurus.getHealthHoro(),taurus.getCarHoro(),taurus.getBeautyHoro(),taurus.getEroticHoro(),taurus.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.GEMINI,gemini.getDate(),gemini.getBusinessHoro(),gemini.getCommonHoro(),gemini.getLoveHoro(),gemini.getHealthHoro(),gemini.getCarHoro(),gemini.getBeautyHoro(),gemini.getEroticHoro(),gemini.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.CANCER,cancer.getDate(),cancer.getBusinessHoro(),cancer.getCommonHoro(),cancer.getLoveHoro(),cancer.getHealthHoro(),cancer.getCarHoro(),cancer.getBeautyHoro(),cancer.getEroticHoro(),cancer.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.LEO,leo.getDate(),leo.getBusinessHoro(),leo.getCommonHoro(),leo.getLoveHoro(),leo.getHealthHoro(),leo.getCarHoro(),leo.getBeautyHoro(),leo.getEroticHoro(),leo.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.VIRGO,virgo.getDate(),virgo.getBusinessHoro(),virgo.getCommonHoro(),virgo.getLoveHoro(),virgo.getHealthHoro(),virgo.getCarHoro(),virgo.getBeautyHoro(),virgo.getEroticHoro(),virgo.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.LIBRA,libra.getDate(),libra.getBusinessHoro(),libra.getCommonHoro(),libra.getLoveHoro(),libra.getHealthHoro(),libra.getCarHoro(),libra.getBeautyHoro(),libra.getEroticHoro(),libra.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.SCORPIO,scorpio.getDate(),scorpio.getBusinessHoro(),scorpio.getCommonHoro(),scorpio.getLoveHoro(),scorpio.getHealthHoro(),scorpio.getCarHoro(),scorpio.getBeautyHoro(),scorpio.getEroticHoro(),scorpio.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.SAGITTARIUS,sagittarius.getDate(),sagittarius.getBusinessHoro(),sagittarius.getCommonHoro(),sagittarius.getLoveHoro(),sagittarius.getHealthHoro(),sagittarius.getCarHoro(),sagittarius.getBeautyHoro(),sagittarius.getEroticHoro(),sagittarius.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.CAPRICORN,capricorn.getDate(),capricorn.getBusinessHoro(),capricorn.getCommonHoro(),capricorn.getLoveHoro(),capricorn.getHealthHoro(),capricorn.getCarHoro(),capricorn.getBeautyHoro(),capricorn.getEroticHoro(),capricorn.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.AQUARIUS,aquarius.getDate(),aquarius.getBusinessHoro(),aquarius.getCommonHoro(),aquarius.getLoveHoro(),aquarius.getHealthHoro(),aquarius.getCarHoro(),aquarius.getBeautyHoro(),aquarius.getEroticHoro(),aquarius.getGoldHoro());
        database.getHoroDao().updateWeeklyDB(typeWeek,Constants.PISCES,pisces.getDate(),pisces.getBusinessHoro(),pisces.getCommonHoro(),pisces.getLoveHoro(),pisces.getHealthHoro(),pisces.getCarHoro(),pisces.getBeautyHoro(),pisces.getEroticHoro(),pisces.getGoldHoro());

    }


    public ArrayList<WeeklyHoroscope> launchWeeklyHoroFromBD(String typeWeek){

        ArrayList<WeeklyHoroscope> weeklyHoroList = new ArrayList<>();

        switch (typeWeek) {

            case Constants.CURRENT:

                List<WeeklyHoroscope> listCur=database.getHoroDao().getTypeWeeklyHoro(Constants.CURRENT);
                weeklyHoroList.addAll(listCur);

                break;

            case Constants.LAST:
                List<WeeklyHoroscope> listLast=database.getHoroDao().getTypeWeeklyHoro(Constants.LAST);

                weeklyHoroList.addAll(listLast);

                break;

        }

        return weeklyHoroList;
    }


}
