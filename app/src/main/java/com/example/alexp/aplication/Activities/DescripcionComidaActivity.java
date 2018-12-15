package com.example.alexp.aplication.Activities;

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
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.AlimentoDAO;
import com.example.alexp.aplication.ObjectsDAO.ComidaAlimentoDAO;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.AlimentosRepository;
import com.example.alexp.aplication.Repository.ComidasAlimentoRepository;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripalimentos
        );
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        carep=new ComidasAlimentoRepository(getApplication());
        arep = new AlimentosRepository(getApplication());
        ArrayList<Comida_Alimento> c_alimentos= (ArrayList<Comida_Alimento>) carep.getComidasAlimento(getIntent().getExtras().getString("nombrecomida"),getIntent().getExtras().getInt("dia"),getIntent().getExtras().getInt("mes"),getIntent().getExtras().getInt("anio"));

        for(int i=0; i<c_alimentos.size();i++){
            alimentos.add(arep.getAlimentoById(c_alimentos.get(i).getId()));
        }
        rvadapter=new DescripcionAdapter(this,alimentos,c_alimentos,getApplication());
        rv.setAdapter(rvadapter);

        guardar=findViewById(R.id.guardarCambios);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ca=rvadapter.getAlimcant();
                String comida= getIntent().getExtras().getString("nombrecomida");
                int dia=getIntent().getExtras().getInt("dia");
                int mes=getIntent().getExtras().getInt("mes");
                int anio=getIntent().getExtras().getInt("anio");
                for(int i=0; i<ca.size();i++) {
                    Comida_Alimento caAux = new Comida_Alimento(comida,ca.get(i).first,ca.get(i).second,dia,mes,anio);
                    Log.d("Obteniendo comida_alimento: ",ca.get(i).first.toString()+" "+ca.get(i).second.toString());
                    carep.updateComidaAlimento(caAux);
                    finish();
                    startActivity(getIntent());
                }
            }
        });
    }
}
