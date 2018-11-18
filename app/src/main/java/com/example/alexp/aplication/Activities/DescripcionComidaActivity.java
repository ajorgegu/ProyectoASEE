package com.example.alexp.aplication.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.alexp.aplication.Adapters.AlimentosAdapter;
import com.example.alexp.aplication.Adapters.DescripcionAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;


public class DescripcionComidaActivity extends AppCompatActivity {

    private RecyclerView rv;
    private DescripcionAdapter rvadapter;
    private ComidaDAO c;
    private ArrayList<Alimento> alimentos = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.descripalimentos);
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));

        c=AppDataBase.getInstance(getApplicationContext()).comidaDAO();
        ArrayList<Comida_Alimento> c_alimentos= (ArrayList<Comida_Alimento>) AppDataBase.getInstance(this).comidaDAO().getComidasAlimento(getIntent().getExtras().getString("nombrecomida"));

        for(int i=0; i<c_alimentos.size();i++){
            alimentos.add(c.getAlimento(c_alimentos.get(i).getId()));
        }
        rvadapter=new DescripcionAdapter(this,alimentos,c_alimentos);
        rv.setAdapter(rvadapter);
    }
}
