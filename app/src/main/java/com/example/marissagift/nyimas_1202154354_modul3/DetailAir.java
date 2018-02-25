package com.example.marissagift.nyimas_1202154354_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailAir extends AppCompatActivity {
    int water_val = 0;
    ImageView v, airImageDetail;
    TextView Titledetail, water_counter;
    int i, max_val, min_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_air);

        TextView airTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView airImage = (ImageView)findViewById(R.id.airImageDetail);
        v = (ImageView)findViewById(R.id.galon);



        v.setImageLevel(water_val);
        Toast def = Toast.makeText(getApplicationContext(), "Airnya Sedikit", Toast.LENGTH_SHORT);
        def.show();

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(air.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        airTitle.setText(getIntent().getStringExtra(air.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(air.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(airImage);
    }

    public void decreaseVal(View view) {
        v = (ImageView)findViewById(R.id.galon);
        water_counter = (TextView)findViewById(R.id.water_count);
        min_val = 0;
        if(water_val > 0) {
            water_val--;
            v.setImageLevel(water_val);
            water_counter.setText(String.valueOf(water_val) + " L");
            if( water_val == 0 ) {
                Toast max = Toast.makeText(getApplicationContext(), "Air kamu Sedikit", Toast.LENGTH_LONG);
                max.show();
            }
        }

    }

    public void increaseVal(View view) {
        v = (ImageView)findViewById(R.id.galon);
        water_counter = (TextView)findViewById(R.id.water_count);
        max_val = 6;
        if(water_val < max_val) {
            water_val++;
            v.setImageLevel(water_val);
            water_counter.setText(String.valueOf(water_val + " L"));
            if( water_val == max_val ) {
                Toast max = Toast.makeText(getApplicationContext(), "Air kamu sudah penuh", Toast.LENGTH_LONG);
                max.show();
            }
        }
    }
}
