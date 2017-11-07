package com.example.horo.screen.detailhoro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.horo.model.Constants;
import com.example.horo.screen.utilities.CreatorImageSigns;

import exampleprilognew.ru.horo.R;


public class DetailHoroWeekActivity extends AppCompatActivity {

    private Toolbar toolbarDetailWeekHoro;
    private DetailWeekHoro detailWeekHoro;
    private TextView tvWeekHoro;
    private ImageView imageSign;
    private String sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_horo_week);

        initComponents();


        createDetailHoroWeek();

        CreatorImageSigns creatorImageSigns=new CreatorImageSigns(imageSign,sign,this);
        creatorImageSigns.createImage();
    }

    private void initComponents() {

        toolbarDetailWeekHoro = (Toolbar) findViewById(R.id.toolbarDetailWeekHoro);
        setSupportActionBar(toolbarDetailWeekHoro);
        tvWeekHoro=(TextView)findViewById(R.id.tvWeekHoro);
        imageSign=(ImageView)findViewById(R.id.imageWeekly);
    }

    private void createDetailHoroWeek(){

        Intent intentDetailHoroWeek=getIntent();

        detailWeekHoro=(DetailWeekHoro)intentDetailHoroWeek.getSerializableExtra(Constants.DETAIL_WEEK_HORO);

        tvWeekHoro.setText(detailWeekHoro.getForecast());

        String typeForecast=detailWeekHoro.getTypeForecast().toLowerCase();
         sign=detailWeekHoro.getSign();
        toolbarDetailWeekHoro.setSubtitle(sign+": "+typeForecast);

    }

}
