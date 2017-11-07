package com.example.horo.screen.detailhoro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horo.model.Constants;
import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.screen.utilities.CreatorImageSigns;

import java.util.ArrayList;
import java.util.List;

import exampleprilognew.ru.horo.R;


public class DetailHoroDayActivity extends AppCompatActivity {

    private TextView tvDayHoroscope;
    private Toolbar toolbarDetailDayHoro;
    private DailyHoroscope dailyHoro;

    private String sign;
    private String date;
    private String typeHoro;
    private BottomNavigationView navigationDailyHoro;
    private ImageView imageSign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_horo_day);

        initComponents();

        createDetailHoroDay();

        CreatorImageSigns creatorImageSigns=new CreatorImageSigns(imageSign,sign,this);
                          creatorImageSigns.createImage();

        defaultTodayForecast();

        createNavigationMenu();
    }

    private void initComponents(){

        toolbarDetailDayHoro = (Toolbar)findViewById(R.id.toolbarDetailDayHoro);
        setSupportActionBar(toolbarDetailDayHoro);
        tvDayHoroscope=(TextView)findViewById(R.id.tvDayHoroscope);
        navigationDailyHoro = (BottomNavigationView) findViewById(R.id.navigationDailyHoro);
        imageSign=(ImageView) findViewById(R.id.imageDaily);
        navigationDailyHoro.setOnNavigationItemSelectedListener(item ->selectDayForForecast(item) );
    }

    private boolean selectDayForForecast(@NonNull MenuItem item){

        switch (item.getItemId()) {
            case 0:
                String horoYesterday = dailyHoro.getHoroYesterday();
                tvDayHoroscope.setText(horoYesterday);
                date=dailyHoro.getDateYesterday();
                toolbarDetailDayHoro.setSubtitle(sign+": "+typeHoro+" "+date);

                return true;

            case 1:
                defaultTodayForecast();
                return true;

            case 2:
                String horoTomorrow = dailyHoro.getHoroTomorrow();

                tvDayHoroscope.setText(horoTomorrow);
                date=dailyHoro.getDateTomorrow();
                toolbarDetailDayHoro.setSubtitle(sign+": "+typeHoro+" "+date);
                return true;

            case 3:
                String horoTomorrow02 = dailyHoro.getHoroTomorrow02();
                tvDayHoroscope.setText(horoTomorrow02);
                date=dailyHoro.getDateTomorrow02();
                toolbarDetailDayHoro.setSubtitle(sign+": "+typeHoro+" "+date);
                return true;
        }
        return false;

    }


    private void createDetailHoroDay(){

        Intent intentDetailHoroWeek=getIntent();

        dailyHoro=(DailyHoroscope)intentDetailHoroWeek.getSerializableExtra(Constants.DETAIL_DAY_HORO);

        sign=dailyHoro.getZodiac();

        typeHoro=dailyHoro.getTypeHoro();

    }

    private void defaultTodayForecast(){

        String horoToday = dailyHoro.getHoroToday();
        sign=dailyHoro.getZodiac();
        tvDayHoroscope.setText(horoToday);
        date=dailyHoro.getDateToday();

        toolbarDetailDayHoro.setSubtitle(sign+": "+typeHoro+" "+date);

    }

    private void createNavigationMenu(){


        List<String> date = createDateList(dailyHoro);

        Menu menu = navigationDailyHoro.getMenu();
        for (int i = 0; i < Constants.AMOUNT_ITEM; i++) {

            menu.add(Menu.NONE,i,Menu.NONE,date.get(i));
            menu.getItem(i).setIcon(R.drawable.ic_date_range_black_24dp);

        }

        menu.getItem(1).setChecked(true);
    }



    private List<String> createDateList(DailyHoroscope dailyHoro){

        List<String> dateList= new ArrayList<>();
        dateList.add(dailyHoro.getDateYesterday());
        dateList.add(dailyHoro.getDateToday());
        dateList.add(dailyHoro.getDateTomorrow());
        dateList.add(dailyHoro.getDateTomorrow02());

        return dateList;

    }

}
