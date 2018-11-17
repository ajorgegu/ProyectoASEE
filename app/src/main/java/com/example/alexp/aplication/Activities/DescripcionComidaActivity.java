package com.example.alexp.aplication.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.alexp.aplication.Adapters.AlimentosAdapter;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;

import java.util.ArrayList;


public class DescripcionComidaActivity extends AppCompatActivity {

    private RecyclerView rv;
    private AlimentosAdapter rvadapter;
    private ComidaDAO c;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentos);
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Alimento> alimentos= (ArrayList<Alimento>) AppDataBase.getInstance(this).comidaDAO().getAlimentos(getIntent().getExtras().getString("nombrecomida"));
        Log.d("ALimentos: ", alimentos.get(0).getNombre());
        rvadapter=new AlimentosAdapter(this,alimentos );
        rv.setAdapter(rvadapter);
    }
}
