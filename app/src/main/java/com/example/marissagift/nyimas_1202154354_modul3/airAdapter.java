package com.example.marissagift.nyimas_1202154354_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;  //glide=image loading library agar tidak banyak mengkonsumsi memory
import java.util.ArrayList;

/**
 * Created by HP on 2/24/2018.
 */

class airAdapter extends RecyclerView.Adapter<airAdapter.AirViewHolder>{
    private ArrayList<air> mAirData;
    private GradientDrawable mGradientDrawable;
    private Context mContext;

    //membuat context terlebih dahulu
    airAdapter(Context context, ArrayList<air> airData){
        this.mAirData = airData;
        this.mContext = context;

        //menyiapkan placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //membuat placeholder yang sama ukurannya dengan gambar
        Drawable drawable = ContextCompat.getDrawable
                (mContext,R.drawable.ades);
        if(drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }
    @Override
    public AirViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AirViewHolder(mContext, LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(AirViewHolder holder, int position) {
        air currentAir = mAirData.get(position);

        holder.bindTo(currentAir);
    }

    @Override
    public int getItemCount() {
        return mAirData.size();
    }

    static class AirViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mAirImage;
        private Context mContext;
        private air mCurrentAir;
        private GradientDrawable mGradientDrawable;

        AirViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);
            mTitleText = (TextView)itemView.findViewById(R.id.title);
            mInfoText = (TextView)itemView.findViewById(R.id.subTitle);
            mAirImage = (ImageView)itemView.findViewById(R.id.airImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set OnClickListener ke semua view
            itemView.setOnClickListener(this);
        }

        public void bindTo(air currentAir) {
            mTitleText.setText(currentAir.getTitle());
            mInfoText.setText(currentAir.getInfo());

            //Get air saat ini
            mCurrentAir = currentAir;

            //load gambar ke imageView menggunakan glide library
            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentAir.
                    getImageResource()).placeholder(mGradientDrawable).into(mAirImage);
        }

        //method onClick berisi intent
        @Override
        public void onClick(View view) {
            Intent detail = air.starter(mContext, mCurrentAir.getTitle(), mCurrentAir.getImageResource());

            mContext.startActivity(detail);
        }
    }


}