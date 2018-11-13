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

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Comida;

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
        List<String> comidas=adb.comidaDAO().getAllComidas(getIntent().getExtras().getInt("dia"),getIntent().getExtras().getInt("mes"),getIntent().getExtras().getInt("anio"));

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //guardar en room
                Log.d("Boton aceptar","Aceptando comida");
                adb.comidaDAO().insertComidas(new Comida(getIntent().getExtras().getInt("dia"),getIntent().getExtras().getInt("mes"),getIntent().getExtras().getInt("anio"),ncomida.getText().toString()));
                Intent i = new Intent(CrearComidaActivity.this,ComidasActivity.class);
                i.putExtra("anio",getIntent().getExtras().getInt("anio"));
                i.putExtra("mes",getIntent().getExtras().getInt("mes"));
                i.putExtra("dia",getIntent().getExtras().getInt("dia"));
                startActivity(i);
            }
        });

    }
}
