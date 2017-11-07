package com.example.horo.screen.horoscopes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.horo.di.App;
import com.example.horo.model.Constants;
import com.example.horo.model.TransmitterList;
import com.example.horo.model.database.AppBase;
import com.example.horo.model.database.DataBaseManager;
import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;
import com.example.horo.model.service.DailyHoroService;
import com.example.horo.model.service.HoroService;
import com.example.horo.model.service.WeeklyHoroService;
import com.example.horo.screen.utilities.Info;
import com.example.horo.screen.utilities.NetInspector;
import com.example.horo.screen.zodiacs.ZodiacSignsActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import exampleprilognew.ru.horo.R;


public class HoroActivity extends AppCompatActivity implements TransmitterList {

    private TextView tvWeekCurHoro;
    private TextView tvWeekLastHoro;
    private TextView tvCommonHoro;
    private TextView tvEroticHoro;
    private TextView tvAntiHoro;
    private TextView tvBiznessHoro;
    private TextView tvHealthHoro;
    private TextView tvCookHoro;
    private TextView tvLoveHoro;
    private TextView tvMobHoro;
    private boolean statusNet;
    private DataBaseManager dbManager;
    private Info info;

    @Inject
    public HoroService horoService;

       @Inject
       public AppBase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horo);

        App.getAppComponent().injectHoroActivity(this);

        initComponent();

        choiceHoroscopes();
    }

    private void initComponent(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarHoro);
        setSupportActionBar(toolbar);
        CoordinatorLayout coordinatorLayout =(CoordinatorLayout)findViewById(R.id.coordinatHoro);
        tvCommonHoro=(TextView)findViewById(R.id.tvCommonHoro);
        tvEroticHoro=(TextView)findViewById(R.id.tvEroticHoro);
        tvAntiHoro =(TextView)findViewById(R.id.tvAntiHoro);
        tvBiznessHoro=(TextView)findViewById(R.id.tvBiznessHoro);
        tvHealthHoro=(TextView)findViewById(R.id.tvHealthHoro);
        tvCookHoro=(TextView)findViewById(R.id. tvCookHoro);
        tvLoveHoro=(TextView)findViewById(R.id. tvLoveHoro);
        tvMobHoro=(TextView)findViewById(R.id.tvMobHoro);
        tvWeekCurHoro=(TextView)findViewById(R.id.tvWeekCurHoro);
        tvWeekLastHoro=(TextView)findViewById(R.id.tvWeekLastHoro);
        dbManager=new DataBaseManager(database);
        info = new Info(coordinatorLayout,this);
    }

    private void choiceHoroscopes(){

        View.OnClickListener listener=(v ->{
            statusNet = NetInspector.isOnline(this);
            switch (v.getId()){
                case R.id.tvCommonHoro:
                    if(statusNet){launchDailyHoroService(Constants.COM_DAILY);
                    }else{if(database.getHoroDao().getTypeDailyHoro(Constants.COMMON).size()!=0){
                                    List<DailyHoroscope> list = database.getHoroDao().getTypeDailyHoro(Constants.COMMON);
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.COMMON));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvEroticHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.ERO_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.EROTIC).size()!=0){launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.EROTIC));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvAntiHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.ANTI_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.ANTI).size()!=0){
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.ANTI));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvBiznessHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.BIS_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.BISNESS).size()!=0){launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.BISNESS));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvHealthHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.HEA_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.HEALTH).size()!=0){
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.HEALTH));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvCookHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.COOK_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.COOK).size()!=0){
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.COOK));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvLoveHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.LOV_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.LOVE).size()!=0){
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.LOVE));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvMobHoro:
                    if(statusNet){
                        launchDailyHoroService(Constants.MOB_DAILY);
                    }else{
                        if(database.getHoroDao().getTypeDailyHoro(Constants.MOBILE).size()!=0){
                            launchDailyHoro(dbManager.launchDailyHoroFromBD(Constants.MOBILE));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvWeekCurHoro:
                    if(statusNet){
                        launchWeekHoroService(Constants.CUR_WEEK);
                    }else{
                        if(database.getHoroDao().getTypeWeeklyHoro(Constants.CURRENT).size()!=0){
                            launchWeekHoro(dbManager.launchWeeklyHoroFromBD(Constants.CURRENT));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
                case R.id.tvWeekLastHoro:
                    if(statusNet){
                        launchWeekHoroService(Constants.PREV_WEEK);
                    }else{
                        if(database.getHoroDao().getTypeWeeklyHoro(Constants.LAST).size()!=0){
                            launchWeekHoro(dbManager.launchWeeklyHoroFromBD(Constants.LAST));
                        }else{
                            info.showMessage(Constants.NOT_NETWORK);
                        }
                    }
                    break;
            }

        } );
        tvCommonHoro.setOnClickListener(listener);
        tvEroticHoro.setOnClickListener(listener);
        tvAntiHoro.setOnClickListener(listener);
        tvBiznessHoro.setOnClickListener(listener);
        tvHealthHoro.setOnClickListener(listener);
        tvCookHoro.setOnClickListener(listener);
        tvLoveHoro.setOnClickListener(listener);
        tvMobHoro.setOnClickListener(listener);
        tvWeekCurHoro.setOnClickListener(listener);
        tvWeekLastHoro.setOnClickListener(listener);
    }


    private  void   launchDailyHoroService(String dayType){

        DailyHoroService dailyHoroService=new DailyHoroService(horoService,dayType,this);
        dailyHoroService.executeDailyHoroService();
    }

    private  void launchDailyHoro(ArrayList<DailyHoroscope> listHoro){

        Intent intentListZodiacSigns=new Intent(this,ZodiacSignsActivity.class);
        intentListZodiacSigns.putExtra(Constants.DAILY_HORO,listHoro);
        startActivity(intentListZodiacSigns);
    }

    @Override
    public void transferDailyHoroscopes(ArrayList<DailyHoroscope> dailyHoroList) {

        launchDailyHoro(dailyHoroList);
          dbManager.saveDailyHoroIntoDB(dailyHoroList);
    }

    @Override
    public void showError(String error) {

        info.showMessage(error);
    }

    private void launchWeekHoroService(String weekType){

        WeeklyHoroService weekHoroService=new WeeklyHoroService(horoService,weekType,this);
        weekHoroService.executeWeekHoroService();
    }

    private  void launchWeekHoro(ArrayList<WeeklyHoroscope> listHoro){

        Intent intentListZodiacSigns=new Intent(this,ZodiacSignsActivity.class);
        intentListZodiacSigns.putExtra(Constants.WEEK_HORO,listHoro);
        startActivity(intentListZodiacSigns);
    }

    @Override
    public void transferWeeklyHoroscopes(ArrayList<WeeklyHoroscope> weeklyHoroscopeList) {

        launchWeekHoro(weeklyHoroscopeList);

        dbManager.saveWeeklyHoroIntoDB(weeklyHoroscopeList);
    }
}


