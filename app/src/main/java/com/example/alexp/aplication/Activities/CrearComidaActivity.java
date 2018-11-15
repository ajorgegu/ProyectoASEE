package com.example.alexp.aplication.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import com.example.alexp.aplication.API.NetworkingAndroidHttpClientJSONActivity;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.R;

public class CrearComidaActivity extends AppCompatActivity{

    private EditText ncomida;
    private Toolbar t;
    FloatingActionButton fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crearcomida);
        t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("FitLine");
        ncomida=findViewById(R.id.nombrecomida);
        fab= findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CrearComidaActivity.this, NetworkingAndroidHttpClientJSONActivity.class);
                i.putExtra("anio",getIntent().getExtras().getInt("anio"));
                i.putExtra("mes",getIntent().getExtras().getInt("mes"));
                i.putExtra("dia",getIntent().getExtras().getInt("dia"));
                i.putExtra("nombre",ncomida.getText());
                startActivity(i);
            }
        });

    }
}
