package com.example.alexp.aplication.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alexp.aplication.R;

import java.util.List;

import com.example.alexp.aplication.Objects.Comida;

public class ComidaAdapter extends RecyclerView.Adapter<ComidaAdapter.ViewHolder> {

   private List<String> comidas;
    public ComidaAdapter(List<String> comidas){
        this.comidas=comidas;
    }

    @Override
    public ComidaAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filacomida,viewGroup,false);
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ComidaAdapter.ViewHolder viewHolder, int i) {
        viewHolder.comida.setText(comidas.get(i));
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public Button comida;

        public ViewHolder(View itemView) {
            super(itemView);
            comida=itemView.findViewById(R.id.fila_comida);
        }
    }
}
