package com.example.horo.screen.zodiacs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.horo.model.Constants;
import com.example.horo.model.database.entities.DailyHoroscope;
import com.example.horo.model.database.entities.WeeklyHoroscope;
import com.example.horo.screen.detailhoro.DetailHoroDayActivity;
import com.example.horo.screen.detailhoro.TypesHoroWeekActivity;

import java.util.ArrayList;

import exampleprilognew.ru.horo.R;

public class ZodiacSignsActivity extends AppCompatActivity implements ZodiacWeeklyAdapter.ZodiacWeeklyClickListener,ZodiacDailyAdapter.ZodiacDailyClickListener {


    private CoordinatorLayout coordinatZodiacSigns;
    private Toolbar toolbarZodiac;

    private RecyclerView recyclerWeekHoro;

    private ZodiacDailyAdapter zodiacDailyAdapter;
    private ZodiacWeeklyAdapter zodiacWeeklyAdapter;
    private ProgressBar horoBar;
    private boolean statusHoro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac_signs);

        initComponents();

        createListZodiacSigns();

        createItemTouch();

    }

    private void initComponents(){

      toolbarZodiac = (Toolbar)findViewById(R.id.toolbarZodiac);
        setSupportActionBar(toolbarZodiac);
        coordinatZodiacSigns=(CoordinatorLayout)findViewById(R.id.coordinatZodiacSigns);
        recyclerWeekHoro=(RecyclerView)findViewById(R.id.rvZodiacSigns);

        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this);
        recyclerWeekHoro.setLayoutManager(mLayoutManager);
        recyclerWeekHoro.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        horoBar=(ProgressBar)findViewById(R.id.horoProgress);
        horoBar.setVisibility(View.VISIBLE);
    }


    private void createItemTouch(){

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerWeekHoro);

    }

    private void createListZodiacSigns() {

        Intent intentListZodiacSigns = getIntent();

        if (getIntent().hasExtra(Constants.WEEK_HORO)){
           statusHoro =true;


        ArrayList<WeeklyHoroscope> weeklyHoroscopeList = (ArrayList<WeeklyHoroscope>) intentListZodiacSigns.getSerializableExtra(Constants.WEEK_HORO);

            zodiacWeeklyAdapter = new ZodiacWeeklyAdapter(weeklyHoroscopeList, this);

        recyclerWeekHoro.setAdapter(zodiacWeeklyAdapter);

    }

        if (getIntent().hasExtra(Constants.DAILY_HORO)){
            statusHoro =false;

            ArrayList<DailyHoroscope> dailyHoroList = (ArrayList<DailyHoroscope>) intentListZodiacSigns.getSerializableExtra(Constants.DAILY_HORO);

            zodiacDailyAdapter=new ZodiacDailyAdapter(dailyHoroList, this);

            recyclerWeekHoro.setAdapter(zodiacDailyAdapter);

        }

        String selectSign = getResources().getString(R.string.select_sign);
        toolbarZodiac.setSubtitle(selectSign);
        horoBar.setVisibility(View.INVISIBLE);
    }


    private void launchListTypesHoroWeek(WeeklyHoroscope weeklyHoroscope){

        Intent intentListTypesHoroWeek=new Intent(this,TypesHoroWeekActivity.class);

        intentListTypesHoroWeek.putExtra(Constants.ZODIAC_WEEK_HORO, weeklyHoroscope);

        startActivity(intentListTypesHoroWeek);

    }

    private void launchDetailHoroDay(DailyHoroscope dailyHoro,View view){

        Intent intentDetailHoroDay=new Intent(this,DetailHoroDayActivity.class);
        intentDetailHoroDay.putExtra(Constants.DETAIL_DAY_HORO,dailyHoro);

        TextView tvZodiac=(TextView) view;

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(this,tvZodiac,Constants.TRANSITION_DAILY);


                 startActivity(intentDetailHoroDay,options.toBundle());

    }

    @Override
    public void onZodiacWeeklyClick(WeeklyHoroscope weeklyHoroscope) {
        launchListTypesHoroWeek(weeklyHoroscope);
    }


    @Override
    public void onZodiacDailyClick(DailyHoroscope dailyHoro,View view) {

        launchDetailHoroDay(dailyHoro,view);
    }




    private ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT |ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

                 int fromPosition = viewHolder.getAdapterPosition();
                 int toPosition = target.getAdapterPosition();

            if(statusHoro){
                ZodiacWeeklyAdapter adapter=(ZodiacWeeklyAdapter)recyclerWeekHoro.getAdapter();

                adapter.adOnMove(fromPosition,toPosition);

            }else{

                ZodiacDailyAdapter adapter=(ZodiacDailyAdapter)recyclerWeekHoro.getAdapter();

                adapter.adOnMove(fromPosition,toPosition);

            }

            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

           // int swipedPosition = viewHolder.getAdapterPosition();

            if(statusHoro){
                ZodiacWeeklyAdapter adapter=(ZodiacWeeklyAdapter)recyclerWeekHoro.getAdapter();

               // adapter.remove(swipedPosition);
                adapter.adOnSwiped(viewHolder);

            }else{

                ZodiacDailyAdapter adapter=(ZodiacDailyAdapter)recyclerWeekHoro.getAdapter();

               // adapter.remove(swipedPosition);
                adapter.adOnSwiped(viewHolder);

            }

        }
    };


}




