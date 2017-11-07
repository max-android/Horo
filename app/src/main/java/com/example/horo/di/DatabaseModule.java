package com.example.horo.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.horo.model.Constants;
import com.example.horo.model.database.AppBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;




@Module
@Singleton
public class DatabaseModule {

    private Context context;


    public DatabaseModule(Context context) {
        this.context = context;
    }


    @Provides
    @Singleton
public AppBase provideDatabase(){

        AppBase base= Room.databaseBuilder(
                context,AppBase.class, Constants.DB_NAME
        ).allowMainThreadQueries()
                .build();

        return base;
                            }
}
