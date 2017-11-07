package com.example.horo.screen.zodiacs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.horo.model.database.entities.DailyHoroscope;

import java.util.Collections;
import java.util.List;

import exampleprilognew.ru.horo.R;


public class ZodiacDailyAdapter extends RecyclerView.Adapter<ZodiacDailyAdapter.ZodiacViewHolder>  {


    private final List<DailyHoroscope> zodiacList;
    private final ZodiacDailyClickListener listener;


    public ZodiacDailyAdapter(List<DailyHoroscope> zodiacList, ZodiacDailyClickListener listener) {
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

        DailyHoroscope dailyHoro= zodiacList.get(position);

        holder.bindTo(dailyHoro);

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


    public void adOnSwiped(RecyclerView.ViewHolder viewHolder) {
        int swipedPosition = viewHolder.getAdapterPosition();
        zodiacList.remove(swipedPosition);
        notifyItemRemoved(swipedPosition);
    }


    public void adOnMove(int fromPos,int toPos) {

        Collections.swap(zodiacList,fromPos,toPos);
        notifyItemMoved(fromPos, toPos);
    }



    public class ZodiacViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvZodiac;

        private DailyHoroscope dailyHoro;

        public ZodiacViewHolder(View itemView,final ZodiacDailyClickListener listener){
            super(itemView);

            tvZodiac=(TextView)itemView.findViewById(R.id.tvSign);

            itemView.setOnClickListener((view -> launchHoroscopesSign(dailyHoro,view,tvZodiac)));

        }

        private void launchHoroscopesSign(DailyHoroscope dailyHoro,View view,View tvZodiac){

            listener.onZodiacDailyClick(dailyHoro, tvZodiac);

        }


        public void bindTo(DailyHoroscope dailyHoro) {

            this.dailyHoro = dailyHoro;

            tvZodiac.setText(dailyHoro.getZodiac());

        }
    }

    public interface ZodiacDailyClickListener{

        void onZodiacDailyClick(DailyHoroscope dailyHoro, View tvZodiac);
    }

}
