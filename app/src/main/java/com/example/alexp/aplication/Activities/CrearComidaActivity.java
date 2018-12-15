package com.example.alexp.aplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.ComidasRepository;

public class CrearComidaActivity extends AppCompatActivity{

    private EditText ncomida;
    private Toolbar t;
    FloatingActionButton fab;
    private ComidasRepository crep;
    private Comida c;

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
                c =new Comida(getIntent().getExtras().getInt("dia"),
                        getIntent().getExtras().getInt("mes"),
                        getIntent().getExtras().getInt("anio"),
                        ncomida.getText().toString());
                crep=new ComidasRepository(getApplication());
                crep.insertComida(c);
                Intent i = new Intent(CrearComidaActivity.this, ListaAlimentosActivity.class);
                i.putExtra("nombrecomida",ncomida.getText().toString());
                int dia= getIntent().getExtras().getInt("dia");
                int mes= getIntent().getExtras().getInt("mes");
                int anio= getIntent().getExtras().getInt("anio");
                i.putExtra("anio",anio);
                i.putExtra("mes",mes);
                i.putExtra("dia",dia);
                Log.d("Fecha",dia+" "+mes+" "+anio);
                startActivity(i);
            }
        });

    }
}
