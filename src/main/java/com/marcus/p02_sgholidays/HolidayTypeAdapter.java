package com.marcus.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class HolidayTypeAdapter extends ArrayAdapter<HolidayType> {
    private ArrayList<HolidayType> holidayTypes;
    private Context context;
    private TextView tvType;

    public HolidayTypeAdapter(Context context, int resource, ArrayList<HolidayType> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holidayTypes = objects;
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
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvType = (TextView) rowView.findViewById(R.id.tvType);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        HolidayType currentType = holidayTypes.get(position);
        // Set the TextView to show the food

        tvType.setText(currentType.getName());


        return rowView;
    }
}