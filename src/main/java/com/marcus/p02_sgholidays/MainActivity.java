package com.marcus.p02_sgholidays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<HolidayType> al;
    ArrayAdapter aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvHoliday);


        al = new ArrayList<HolidayType>();
        al.add(new HolidayType("Secular"));
        al.add(new HolidayType("Ethnic & Religion"));

        aa = new HolidayTypeAdapter(this, R.layout.row,al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HolidayType selectedYear = al.get(i);

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("holidayType",selectedYear.getName());
                startActivity(intent);
            }
        });
    }
}