package com.example.alexp.aplication.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.alexp.aplication.Adapters.AlimentosAdapter;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListaAlimentosActivity extends AppCompatActivity {

    private RecyclerView rv;
    private AlimentosAdapter rvadapter;
    private FloatingActionButton fab;
    private StringBuffer sb;
    private ArrayList<Alimento> alimentos;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentos);
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new AlimentosAdapter(this,(ArrayList<Alimento>)getIntent().getExtras().get("lista"));
        rv.setAdapter(rvadapter);

        fab= findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { sb = new StringBuffer();
               ArrayList<Alimento> select = new ArrayList<Alimento>() {
               };

                for(int i=0; i<rvadapter.getAlimentosSeleccionados().size();i++){
                   // ArrayList<String> a = new ArrayList<>();
                    //a.add(rvadapter.getAlimentosSeleccionados().get(i));
                  //  a.add()
                       select.add(rvadapter.getAlimentosSeleccionados().get(i));
                    Alimento a =  new Alimento(rvadapter.getAlimentosSeleccionados().get(i).getId(),
                            rvadapter.getAlimentosSeleccionados().get(i).getNombre(),
                            rvadapter.getAlimentosSeleccionados().get(i).getCantidad(),
                            rvadapter.getAlimentosSeleccionados().get(i).getUnidad(),
                            rvadapter.getAlimentosSeleccionados().get(i).getProteinas(),
                            rvadapter.getAlimentosSeleccionados().get(i).getHidratos(),
                            rvadapter.getAlimentosSeleccionados().get(i).getGrasas()
                            );
                    alimentos.add(a);
                }
                Intent i = new Intent(ListaAlimentosActivity.this,ComidasActivity.class);

                Comida c =new Comida(getIntent().getExtras().getInt("dia"),
                        getIntent().getExtras().getInt("mes"),
                        getIntent().getExtras().getInt("anio"),
                        getIntent().getExtras().getString("nombre"));

                i.putExtra("anio",getIntent().getExtras().getInt("anio"));
                i.putExtra("mes",getIntent().getExtras().getInt("mes"));
                i.putExtra("dia",getIntent().getExtras().getInt("dia"));
                i.putExtra("comida",getIntent().getExtras().getInt("nombre"));
                startActivity(i);
            }
        });
    }
}
