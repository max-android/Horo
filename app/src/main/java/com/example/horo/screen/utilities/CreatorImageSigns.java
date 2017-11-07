package com.example.horo.screen.utilities;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.example.horo.model.Constants;

import java.io.IOException;
import java.io.InputStream;


public class CreatorImageSigns {

    private ImageView imageSign;
    private String sign;
    private Context context;

    public CreatorImageSigns(ImageView imageSign, String sign, Context context) {
        this.imageSign = imageSign;
        this.sign = sign;
        this.context = context;
    }

    public void createImage(){

       AssetManager assetManager=context.getAssets();

        try {
            InputStream stream=assetManager.open(convertSign(sign));

            Drawable drawable=Drawable.createFromStream(stream,sign.replace(".png",""));
            imageSign.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String convertSign(String sign){

        String type="";

        switch (sign){

            case Constants.ARIES: type=Constants.FILE_ARIES;
                break;
            case Constants.TAURUS: type=Constants.FILE_TAURUS;
                break;
            case Constants.GEMINI: type=Constants.FILE_GEMINI;
                break;
            case Constants.CANCER: type=Constants.FILE_CANCER;
                break;
            case Constants.LEO: type=Constants.FILE_LEO;
                break;
            case Constants.VIRGO: type=Constants.FILE_VIRGO;
                break;
            case Constants.LIBRA: type=Constants.FILE_LIBRA;
                break;
            case Constants.SCORPIO: type=Constants.FILE_SCORPIO;
                break;
            case Constants.SAGITTARIUS: type=Constants.FILE_SAGITTARIUS;
                break;

            case Constants.CAPRICORN: type=Constants.FILE_CAPRICORN;
                break;
            case Constants.AQUARIUS: type=Constants.FILE_AQUARIUS;
                break;
            case Constants.PISCES: type=Constants.FILE_PISCES;
                break;

        }

        return type;

    }




}
