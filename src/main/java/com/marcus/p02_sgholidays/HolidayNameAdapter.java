package com.marcus.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayNameAdapter extends ArrayAdapter<HolidayName> {

    private ArrayList<HolidayName> holidayNames;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivHoli;

    public HolidayNameAdapter(Context context, int resource, ArrayList<HolidayName> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidayNames = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.rowholiday, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvHoliName);
        tvDate = (TextView) rowView.findViewById(R.id.tvHoliDate);
        ivHoli = (ImageView) rowView.findViewById(R.id.imageView);
        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        HolidayName currentType = holidayNames.get(position);
        // Set the TextView to show the food

        if (currentType.getHoliType().equals("Secular")) {
            if (position == 0) {
                ivHoli.setImageResource(R.drawable.newyear);
            } else if (position == 1) {
                ivHoli.setImageResource(R.drawable.labourday);
            } else if (position == 2) {
                ivHoli.setImageResource(R.drawable.nationalday);
            }
        } else if (currentType.getHoliType().equals("Ethnic & Religion")) {
            if (position == 0) {
                ivHoli.setImageResource(R.drawable.cny);
            } else if (position == 1) {
                ivHoli.setImageResource(R.drawable.goodfri);
            } else if (position == 2) {
                ivHoli.setImageResource(R.drawable.vesak);
            } else if (position == 3) {
                ivHoli.setImageResource(R.drawable.hariraya);
            } else if (position == 4) {
                ivHoli.setImageResource(R.drawable.harihaji);
            } else if (position == 5) {
                ivHoli.setImageResource(R.drawable.deepavali);
            } else if (position == 6) {
                ivHoli.setImageResource(R.drawable.christmas);
            }

        }
        tvName.setText(currentType.getName());
        tvDate.setText(currentType.getDate());
        return rowView;
    }
}