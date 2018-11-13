package com.example.alexp.aplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;

import java.util.Calendar;

public class CalendarioFragment extends Fragment {
    private View v;
    private CalendarView c;
    public void CalendarioFragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.calendar,container,false);
        c = (CalendarView) v.findViewById(R.id.calendarView);
        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                Intent i = new Intent(getActivity(),ComidasActivity.class);
                i.putExtra("anio",year);
                i.putExtra("mes",month);
                i.putExtra("dia",dayOfMonth);
                getActivity().startActivity(i);
            }
        });
        return v;
    }
}
