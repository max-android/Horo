package com.example.horo.screen.zodiacs;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.horo.model.database.entities.WeeklyHoroscope;

import java.util.Collections;
import java.util.List;

import exampleprilognew.ru.horo.R;

public class ZodiacWeeklyAdapter extends RecyclerView.Adapter<ZodiacWeeklyAdapter.ZodiacViewHolder>  {

    private final List<WeeklyHoroscope> zodiacList;
    private final ZodiacWeeklyClickListener listener;


    public ZodiacWeeklyAdapter(List<WeeklyHoroscope> zodiacList, ZodiacWeeklyClickListener listener) {
        this.zodiacList = zodiacList;
        this.listener=listener;
    }

    @Override
    public ZodiacViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater=LayoutInflater.from(parent.getContext());

        View view=inflater.inflate(R.layout.zodiac_item,parent,false);

        return  new ZodiacViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(ZodiacViewHolder holder, int position) {

        WeeklyHoroscope weeklyHoroscope = zodiacList.get(position);

        holder.bindTo(weeklyHoroscope);

    }

    @Override
    public int getItemCount() {
        return zodiacList.size();
    }


    public void remove(int position) {
        if (position < 0 || position >= zodiacList.size()) {
            return;
        }
        zodiacList.remove(position);
        notifyItemRemoved(position);
    }
    public void adOnMove(int fromPos,int toPos) {

        Collections.swap(zodiacList,fromPos,toPos);
        notifyItemMoved(fromPos, toPos);
    }

    public void adOnSwiped(RecyclerView.ViewHolder viewHolder) {
        int swipedPosition = viewHolder.getAdapterPosition();
        zodiacList.remove(swipedPosition);

        notifyItemRemoved(swipedPosition);
    }


    public class ZodiacViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvZodiac;

        private WeeklyHoroscope weeklyHoroscope;

        public ZodiacViewHolder(View itemView,final ZodiacWeeklyClickListener listener){
            super(itemView);


            tvZodiac=(TextView)itemView.findViewById(R.id.tvSign);

            itemView.setOnClickListener(this::launchHoroscopesSign);

        }

        private void launchHoroscopesSign(View view){

            listener.onZodiacWeeklyClick(weeklyHoroscope);

        }


        public void bindTo(WeeklyHoroscope weeklyHoroscope) {

            this.weeklyHoroscope = weeklyHoroscope;

            tvZodiac.setText(weeklyHoroscope.getZodiac());

        }
    }

    public interface ZodiacWeeklyClickListener {

        void onZodiacWeeklyClick(WeeklyHoroscope weeklyHoroscope);
    }

}
