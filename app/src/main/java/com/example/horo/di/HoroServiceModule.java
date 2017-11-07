package com.example.horo.di;

import android.support.annotation.NonNull;

import com.example.horo.model.Constants;
import com.example.horo.model.service.HoroService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;


@Module
@Singleton
public class HoroServiceModule {


    @Provides
    @Singleton
    public Retrofit provideRetrofit(){

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_FORECAST)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();
    }


    @Provides
    @Singleton
    public HoroService createHoroService(@NonNull Retrofit retrofit){

        return retrofit.create(HoroService.class);

    }

}
