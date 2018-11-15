package com.example.alexp.aplication.Activities;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.alexp.aplication.Adapters.AlimentosAdapter;
import com.example.alexp.aplication.R;

public class ListaAlimentosActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerView.Adapter rvadapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alimentos);
        Toolbar t=findViewById(R.id.toolbar);
        t.setTitle("FitLine");
        setSupportActionBar(t);
        rv=findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rvadapter=new AlimentosAdapter(getIntent().getExtras().getStringArrayList("lista"));
        rv.setAdapter(rvadapter);
    }
}
