package com.nl.wordpowermadeeasy;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.text.CharacterIterator;
import java.util.ArrayList;

public class RecyclerViewAdapter_S extends RecyclerView.Adapter<RecyclerViewAdapter_S.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter_S";

    private ArrayList<String> sname = new ArrayList<>();
    private Context mContext;




    public RecyclerViewAdapter_S(Context mContext, ArrayList<String> sname) {
        this.mContext = mContext;
        this.sname = sname;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_session, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        Log.d(TAG, "onBindViewHolder:called.");

        holder.btsname.setText(this.sname.get(position));
        holder.s_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + sname.get(position));

                Toast.makeText(mContext, sname.get(position), Toast.LENGTH_SHORT).show();

            }
        });
        holder.btsname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + sname.get(position));

                Toast.makeText(mContext, sname.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, FlashCards.class);
                intent.putExtra("SESSION_ID", sname.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sname.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{


        RelativeLayout s_0;
        Button btsname;

        public ViewHolder(View itemView){
            super(itemView);
            s_0 = itemView.findViewById(R.id.sp);
            btsname = itemView.findViewById(R.id.s1);




        }
    }
}
