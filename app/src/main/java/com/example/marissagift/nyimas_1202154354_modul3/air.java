package com.example.marissagift.nyimas_1202154354_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by HP on 2/24/2018.
 */

class air { //kelas ini digunakan untuk mengambil resource untuk ditempatkan ke holder

    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    //dibawah ini merupakan konstruktor data yg akan ditampung di holder
    air(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    //baris dibawah ini merupakan getter untuk nama air minum
    public String getTitle() {
        return title;
    }

    //baris dibawah ini merupakan getter untuk info air minum
    public String getInfo() {
        return info;
    }

    //baris dibawah ini merupakan getter untuk foto air minum
    public int getImageResource() {
        return imageResource;
    }


    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailAir.class);
        detailIntent.putExtra(TITLE_KEY, title);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
