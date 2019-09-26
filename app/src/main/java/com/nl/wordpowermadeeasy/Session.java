package com.nl.wordpowermadeeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TabHost;

import java.util.ArrayList;

public class Session extends AppCompatActivity {

    private Button home;
    private static final String TAG = "Session";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();

        Log.d(TAG, "onCreate: started.");
        snumbers();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //common.onBackClickAnimation(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        try {
            final int mid = item.getItemId();

            if (mid == android.R.id.home) {
                super.onBackPressed();
                //common.onBackClickAnimation(this);
            }

        } catch (Exception ex) {
        }
        return super.onOptionsItemSelected(item);
    }

    private void snumbers(){
        Log.d(TAG, "snumbers: preparing session groups");

        mNames.add("Session 1-8");
        mNames.add("Session 9-16");
        mNames.add("Session 17-24");
        mNames.add("Session 25-32");
        mNames.add("Session 33-40");
        mNames.add("Session 41-47");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recycler view.");
        RecyclerView recyclerView = findViewById(R.id.r_view);
        RecyclerViewAdapter_S adapter_s = new RecyclerViewAdapter_S(this, mNames);
        recyclerView.setAdapter(adapter_s);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
