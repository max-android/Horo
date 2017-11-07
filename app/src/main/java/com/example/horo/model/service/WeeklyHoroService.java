package com.example.horo.model.service;

import android.util.Log;

import com.example.horo.model.Constants;
import com.example.horo.model.TransmitterList;
import com.example.horo.model.database.entities.WeeklyHoroscope;
import com.example.horo.model.service.pojo.weekly.HoroWeekly;

import java.io.IOException;
import java.util.ArrayList;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class WeeklyHoroService {

    private TransmitterList transmitterList;
    private HoroService horoService;
    private String typeWeek;
    private ArrayList<WeeklyHoroscope> weeklyHoroscopeList;


    public WeeklyHoroService(HoroService horoService, String typeWeek, TransmitterList transmitterList) {
        this.horoService = horoService;
        this.typeWeek = typeWeek;
        this.transmitterList = transmitterList;

    }

    public void executeWeekHoroService(){

        createWeekHoro();

    }

    private  void createWeekHoro(){

        weeklyHoroscopeList = new ArrayList<>();

        horoService.horoWeekly(typeWeek).enqueue(new Callback<HoroWeekly>() {
            @Override
            public void onResponse(Call<HoroWeekly> call, Response<HoroWeekly> response) {

                getWeekHoro(weeklyHoroscopeList,response);
            }


            @Override
            public void onFailure(Call<HoroWeekly> call, Throwable t) {
                transmitterList.showError(Constants.ERROR_NETWORK);
                //Toast.makeText(HoroActivity.this,"Ошибка соединения Failure"+t.toString(),Toast.LENGTH_LONG).show();
                Log.d("ОШИБКА------",t.toString());

            }
        });

    }


    private void getWeekHoro(ArrayList<WeeklyHoroscope> weeklyHoroscopeList, Response<HoroWeekly> response){

        if (response.isSuccessful()) {

            String date = response.body().getDate().getWeekly();

            String week=convertTypeWeek(typeWeek);

            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date, Constants.ARIES,
                    response.body().getAries().getBusiness(),
                    response.body().getAries().getCommon(),
                    response.body().getAries().getLove(),
                    response.body().getAries().getHealth(),
                    response.body().getAries().getCar(),
                    response.body().getAries().getBeauty(),
                    response.body().getAries().getErotic(),
                    response.body().getAries().getGold()));

            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.TAURUS,
                    response.body().getTaurus().getBusiness(),
                    response.body().getTaurus().getCommon(),
                    response.body().getTaurus().getLove(),
                    response.body().getTaurus().getHealth(),
                    response.body().getTaurus().getCar(),
                    response.body().getTaurus().getBeauty(),
                    response.body().getTaurus().getErotic(),
                    response.body().getTaurus().getGold()));

            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.GEMINI,
                    response.body().getGemini().getBusiness(),
                    response.body().getGemini().getCommon(),
                    response.body().getGemini().getLove(),
                    response.body().getGemini().getHealth(),
                    response.body().getGemini().getCar(),
                    response.body().getGemini().getBeauty(),
                    response.body().getGemini().getErotic(),
                    response.body().getGemini().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.CANCER,
                    response.body().getCancer().getBusiness(),
                    response.body().getCancer().getCommon(),
                    response.body().getCancer().getLove(),
                    response.body().getCancer().getHealth(),
                    response.body().getCancer().getCar(),
                    response.body().getCancer().getBeauty(),
                    response.body().getCancer().getErotic(),
                    response.body().getCancer().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.LEO,
                    response.body().getLeo().getBusiness(),
                    response.body().getLeo().getCommon(),
                    response.body().getLeo().getLove(),
                    response.body().getLeo().getHealth(),
                    response.body().getLeo().getCar(),
                    response.body().getLeo().getBeauty(),
                    response.body().getLeo().getErotic(),
                    response.body().getLeo().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.VIRGO,
                    response.body().getVirgo().getBusiness(),
                    response.body().getVirgo().getCommon(),
                    response.body().getVirgo().getLove(),
                    response.body().getVirgo().getHealth(),
                    response.body().getVirgo().getCar(),
                    response.body().getVirgo().getBeauty(),
                    response.body().getVirgo().getErotic(),
                    response.body().getVirgo().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.LIBRA,
                    response.body().getLibra().getBusiness(),
                    response.body().getLibra().getCommon(),
                    response.body().getLibra().getLove(),
                    response.body().getLibra().getHealth(),
                    response.body().getLibra().getCar(),
                    response.body().getLibra().getBeauty(),
                    response.body().getLibra().getErotic(),
                    response.body().getLibra().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.SCORPIO,
                    response.body().getScorpio().getBusiness(),
                    response.body().getScorpio().getCommon(),
                    response.body().getScorpio().getLove(),
                    response.body().getScorpio().getHealth(),
                    response.body().getScorpio().getCar(),
                    response.body().getScorpio().getBeauty(),
                    response.body().getScorpio().getErotic(),
                    response.body().getScorpio().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.SAGITTARIUS,
                    response.body().getSagittarius().getBusiness(),
                    response.body().getSagittarius().getCommon(),
                    response.body().getSagittarius().getLove(),
                    response.body().getSagittarius().getHealth(),
                    response.body().getSagittarius().getCar(),
                    response.body().getSagittarius().getBeauty(),
                    response.body().getSagittarius().getErotic(),
                    response.body().getSagittarius().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.CAPRICORN,
                    response.body().getCapricorn().getBusiness(),
                    response.body().getCapricorn().getCommon(),
                    response.body().getCapricorn().getLove(),
                    response.body().getCapricorn().getHealth(),
                    response.body().getCapricorn().getCar(),
                    response.body().getCapricorn().getBeauty(),
                    response.body().getCapricorn().getErotic(),
                    response.body().getCapricorn().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.AQUARIUS,
                    response.body().getAquarius().getBusiness(),
                    response.body().getAquarius().getCommon(),
                    response.body().getAquarius().getLove(),
                    response.body().getAquarius().getHealth(),
                    response.body().getAquarius().getCar(),
                    response.body().getAquarius().getBeauty(),
                    response.body().getAquarius().getErotic(),
                    response.body().getAquarius().getGold()));
            weeklyHoroscopeList.add(new WeeklyHoroscope(week,date,Constants.PISCES,
                    response.body().getPisces().getBusiness(),
                    response.body().getPisces().getCommon(),
                    response.body().getPisces().getLove(),
                    response.body().getPisces().getHealth(),
                    response.body().getPisces().getCar(),
                    response.body().getPisces().getBeauty(),
                    response.body().getPisces().getErotic(),
                    response.body().getPisces().getGold()));


            Log.d("-------SIZE-SER------",String.valueOf(weeklyHoroscopeList.size()));
            transmitterList.transferWeeklyHoroscopes(weeklyHoroscopeList);

        }else{

            transmitterList.showError(Constants.ERROR_CONNECT);

            try {
                Log.e("TAG", "Retrofit Response: " + response.errorBody().string());
                Log.d("TAG", "Error message: " + response.raw().message());
                Log.d("TAG","Error code: " + String.valueOf(response.raw().code()));
            } catch (IOException e) {
                Log.d("TAG", String.valueOf(e.toString()));
                e.printStackTrace();
            }}

    }


    private String convertTypeWeek(String typeWeek){

        String type="";

        switch (typeWeek){

            case Constants.CUR_WEEK: type=Constants.CURRENT;
                break;
            case Constants.PREV_WEEK: type=Constants.LAST;
                break;

        }
        return  type;
    }

}
