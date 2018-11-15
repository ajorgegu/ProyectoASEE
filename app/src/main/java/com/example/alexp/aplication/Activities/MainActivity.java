package com.example.alexp.aplication.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.alexp.aplication.Adapters.ViewPagerAdapter;
import com.example.alexp.aplication.Fragments.CalendarioFragment;
import com.example.alexp.aplication.Fragments.PerfilFragment;
import com.example.alexp.aplication.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "google";
    private static final String LOGTAG ="Connection" ;
    private Toolbar mToolbar ;

    //https://drive.google.com/a/alumnos.unex.es/uc?authuser=1&id=1w50uRcKXheRXkqyXjkAa7QAyOvmfpMPG&export=download

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        mToolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("FitLine");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        vpa.addFragment(new CalendarioFragment(),"Calendario");
        vpa.addFragment(new PerfilFragment(),"Perfil");

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);
    }
}
