package com.example.horo.model.service;


import com.example.horo.model.service.pojo.daily.HoroDaily;
import com.example.horo.model.service.pojo.weekly.HoroWeekly;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface HoroService {



    @GET("{type}.xml")
    public Call<HoroWeekly> horoWeekly(@Path("type") String type);


    @GET("{type}.xml")
    public Call<HoroDaily> horoDaily(@Path("type") String type);

}
