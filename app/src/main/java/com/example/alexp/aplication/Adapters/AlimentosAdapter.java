package com.example.alexp.aplication.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;


public class AlimentosAdapter extends RecyclerView.Adapter<AlimentosAdapter.ViewHolder> {

    private List<String> alimentos= new ArrayList<>();
    public AlimentosAdapter(List<String> alimentos){
        this.alimentos=alimentos;
    }

    @Override
    public AlimentosAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filaalimento,viewGroup,false);
        return new AlimentosAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.alimento.setText(alimentos.get(i));
    }

    @Override
    public int getItemCount() {return alimentos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView alimento;
        public CheckBox cb;
        public ViewHolder(View v) {
            super(v);
            alimento=v.findViewById(R.id.fila_alimento);
            cb = v.findViewById(R.id.checkBox);
        }
    }
}
