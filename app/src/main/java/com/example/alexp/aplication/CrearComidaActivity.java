package com.example.alexp.aplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import DataBase.AppDataBase;
import Objects.Comida;

public class CrearComidaActivity extends AppCompatActivity{

    private EditText ncomida;
    private Button b;
    private Toolbar t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crearcomida);
        t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("FitLine");
        ncomida=findViewById(R.id.nombrecomida);
        b=findViewById(R.id.aceptar);

        final AppDataBase adb = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,"production").allowMainThreadQueries().build();
        List<Comida> comidas=adb.comidaDAO().getAllComidas();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //guardar en room
                Log.d("Boton aceptar","Aceptando comida");
                adb.comidaDAO().insertComidas(new Comida(ncomida.getText().toString()));
                startActivity(new Intent(CrearComidaActivity.this,ComidasActivity.class));
            }
        });

    }
}
