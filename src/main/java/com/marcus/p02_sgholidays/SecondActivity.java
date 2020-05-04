package com.marcus.p02_sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvHoli;
    TextView tvType;

    ArrayList<HolidayName> al;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvType = findViewById(R.id.tvType);
        lvHoli = findViewById(R.id.lvHoli);

        Intent i = getIntent();
        String type = i.getStringExtra("holidayType");
        tvType.setText(type);


        al = new ArrayList<HolidayName>();
        if(type.equals("Secular")){
            al.add(new HolidayName("New Year Day", "1 Jan 2020", "Secular"));
            al.add(new HolidayName("Labour Day", "1 May 2020", "Secular"));
            al.add(new HolidayName("National Day", "9 Aug 2020", "Secular"));

        }else if(type.equals("Ethnic & Religion")){
            al.add(new HolidayName("Chinese New Year", "25 - 26 Jan 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Good Friday", "10 Apr 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Vesak Day", "7 May 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Hari Raya Puasa", "24 May 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Hari Raya Haji", "31 July 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Deepavali", "14 Nov 2020", "Ethnic & Religion"));
            al.add(new HolidayName("Christmas Day", "25 Dec 2020", "Ethnic & Religion"));
        }


        aa = new HolidayNameAdapter(this, R.layout.rowholiday,al);
        lvHoli.setAdapter(aa);

        lvHoli.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HolidayName selected = al.get(i);

                Toast.makeText(SecondActivity.this, selected.getName() + " Date: " + selected.getDate(), Toast.LENGTH_LONG).show();

            }
        });
    }
}