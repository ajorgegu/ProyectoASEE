package com.example.alexp.aplication.Adapters;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexp.aplication.Holders.HolderDescripcion;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.R;
import com.example.alexp.aplication.Repository.ComidasAlimentoRepository;

import java.util.ArrayList;
import java.util.List;


public class DescripcionAdapter extends RecyclerView.Adapter<HolderDescripcion> {

    private ArrayList<Alimento> alimentos= new ArrayList<Alimento>();
    private ArrayList<Comida_Alimento> c_a= new ArrayList<>();
    private List<Pair<Integer, Float>> alimcant= new ArrayList<Pair<Integer, Float>>();
    private static Context c;
    private ComidasAlimentoRepository carep;
    private String nombrecomida;
    private int dia,mes,anio;
    private ArrayList<Pair<HolderDescripcion,Integer>> haux= new ArrayList<Pair<HolderDescripcion,Integer>>();

    public DescripcionAdapter(Context c, Application app){
        this.c=c;
        carep=new ComidasAlimentoRepository(app);
    }

    @Override
    public HolderDescripcion onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filaalimento2,viewGroup,false);
        return new HolderDescripcion(v);
    }

    @Override
    public void onBindViewHolder(final HolderDescripcion holder, int i) {
        holder.t.setText(alimentos.get(i).getNombre()+"\n"+
                "Cantidad: "+        Float.toString(alimentos.get(i).getCantidad()) +"\n"+
                "Unidad: "+ alimentos.get(i).getUnidad() +"\n"+
                "Proteinas: "+ Float.toString(alimentos.get(i).getProteinas()) +"\n"+
                "Hidratos: "+Float.toString(alimentos.get(i).getHidratos()) +"\n"+
                "Grasas: "+Float.toString(alimentos.get(i).getGrasas()) +"\n");
        Log.d("Tamaño comidaalimento: ",String.valueOf(c_a.size())+" "+i);
        Log.d("Cantidad: ",String.valueOf(c_a.get(i).getCantidad())+" "+i);
        holder.et.setText(String.valueOf(c_a.get(i).getCantidad()));

        Pair p = new Pair(holder,alimentos.get(i).getId());
        haux.add(p);

        holder.setItemClickListener( new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                carep.deleteOneComidaAlimento(c_a.get(pos).getComida(),c_a.get(pos).getId(),c_a.get(pos).getCantidad(),dia,mes,anio);
                alimentos.remove(pos);
                notifyDataSetChanged();
            }
        });
    }

    public void setNombrecomida(String nombrecomida) {
        this.nombrecomida = nombrecomida;
    }

    public String getNombrecomida() {
        return this.nombrecomida;
    }

    public void setFecha(int dia, int mes, int anio){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
    }

    public List<Pair<Integer, Float>> getAlimcant(){
        for(int i=0; i<haux.size();i++){
            Pair p = new Pair(haux.get(i).second,Float.parseFloat(haux.get(i).first.et.getText().toString()));
            Log.d("Par introducido: ",p.first.toString()+" "+p.second.toString());
            alimcant.add(p);
        }
        return this.alimcant;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos, ArrayList<Comida_Alimento> calimentos){
        this.alimentos=alimentos;
        this.c_a=calimentos;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {return alimentos.size();}
}
