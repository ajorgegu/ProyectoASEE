package com.example.alexp.aplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class DescripcionAdapter extends RecyclerView.Adapter<HolderDescripcion> {

    private ArrayList<Alimento> alimentos;
    private ArrayList<Comida_Alimento> c_a= new ArrayList<>();
    private List<Pair<Integer, Float>> alimcant= new ArrayList<Pair<Integer, Float>>();
    private static Context c;
    private ComidaDAO cdao;
    private String nombrecomida;
    private LinkedList<Float> cantidades = new LinkedList<Float>();
    private ArrayList<Pair<HolderDescripcion,Integer>> haux= new ArrayList<Pair<HolderDescripcion,Integer>>();

    public DescripcionAdapter(Context c, ArrayList<Alimento> alimentos, ArrayList<Comida_Alimento>c_a){
        this.c=c;
        this.alimentos=alimentos;
        this.c_a=c_a;
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

        holder.et.setText(String.valueOf(c_a.get(i).getCantidad()));

        Pair p = new Pair(holder,alimentos.get(i).getId());
        haux.add(p);

        holder.setItemClickListener( new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                    ComidaDAO cdao = AppDataBase.getInstance(c).comidaDAO();
                    cdao.deleteOneComidaAlimento(c_a.get(pos).getComida(),c_a.get(pos).getId(),c_a.get(pos).getCantidad());
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

    public List<Pair<Integer, Float>> getAlimcant(){
       for(int i=0; i<haux.size();i++){
           Pair p = new Pair(haux.get(i).second,Float.parseFloat(haux.get(i).first.et.getText().toString()));
           Log.d("Par introducido: ",p.first.toString()+" "+p.second.toString());
           alimcant.add(p);
       }
        return this.alimcant;
    }


    @Override
    public int getItemCount() {return alimentos.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView alimento;
        public EditText cantidad;
        public Button borrar;
        public ViewHolder(View v) {
            super(v);
            alimento=v.findViewById(R.id.fila_alimento);
            cantidad = v.findViewById(R.id.cantidadAlimento);
            borrar = v.findViewById(R.id.borrarcomida);
        }
    }

}
