package com.example.alexp.aplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import Adapters.ComidaAdapter;
import DataBase.AppDataBase;
import Objects.Comida;

public class ComidasActivity extends AppCompatActivity {

    RecyclerView rv;
    RecyclerView.Adapter rvadapter;
    FloatingActionButton fab;
    ArrayList<Comida> comidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comidas);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);

        rv=findViewById(R.id.recyclerView);
        AppDataBase adb = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"production").allowMainThreadQueries().build();
        List<Comida> comidas=adb.comidaDAO().getAllComidas();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new ComidaAdapter(comidas);
        rv.setAdapter(rvadapter);



        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ComidasActivity.this,CrearComidaActivity.class));
            }
        });
    }
}
