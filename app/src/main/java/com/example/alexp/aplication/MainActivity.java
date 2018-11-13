package com.example.alexp.aplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.*;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.alexp.aplication.Adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar ;
    private View v;
    private KeyEvent k;
    private TabLayout tabLayout;
    private LinearLayout page1;
    private LinearLayout page2;
    private ListView page3;
    private CalendarView c;

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
        vpa.addFragment(new AlimentosFragment(),"Alimentos");

        viewPager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewPager);

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
   // @Override
   /* public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
                startActivity(new Intent(Intent.ACTION_VIEW,);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }*/
/*
    class MainPageAdapter extends PagerAdapter {

        private RelativeLayout page1;
        private RelativeLayout page2;
        private RelativeLayout page3;
        private final int[] titles = {R.string.page1, R.string.page2, R.string.page3,};

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return getString(titles[position]);
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            View page;
            switch (position) {
                case 0:
                    if (page1 == null) {
                        page1 = (RelativeLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .calendar, collection, false);
                        c=(CalendarView) page1.findViewById(R.id.calendarView);
                        c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                            @Override
                            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                                Intent i = new Intent(MainActivity.this,CalendarioFragment.class);
                                startActivity(i);
                            }
                        });
                    }
                    page = page1;
                    break;

                case 1:
                    if (page2 == null) {
                        page2 = (RelativeLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .perfil, collection, false);
                    }
                    page = page2;
                    break;

                case 2:
                    if (page3 == null) {
                        page3 = (ListView) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .page_three, collection, false);
                        initListView();
                    }
                    page = page3;
                    break;

                default:
                    if (page3 == null) {
                        page3 = (RelativeLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout
                                .perfil, collection, false);
                    }
                    page = page3;
                    break;
            }

            collection.addView(page, 0);

            return page;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

       /* private void initListView() {
            String[] items = new String[50];
            for (int i = 0; i < 50; i++) {
                items[i] = "Item " + i;
            }
            page3.setAdapter(new ArrayAdapter<String>(MainActivity.this, R.layout.textview, items));
            page3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(MainActivity.this, (String) parent.getItemAtPosition(position), Toast
                            .LENGTH_SHORT).show();
                }
            });

        }*/
    }
