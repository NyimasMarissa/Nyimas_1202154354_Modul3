package com.example.marissagift.nyimas_1202154354_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Collections;

public class Home extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<air> airData;
    private airAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //deklarasi akan menampilkan berapa kolom pada grid
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //mem
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //Set Layout Manager untuk mengatur layout recyclerView dan Grid
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,gridColumnCount));

        //menginisiasi ArrayList yang berisi data
        airData = new ArrayList<>();

        //menginisiasi adapter dan set ke RecyclerView
        mAdapter = new airAdapter(this, airData);
        mRecyclerView.setAdapter(mAdapter);

        //menjalankan method ini initializeData
        initializeData();

        //s
        int swipeDirs;
        if(gridColumnCount > 1){

            swipeDirs = 0;

        } else {

            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

        }
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback
                (ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT | ItemTouchHelper.DOWN
                        | ItemTouchHelper.UP, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            //agar dapat diubah posisi viewHolder nya
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                //Swap items lalu notify adapter
                Collections.swap(airData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                airData.remove(viewHolder.getAdapterPosition());

                //Notify adapter
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });
        helper.attachToRecyclerView(mRecyclerView);
    }
    //method initializeData untuk mendapatkan gambar minuman, nama merek dan informasi minuman
    private void initializeData(){

        String[] airList = getResources().getStringArray(R.array.air_titles);
        String[] airInfo = getResources().getStringArray(R.array.air_info);
        TypedArray airImageResources = getResources().obtainTypedArray(R.array.air_image);

        for(int i=0; i<airList.length; i++){
            airData.add(new air(airList[i], airInfo[i],
                    airImageResources.getResourceId(i,0)));
        }
        airImageResources.recycle();
    }

    public void resetAir(View view) {
        initializeData();
    }
}