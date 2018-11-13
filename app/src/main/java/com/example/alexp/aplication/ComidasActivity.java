package com.example.alexp.aplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

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
        comidas= new ArrayList<>();
        for(int i=0;i<10;i++){
            comidas.add("Comida"+i);
            Log.d("Creando comida","Comida"+i);
        }
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new ComidaAdapter(comidas);
        rv.setAdapter(rvadapter);

        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ComidasActivity","pressed");
                startActivity(new Intent(ComidasActivity.this,CrearComidaActivity.class));
            }
        });
    }
}
