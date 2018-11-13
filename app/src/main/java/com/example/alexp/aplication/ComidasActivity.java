package com.example.alexp.aplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.example.alexp.aplication.Adapters.ComidaAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Comida;

public class ComidasActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter rvadapter;
    FloatingActionButton fab;
    ArrayList<String> comidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comidas);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        rv=findViewById(R.id.recyclerView);
        AppDataBase adb = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"production").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        List<String> comidas=adb.comidaDAO().getAllComidas(getIntent().getExtras().getInt("dia"),getIntent().getExtras().getInt("mes"),getIntent().getExtras().getInt("anio"));

        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new ComidaAdapter(comidas);
        rv.setAdapter(rvadapter);

        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComidasActivity.this,CrearComidaActivity.class);
                i.putExtra("anio",getIntent().getExtras().getInt("anio"));
                i.putExtra("mes",getIntent().getExtras().getInt("mes"));
                i.putExtra("dia",getIntent().getExtras().getInt("dia"));
                startActivity(i);
            }
        });
    }
}
