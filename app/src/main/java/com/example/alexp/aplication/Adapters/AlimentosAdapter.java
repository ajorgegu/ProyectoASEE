package com.example.alexp.aplication.Adapters;

import  android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexp.aplication.Holders.HolderAlimentos;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;


public class AlimentosAdapter extends RecyclerView.Adapter<HolderAlimentos> {

    private ArrayList<Alimento> alimentos;
    private List<Pair<Integer, Float>> alimcant;
    private static Context c;
    private String nombrecomida;
    private ArrayList<Pair<HolderAlimentos,Integer>> haux= new ArrayList<Pair<HolderAlimentos,Integer>>();

    public AlimentosAdapter(Context c, ArrayList<Alimento> alimentos,List<Pair<Integer, Float>> alimcant ){
        this.c=c;
        this.alimentos=alimentos;
        this.alimcant=alimcant;
    }

    @Override
    public HolderAlimentos onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filaalimento,viewGroup,false);
        return new HolderAlimentos(v);
    }

    @Override
    public void onBindViewHolder(final HolderAlimentos holder, int i) {
        holder.t.setText(alimentos.get(i).getNombre()+"\n"+
                 "Cantidad: "+        Float.toString(alimentos.get(i).getCantidad()) +"\n"+
                 "Unidad: "+ alimentos.get(i).getUnidad() +"\n"+
                 "Proteinas: "+ Float.toString(alimentos.get(i).getProteinas()) +"\n"+
                 "Hidratos: "+Float.toString(alimentos.get(i).getHidratos()) +"\n"+
                 "Grasas: "+Float.toString(alimentos.get(i).getGrasas()) +"\n");
        holder.et.setText("0");
        Pair p = new Pair(holder,alimentos.get(i).getId());
        haux.add(p);
        holder.setItemClickListener( new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
              Log.d("Item seleccionado: ",String.valueOf(pos));
            }
        });
    }

    public void setNombrecomida(String nombrecomida) {
        this.nombrecomida = nombrecomida;
    }

    public String getNombrecomida() {
        return this.nombrecomida;
    }

    public List<Pair<Integer, Float>> getAlimcant(){
        for(int i=0;i<haux.size();i++){
            if(haux.get(i).first.cb.isChecked()){
                Pair p = new Pair(haux.get(i).second,Float.parseFloat(haux.get(i).first.et.getText().toString()));
                alimcant.add(p);
            }
        }
        return this.alimcant;
    }

    @Override
    public int getItemCount() {return alimentos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView alimento;
        public CheckBox cb;
        public EditText cantidad;
        public ViewHolder(View v) {
            super(v);
            alimento=v.findViewById(R.id.fila_alimento);
            cb = v.findViewById(R.id.checkBox);
            cantidad = v.findViewById(R.id.cantidadAlimento);
        }
    }
}
