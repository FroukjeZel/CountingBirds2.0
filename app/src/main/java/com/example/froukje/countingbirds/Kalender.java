package com.example.froukje.countingbirds;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;

public class Kalender extends NavigationDrawer {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalender);
        buildMenu();

        final EditText naam = (EditText) findViewById(R.id.calendar_editText_data_name);
        final EditText locatie = (EditText) findViewById(R.id.calendar_editText_data_location);
        final EditText tijd = (EditText) findViewById(R.id.calendar_editText_data_time);

        ListView list = (ListView) findViewById(R.id.calendar_list);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setDate(System.currentTimeMillis(), false, true);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                String date = "";

                month += 1;

                if (day < 10) {
                    date += "0" + day;
                } else {
                    date += day;
                }

                if (month < 10) {
                    date += "/0" + month;
                } else {
                    date += "/" + month;
                }

                date += "/" + year;
                if (date.equals("06/04/2018")) {
                    naam.setText("Joey Sparidaans");
                    locatie.setText("C.A. van Baalen, Gouden Steinstraat 55");
                    tijd.setText("13:00 - 17:00");

                } else {
                    naam.setText("");
                    locatie.setText("");
                    tijd.setText("");
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(Kalender.this, KalenderNext.class);
                startActivity(intent);
            }
        });
    }


}
