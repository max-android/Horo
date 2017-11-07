package com.example.horo.di;

import com.example.horo.screen.horoscopes.HoroActivity;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {HoroServiceModule.class,
                    DatabaseModule.class
})

public interface AppComponent {

    void injectHoroActivity(HoroActivity activity);

}



