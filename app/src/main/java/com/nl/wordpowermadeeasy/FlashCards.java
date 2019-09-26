package com.nl.wordpowermadeeasy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class FlashCards extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_cards);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CardView cardView = (CardView) findViewById(R.id.cardView);
        String s_id = getIntent().getExtras().getString("SESSION_ID");

        Toast.makeText(this, s_id, Toast.LENGTH_SHORT).show();

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
}
