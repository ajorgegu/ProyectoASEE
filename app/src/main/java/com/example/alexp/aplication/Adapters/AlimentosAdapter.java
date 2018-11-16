package com.example.alexp.aplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;


public class AlimentosAdapter extends RecyclerView.Adapter<HolderAlimentos> {

    private ArrayList<Alimento> alimentos;
    private ArrayList<Alimento> alimentosSeleccionados= new ArrayList<>();
    private List<String> cantidades = new ArrayList<>();
    private Context c;

    public AlimentosAdapter(Context c,ArrayList<Alimento> alimentos){
        this.c=c;
        this.alimentos=alimentos;
    }

    @Override
    public HolderAlimentos onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filaalimento,viewGroup,false);
        return new HolderAlimentos(v);
    }

    @Override
    public void onBindViewHolder(HolderAlimentos holder, int i) {
        holder.t.setText(alimentos.get(i).getNombre()+"\n"+
                "Id: " + Integer.toString(alimentos.get(i).getId()) +"\n"+
                 "Cantidad: "+        Float.toString(alimentos.get(i).getCantidad()) +"\n"+
                "Unidad: "+ alimentos.get(i).getUnidad() +"\n"+
               "Proteinas: "+ Float.toString(alimentos.get(i).getProteinas()) +"\n"+
                "Hidratos: "+Float.toString(alimentos.get(i).getHidratos()) +"\n"+
                "Grasas: "+Float.toString(alimentos.get(i).getGrasas()) +"\n");

        holder.setItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox cb2 = (CheckBox) v;
                if(cb2.isChecked()){
                    alimentosSeleccionados.add(alimentos.get(pos));
                }else{
                    alimentosSeleccionados.remove(alimentos.get(pos));
                }
            }
        });
    }

    @Override
    public int getItemCount() {return alimentos.size();}

    public ArrayList<Alimento> getAlimentosSeleccionados(){
        return this.alimentosSeleccionados;
    }

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
