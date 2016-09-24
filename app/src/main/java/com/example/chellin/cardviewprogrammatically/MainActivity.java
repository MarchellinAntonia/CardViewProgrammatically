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
    private AlertDialogHelper alertDialog;
    private int year, month, day;

    private Button changeDate;
    private TextView tgl;
    LinearLayout mLinearLayout;
    private TextView process;
    private Dialog historyDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Request window feature action bar
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Riwayat Komplain");
        mContext = getApplicationContext();
//        ok.setVisibility(View.INVISIBLE);

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


        alertDialog = new AlertDialogHelper(MainActivity.this);
        mLinearLayout = (LinearLayout) findViewById(R.id.rl);
        tgl = (TextView) findViewById(R.id.textTgl);
        changeDate = (Button) findViewById(R.id.changeDate);

        // Get current date by calender
        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);
        tgl.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(year).append("-").append(month+1).append("-").append(day));

        final DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                tgl.setText(new StringBuilder()
                        .append(String.valueOf(year)).append("-").append(String.valueOf(monthOfYear+1)).append("-").append(String.valueOf(dayOfMonth)));
            }
        }, year, month, day);

        changeDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.show();
            }
        });



        process =  (TextView)findViewById(R.id.process_history_complain);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showHistory(complains);
            }
        });


    }


    private void showHistory(List<Complain> complain) {

        TextView label = (TextView) findViewById(R.id.labelTanggal);
        ((ViewGroup) label.getParent()).removeView(label);
        ((ViewGroup) tgl.getParent()).removeView(tgl);
        ((ViewGroup) changeDate.getParent()).removeView(changeDate);
        ((ViewGroup) process.getParent()).removeView(process);




        for(int i=0;i<complain.size();i++){

            // Initialize a new CardView
            CardView card = new CardView(this);
            LinearLayout lin = new LinearLayout(this);
            lin.setOrientation(LinearLayout.VERTICAL);

            // Set the CardView layoutParams
            ActionBar.LayoutParams params = new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.WRAP_CONTENT,
                    ActionBar.LayoutParams.WRAP_CONTENT
            );
            card.setLayoutParams(params);
            card.setRadius(9);
            card.setContentPadding(15, 15, 15, 15);
            card.setCardBackgroundColor(Color.parseColor("#FFC6D6C3"));
            card.setMaxCardElevation(15);
            card.setCardElevation(9);

            TextView tv = new TextView(this);
            tv.setLayoutParams(params);
            tv.setText(complain.get(i).getLocalTs());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv.setTextColor(Color.RED);

            lin.addView(tv);

            TextView tv2 = new TextView(this);
            tv2.setLayoutParams(params);
            tv2.setText(complain.get(i).getInMsg());
            tv2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv2.setTextColor(Color.BLACK);
            lin.addView(tv2);

            TextView tv3 = new TextView(this);
            tv3.setLayoutParams(params);
            tv3.setText(complain.get(i).getOutMsg().toString());
            tv3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv3.setTextColor(Color.BLUE);
            lin.addView(tv3);

            TextView tv4 = new TextView(this);
            tv4.setLayoutParams(params);
            tv4.setText(complain.get(i).getStatus());
            tv4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
            tv4.setTextColor(Color.BLUE);
            lin.addView(tv4);

            card.addView(lin);

            if(card.getParent()!=null)
                ((ViewGroup)card.getParent()).removeView(card);
            mLinearLayout.addView(card);
        }

    }

}
