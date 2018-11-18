package com.example.alexp.aplication.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexp.aplication.Activities.ComidasActivity;
import com.example.alexp.aplication.R;

public class CalendarioFragment extends Fragment {
    private View v;
    private CalendarView c;
    private String e;
    SharedPreferences sp;
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

    public void onResume() {
        super.onResume();

        sp= PreferenceManager.getDefaultSharedPreferences(getContext());
        e=sp.getString("recordatorio"," ");
        ((TextView)v.findViewById(R.id.recordar)).setText(e);
    }
}
