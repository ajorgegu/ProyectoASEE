package com.example.alexp.aplication.Activities;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.alexp.aplication.API.NetworkingAndroidHttpClientJSONActivity;
import com.example.alexp.aplication.Adapters.AlimentosAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.AlimentosRepository;

import java.util.ArrayList;
import java.util.List;


public class ListaAlimentosActivity extends AppCompatActivity {

    private RecyclerView rv;
    private AlimentosAdapter rvadapter;
    private FloatingActionButton fab;
    public static Comida c;
    public static ComidaDAO cdao;
    public List<Pair<Integer, Float>> alimentos = new ArrayList<Pair<Integer, Float>>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentos);
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        //AlimentosRepository
        AlimentosRepository arep = new AlimentosRepository(this.getApplication());
        rvadapter=new AlimentosAdapter(ListaAlimentosActivity.this,(ArrayList<Alimento>)arep.getAlimentos(),alimentos);
        rvadapter.setNombrecomida(getIntent().getExtras().getString("nombrecomida"));
        rv.setAdapter(rvadapter);

        cdao=AppDataBase.getInstance(this).comidaDAO();


        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { { };
                Intent i = new Intent(ListaAlimentosActivity.this,ComidasActivity.class);
                i.putExtra("anio",getIntent().getExtras().getInt("anio"));
                i.putExtra("mes",getIntent().getExtras().getInt("mes"));
                i.putExtra("dia",getIntent().getExtras().getInt("dia"));
                alimentos=rvadapter.getAlimcant();
                for(int j=0; j<alimentos.size();j++){
                    String comida=getIntent().getExtras().getString("nombrecomida");
                    int id = alimentos.get(j).first;
                    float cantidad = alimentos.get(j).second;
                    Comida_Alimento ca = new Comida_Alimento(comida,id,cantidad);
                    cdao.insertComidaAlimento(ca);
                }
               startActivity(i);
            }
        });
    }
}
