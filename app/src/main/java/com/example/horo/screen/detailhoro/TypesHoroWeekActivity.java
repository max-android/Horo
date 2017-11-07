package com.example.horo.screen.detailhoro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.horo.model.Constants;
import com.example.horo.model.database.entities.WeeklyHoroscope;

import exampleprilognew.ru.horo.R;


public class TypesHoroWeekActivity extends AppCompatActivity {


    private Toolbar toolbarTypeWeekHoro;
    private WeeklyHoroscope weeklyHoroscope;
    private TextView tvBiznessWeekHoro;
    private TextView tvCommonWeekHoro;
    private TextView tvLoveWeekHoro;
    private TextView tvHealthWeekHoro;
    private TextView tvCarWeekHoro;
    private TextView tvBeautyWeekHoro;
    private TextView tvEroticWeekHoro;
    private TextView tvGoldWeekHoro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types_horo_week);

        initComponents();

        createListTypesHoroWeek();

        choiceTypesHoroWeek();

    }


    private void choiceTypesHoroWeek(){

        tvBiznessWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvBiznessWeekHoro.getText().toString(), weeklyHoroscope.getBusinessHoro()))));
        tvCommonWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvCommonWeekHoro.getText().toString(), weeklyHoroscope.getCommonHoro()))));
        tvLoveWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(), tvLoveWeekHoro.getText().toString(), weeklyHoroscope.getLoveHoro()))));
        tvHealthWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvHealthWeekHoro.getText().toString(), weeklyHoroscope.getHealthHoro()))));
        tvCarWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvCarWeekHoro.getText().toString(), weeklyHoroscope.getCarHoro()))));
        tvBeautyWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvBeautyWeekHoro.getText().toString(), weeklyHoroscope.getBeautyHoro()))));
        tvEroticWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvEroticWeekHoro.getText().toString(), weeklyHoroscope.getEroticHoro()))));
        tvGoldWeekHoro.setOnClickListener((v -> launchDetailHoroWeek(v,new DetailWeekHoro(weeklyHoroscope.getZodiac(),tvGoldWeekHoro.getText().toString(), weeklyHoroscope.getGoldHoro()))));

    }


    private void initComponents(){

        toolbarTypeWeekHoro = (Toolbar)findViewById(R.id.toolbarTypeWeekHoro);
        setSupportActionBar(toolbarTypeWeekHoro);

        tvBiznessWeekHoro=(TextView)findViewById(R.id.tvBiznessWeekHoro);
        tvCommonWeekHoro=(TextView)findViewById(R.id.tvCommonWeekHoro);
        tvLoveWeekHoro=(TextView)findViewById(R.id.tvLoveWeekHoro);
        tvHealthWeekHoro=(TextView)findViewById(R.id.tvHealthWeekHoro);
        tvCarWeekHoro=(TextView)findViewById(R.id.tvCarWeekHoro);
        tvBeautyWeekHoro=(TextView)findViewById(R.id.tvBeautyWeekHoro);
        tvEroticWeekHoro=(TextView)findViewById(R.id.tvEroticWeekHoro);
        tvGoldWeekHoro=(TextView)findViewById(R.id.tvGoldWeekHoro);
    }

    private void createListTypesHoroWeek(){

        Intent intentListTypesHoroWeek = getIntent();

        weeklyHoroscope = (WeeklyHoroscope)intentListTypesHoroWeek.getSerializableExtra(Constants.ZODIAC_WEEK_HORO);

        String typeWeek=getResources().getString(R.string.type_horo_week_title2);
        String period= weeklyHoroscope.getDate();
        String sign= weeklyHoroscope.getZodiac();
        toolbarTypeWeekHoro.setSubtitle(sign+": "+typeWeek+" "+period);

    }


    private  void launchDetailHoroWeek(View v, DetailWeekHoro detailWeekHoro){

        Intent intentDetailHoroWeek=new Intent(this,DetailHoroWeekActivity.class);
        intentDetailHoroWeek.putExtra(Constants.DETAIL_WEEK_HORO,detailWeekHoro);

        TextView tvDetailHoroWeek=(TextView) v;

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,tvDetailHoroWeek,Constants.TRANSITION_WEEKLY);
        startActivity(intentDetailHoroWeek,options.toBundle());

    }

}
