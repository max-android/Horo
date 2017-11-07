package com.example.horo.model.service;

import android.util.Log;

import com.example.horo.model.Constants;
import com.example.horo.model.TransmitterList;
import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.service.pojo.daily.HoroDaily;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class DailyHoroService {


    private HoroService horoService;
    private String typeDaily;
    private TransmitterList transmitterList;


    private ArrayList<DailyHoroscope> dailyHoroList;


    public DailyHoroService(HoroService horoService, String typeDaily, TransmitterList transmitterList) {
        this.horoService = horoService;
        this.typeDaily = typeDaily;
        this.transmitterList = transmitterList;
    }

    public void executeDailyHoroService(){

        createDailyHoroscope();

    }

private void createDailyHoroscope(){

    dailyHoroList=new ArrayList<>();

    horoService.horoDaily(typeDaily).enqueue(new Callback<HoroDaily>() {
        @Override
        public void onResponse(Call<HoroDaily> call, Response<HoroDaily> response) {

                getDailyHoro(dailyHoroList,response);

        }

        @Override
        public void onFailure(Call<HoroDaily> call, Throwable t) {

            transmitterList.showError(Constants.ERROR_NETWORK);

        }
    });


}

private void getDailyHoro(ArrayList<DailyHoroscope> dailyHoroList,Response<HoroDaily> response){

    if (response.isSuccessful()) {


        String dateYesterday = response.body().getDate().getYesterday();
        String dateToday = response.body().getDate().getToday();
        String dateTomorrow = response.body().getDate().getTomorrow();
        String dateTomorrow2 = response.body().getDate().getTomorrow02();


        String type=convertTypeHoro(typeDaily);

        dailyHoroList.add(new DailyHoroscope(type,Constants.ARIES,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getAries().getYesterday(),
                response.body().getAries().getToday(),
                response.body().getAries().getTomorrow(),
                response.body().getAries().getTomorrow02()
                ));

        dailyHoroList.add(new DailyHoroscope(type,Constants.TAURUS,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getTaurus().getYesterday(),
                response.body().getTaurus().getToday(),
                response.body().getTaurus().getTomorrow(),
                response.body().getTaurus().getTomorrow02()
        ));

        dailyHoroList.add(new DailyHoroscope(type,Constants.GEMINI,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getGemini().getYesterday(),
                response.body().getGemini().getToday(),
                response.body().getGemini().getTomorrow(),
                response.body().getGemini().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.CANCER,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getCancer().getYesterday(),
                response.body().getCancer().getToday(),
                response.body().getCancer().getTomorrow(),
                response.body().getCancer().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.LEO,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getLeo().getYesterday(),
                response.body().getLeo().getToday(),
                response.body().getLeo().getTomorrow(),
                response.body().getLeo().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.VIRGO,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getVirgo().getYesterday(),
                response.body().getVirgo().getToday(),
                response.body().getVirgo().getTomorrow(),
                response.body().getVirgo().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.LIBRA,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getLibra().getYesterday(),
                response.body().getLibra().getToday(),
                response.body().getLibra().getTomorrow(),
                response.body().getLibra().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.SCORPIO,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getScorpio().getYesterday(),
                response.body().getScorpio().getToday(),
                response.body().getScorpio().getTomorrow(),
                response.body().getScorpio().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.SAGITTARIUS,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getSagittarius().getYesterday(),
                response.body().getSagittarius().getToday(),
                response.body().getSagittarius().getTomorrow(),
                response.body().getSagittarius().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.CAPRICORN,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getCapricorn().getYesterday(),
                response.body().getCapricorn().getToday(),
                response.body().getCapricorn().getTomorrow(),
                response.body().getCapricorn().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.AQUARIUS,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getAquarius().getYesterday(),
                response.body().getAquarius().getToday(),
                response.body().getAquarius().getTomorrow(),
                response.body().getAquarius().getTomorrow02()
        ));
        dailyHoroList.add(new DailyHoroscope(type,Constants.PISCES,
                dateYesterday,
                dateToday,
                dateTomorrow,
                dateTomorrow2,
                response.body().getPisces().getYesterday(),
                response.body().getPisces().getToday(),
                response.body().getPisces().getTomorrow(),
                response.body().getPisces().getTomorrow02()
        ));

        transmitterList.transferDailyHoroscopes(dailyHoroList);

    }else{

        transmitterList.showError(Constants.ERROR_CONNECT);
        try {
            Log.e("TAG", "Retrofit Response: " + response.errorBody().string());
            Log.d("TAG", "Error message: " + response.raw().message());
            Log.d("TAG","Error code: " + String.valueOf(response.raw().code()));
        } catch (IOException e) {
            Log.d("TAG", String.valueOf(e.toString()));
            e.printStackTrace();
        }
    }

}

    private String convertTypeHoro(String typeDaily){

        String type="";

        switch (typeDaily){

            case Constants.COM_DAILY: type=Constants.COMMON;
            break;
            case Constants.ERO_DAILY: type=Constants.EROTIC;
                break;
            case Constants.ANTI_DAILY: type=Constants.ANTI;
                break;
            case Constants.BIS_DAILY: type=Constants.BISNESS;
                break;
            case Constants.HEA_DAILY: type=Constants.HEALTH;
                break;
            case Constants.COOK_DAILY: type=Constants.COOK;
                break;
            case Constants.LOV_DAILY: type=Constants.LOVE;
                break;
            case Constants.MOB_DAILY: type=Constants.MOBILE;
                break;
        }

        return type;
    }

}
