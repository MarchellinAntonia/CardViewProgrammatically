package com.example.chellin.cardviewprogrammatically;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context mContext;

    LinearLayout mLinearLayout;
    private TextView process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Riwayat Komplain");
        mContext = getApplicationContext();

        Complain complain;
        final ArrayList<Complain> complains = new ArrayList<>();

        complain = new Complain("pesaaaaaaaaaaaaaaaaaaaaaan1", "status1", "answer1", "tanggal1");
        complains.add(complain);
        complain = new Complain("pesan2", "status2", "answer2", "tanggal2");
        complains.add(complain);
        complain = new Complain("pesan3", "status3", "answer3", "tanggal3");
        complains.add(complain);
        complain = new Complain("pesan4", "status4", "answer4", "tanggal4");
        complains.add(complain);
        complain = new Complain("pesan5", "status5", "answer5", "tanggal5");
        complains.add(complain);

        mLinearLayout = (LinearLayout) findViewById(R.id.rl);

        process =  (TextView)findViewById(R.id.process_history_complain);
        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHistory(complains);
            }
        });

    }


    private void showHistory(List<Complain> complain) {

        ((ViewGroup) process.getParent()).removeView(process);

        for(int i=0;i<complain.size();i++){

            // Initialize a new CardView
            CardView card = new CardView(this);
            LinearLayout lin = new LinearLayout(this);
            lin.setOrientation(LinearLayout.VERTICAL);

            // Set the CardView layoutParams
            ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.MATCH_PARENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(20, 20, 20, 20);
            card.setLayoutParams(params);
            card.setRadius(9);
            card.setContentPadding(30, 30, 30, 30);
            card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
            card.setMaxCardElevation(6);
            card.setCardElevation(3);

            LinearLayout.LayoutParams paramstext = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            paramstext.setMargins(0, 5, 0,  5);

            TextView tv = new TextView(this);
            tv.setLayoutParams(paramstext);
            tv.setText(complain.get(i).getLocalTs());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            tv.setTextColor(Color.RED);

            lin.addView(tv);

            TextView tv2 = new TextView(this);
            tv2.setLayoutParams(paramstext);
            tv2.setText(complain.get(i).getInMsg());
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            tv2.setTextColor(Color.BLACK);
            lin.addView(tv2);

            TextView tv3 = new TextView(this);
            tv3.setLayoutParams(paramstext);
            tv3.setText(complain.get(i).getOutMsg().toString());
            tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            tv3.setTextColor(Color.BLUE);
            lin.addView(tv3);

            TextView tv4 = new TextView(this);
            tv4.setLayoutParams(paramstext);
            tv4.setText(complain.get(i).getStatus());
            tv4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 15);
            tv4.setTextColor(Color.BLUE);
            lin.addView(tv4);

            card.addView(lin);

            if(card.getParent()!=null)
                ((ViewGroup)card.getParent()).removeView(card);
            mLinearLayout.addView(card);
        }

    }

}
