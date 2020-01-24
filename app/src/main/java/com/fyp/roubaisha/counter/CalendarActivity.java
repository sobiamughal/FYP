package com.fyp.roubaisha.counter;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity implements MyCalendarView.OnDateSetListener {

    MyCalendarView myCalendarView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Calendar");

        ((CardView) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myCalendarView = MyCalendarView.getInstance(CalendarActivity.this,true);

                myCalendarView.setOnDateSetListener(CalendarActivity.this);
                myCalendarView.setMinMaxHijriYear(1430, 1450);
                myCalendarView.setMinMaxGregorianYear(2013, 2020);
                myCalendarView.setMode(MyCalendarView.Mode.Gregorian);
                myCalendarView.setUILanguage(MyCalendarView.Language.English);
//                myCalendarView.setDaysOfWeekTextColor(getResources().getColor(R.color.orange_light));
//                myCalendarView.setDatePickerMonthlyDaysBckground(getResources().getColor(R.color.orange_light));
//                        .setDefaultHijriDate(8, 0, 1437)//months start from 0
                myCalendarView.setEnableScrolling(false);

                myCalendarView.showDialog();

            }
        });
        ((CardView) findViewById(R.id.button22)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myCalendarView = MyCalendarView.getInstance(CalendarActivity.this,true);

                myCalendarView.setOnDateSetListener(CalendarActivity.this);
                myCalendarView.setMinMaxHijriYear(1430, 1450);
                myCalendarView.setMinMaxGregorianYear(2013, 2020);
                myCalendarView.setMode(MyCalendarView.Mode.Hijri);
                myCalendarView.setUILanguage(MyCalendarView.Language.Arabic);
//                        .setDefaultHijriDate(8, 0, 1437)//months start from 0
                myCalendarView.setEnableScrolling(false);

                myCalendarView.showDialog();

            }
        });
    }

    @Override
    public void onDateSet(int year, int month, int day, int hour, int minute, int seconds, String ampm) {
        ((TextView) findViewById(R.id.textView)).setText(day + "/" + (month) + "/" + year);
        ((TextView) findViewById(R.id.TimetextView)).setText(hour + "-" + minute + "-" + ampm);
    }
}
