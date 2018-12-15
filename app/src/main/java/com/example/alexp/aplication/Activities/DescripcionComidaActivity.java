package com.example.alexp.aplication.Activities;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;

import com.example.alexp.aplication.Adapters.DescripcionAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.AlimentoDAO;
import com.example.alexp.aplication.ObjectsDAO.ComidaAlimentoDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.AlimentosRepository;
import com.example.alexp.aplication.Repository.ComidasAlimentoRepository;
import com.example.alexp.aplication.ViewModels.DescripcionComidaViewModel;

import java.util.ArrayList;
import java.util.List;


public class DescripcionComidaActivity extends AppCompatActivity {

    private RecyclerView rv;
    private DescripcionAdapter rvadapter;
    private AlimentosRepository arep;
    private ComidasAlimentoRepository carep;
    private ArrayList<Alimento> alimentos = new ArrayList<>();
    private List<Pair<Integer, Float>> ca = new ArrayList<Pair<Integer, Float>>();
    private Button guardar;
    private int dia,mes,anio;
    private String comida;
    private DescripcionComidaViewModel dvm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        obtenerDatosIntent();

        rvadapter=new DescripcionAdapter(getApplicationContext(),getApplication());
        rv.setAdapter(rvadapter);
        rvadapter.setFecha(dia,mes,anio);

        dvm.getAllca(comida,dia,mes,anio).observe(this, new Observer<List<Comida_Alimento>>() {
                    @Override
                    public void onChanged(@Nullable List<Comida_Alimento> comida_alimentos) {
                        if(alimentos.size()==0) {
                            for (int i = 0; i < comida_alimentos.size(); i++) {
                                alimentos.add(arep.getAlimentoById(comida_alimentos.get(i).getId()));
                            }
                            Log.d("Tamaño: ", String.valueOf(alimentos.size()));
                        }
                        rvadapter.setAlimentos(alimentos, (ArrayList<Comida_Alimento>) comida_alimentos);
                    }
                });

        guardar = findViewById(R.id.guardarCambios);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ca=rvadapter.getAlimcant();
                for(int i=0; i<ca.size();i++) {
                    Comida_Alimento caAux = new Comida_Alimento(comida,ca.get(i).first,ca.get(i).second,dia,mes,anio);
                    Log.d("Obteniendo comida_alimento: ",ca.get(i).first.toString()+" "+ca.get(i).second.toString());
                    carep.updateComidaAlimento(caAux);
                }
            }
        });
    }

    private void obtenerDatosIntent(){
        comida= getIntent().getExtras().getString("nombrecomida");
        dia=getIntent().getExtras().getInt("dia");
        mes=getIntent().getExtras().getInt("mes");
        anio=getIntent().getExtras().getInt("anio");
        Log.d("Fecha: ",dia+" "+mes+" "+anio+" "+comida);
    }
    private void init(){
        setContentView(R.layout.descripalimentos);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        carep = new ComidasAlimentoRepository(getApplication());
        arep = new AlimentosRepository(getApplication());
        dvm = ViewModelProviders.of(this).get(DescripcionComidaViewModel.class);
    }
}
