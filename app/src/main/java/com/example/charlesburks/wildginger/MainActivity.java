package com.example.charlesburks.wildginger;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {



    private int currentYear;
    private int currentMonth;
    private int currentDay;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    int hour;
    int minute;
    private Button btDate, btTime, btBeef, btChicken, btNoodle, btSweet;
    private TextView timeDisplay;
    private TextView dateDisplay;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar c = Calendar.getInstance();
        currentYear = c.get(Calendar.YEAR);
        currentMonth = c.get(Calendar.MONTH);
        currentDay = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        timeDisplay = (TextView) findViewById(R.id.txtTime);
        dateDisplay = (TextView) findViewById(R.id.txtDate);
        btDate = (Button) findViewById(R.id.btnDate);
        btTime = (Button) findViewById(R.id.btnTime);
        btDate.setVisibility(View.INVISIBLE);
        btTime.setVisibility(View.INVISIBLE);
        btBeef = (Button) findViewById(R.id.btnBeef);
        btChicken = (Button) findViewById(R.id.btnChicken);
        btNoodle = (Button) findViewById(R.id.btnNoodle);
        btSweet = (Button) findViewById(R.id.btnSweet);
        btBeef.setOnClickListener(onClickListener);
        btChicken.setOnClickListener(onClickListener);
        btNoodle.setOnClickListener(onClickListener);
        btSweet.setOnClickListener(onClickListener);




        btDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                showDialog(DATE_DIALOG_ID);
            }
        });
        btTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                showDialog(TIME_DIALOG_ID);
            }
        });
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, reservationDate, currentYear,
                        currentMonth, currentDay);
            case TIME_DIALOG_ID:
                return new TimePickerDialog(this, timeDate, hour, minute, false);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener reservationDate = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int month, int day) {


                dateDisplay.setText("Your delivery date:  "
                        + (month + 1) + "-" + day + "-" + year);

        }

    };
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnBeef:
                    btDate.setVisibility(View.VISIBLE);
                    btTime.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Broccoli Beef - Now Pick Delivery Date and Time", Toast.LENGTH_LONG).show();
                    break;

                case R.id.btnChicken:
                    btDate.setVisibility(View.VISIBLE);
                    btTime.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "BBQ Chicken - Now Pick Delivery Date and Time", Toast.LENGTH_LONG).show();
                    break;

                case R.id.btnNoodle:
                    btDate.setVisibility(View.VISIBLE);
                    btTime.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Noodles - Now Pick Delivery Date and Time", Toast.LENGTH_LONG).show();
                    break;

                case R.id.btnSweet:
                    btDate.setVisibility(View.VISIBLE);
                    btTime.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "Sweet & Sour Chicken - Now Pick Delivery Date and Time", Toast.LENGTH_LONG).show();
                    break;



            }

        }
    };

    private TimePickerDialog.OnTimeSetListener timeDate = new TimePickerDialog.OnTimeSetListener() {

        public void onTimeSet(TimePicker view, int hours, int minutes) {
            if(hours <17 || hours >23){
                Toast.makeText(getApplicationContext(), "Pick Time from 5pm to 11pm", Toast.LENGTH_LONG).show();
            } else {

                timeDisplay.setText("Your arrival time will be close to " + (hours-12) + ":"
                        + minutes + " pm.");
            }
        }
    };

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

}