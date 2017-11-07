package com.example.horo.di;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;


public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }



    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .horoServiceModule(new HoroServiceModule())
                .databaseModule(new DatabaseModule(this))
                //.horoDatabaseModule(new HoroDatabaseModule(this))
                .build();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


        MultiDex.install(this);
    }
}
