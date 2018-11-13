package com.example.alexp.aplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrearComidaActivity extends AppCompatActivity{

    private EditText comida;
    private Button b;
    private Toolbar t;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crearcomida);
        t = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(t);
        getSupportActionBar().setTitle("FitLine");
        comida=findViewById(R.id.nombrecomida);
        b=findViewById(R.id.aceptar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //guardar en room
                Log.d("Boton aceptar","Aceptando comida");
            }
        });

    }
}
