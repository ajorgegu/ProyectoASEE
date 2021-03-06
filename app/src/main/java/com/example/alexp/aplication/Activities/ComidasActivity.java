package com.example.alexp.aplication.Activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import com.example.alexp.aplication.Adapters.ComidaAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.ComidasRepository;

public class ComidasActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ComidaAdapter rvadapter=null;
    private FloatingActionButton fab;
    private List<String> comidas= new ArrayList<>();
    public static ComidasRepository crep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comidas);
        Toolbar t=(Toolbar)findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);

        crep= new ComidasRepository(this.getApplication());
        comidas=crep.getAllComidas(getIntent().getExtras().getInt("dia"),getIntent().getExtras().getInt("mes"),getIntent().getExtras().getInt("anio"));

        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new ComidaAdapter(this,comidas,getApplication());
        rv.setAdapter(rvadapter);

        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ComidasActivity.this,CrearComidaActivity.class);
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
