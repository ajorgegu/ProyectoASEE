package com.example.alexp.aplication.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.alexp.aplication.Adapters.ViewPagerAdapter;
import com.example.alexp.aplication.Fragments.CalendarioFragment;
import com.example.alexp.aplication.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "google";
    private static final String LOGTAG ="Connection" ;
    private Toolbar mToolbar ;
    private SharedPreferences sp;

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

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);

    }

    public boolean onCreateOptionsMenu(Menu m){

        getMenuInflater().inflate(R.menu.menu_main,m);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem m){
        openSettings();
        return true;
    }

    private  void openSettings(){
        CharSequence t= "Settings...";
        int duration = Snackbar.LENGTH_SHORT;
        Snackbar.make(mToolbar,t,duration).setAction("Action",null).show();
        Intent i = new Intent(this,ShettingsActivity.class);
        startActivity(i);
    }
}
