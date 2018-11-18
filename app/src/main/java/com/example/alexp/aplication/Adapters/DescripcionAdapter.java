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
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;

import java.util.ArrayList;
import java.util.List;


public class DescripcionAdapter extends RecyclerView.Adapter<HolderAlimentos> {

    private ArrayList<Alimento> alimentos;
    private ArrayList<Alimento> alimentosSeleccionados= new ArrayList<>();
    private ArrayList<Comida_Alimento> c_a= new ArrayList<>();
    private static Context c;
    private ComidaDAO cdao;
    private String nombrecomida;
    private EditText e;

    public DescripcionAdapter(Context c, ArrayList<Alimento> alimentos, ArrayList<Comida_Alimento>c_a){
        this.c=c;
        this.alimentos=alimentos;
        this.c_a=c_a;
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

    Log.d("Mostrando cantidad: ",String.valueOf(c_a.get(i).getCantidad()));
        holder.et.setText(String.valueOf(c_a.get(i).getCantidad()));

        holder.setItemClickListener( new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox cb2 = (CheckBox) v;
                cdao= AppDataBase.getInstance(c).comidaDAO();
                Float cantidad= Float.parseFloat(holder.et.getText().toString());
                Log.d("Cantidad del alimento: ",String.valueOf(cantidad));
                if(cb2.isChecked()){
                    alimentosSeleccionados.add(alimentos.get(pos));
                    Comida_Alimento ca = new Comida_Alimento(nombrecomida, alimentosSeleccionados.get(pos).getId(),cantidad);
                    c_a.add(ca);

                }else{
                    alimentosSeleccionados.remove(alimentos.get(pos));
                    Comida_Alimento ca = new Comida_Alimento(nombrecomida, alimentosSeleccionados.get(pos).getId(), cantidad);
                    c_a.remove(ca);

                }
            }
        });
    }

    public void setNombrecomida(String nombrecomida) {
        this.nombrecomida = nombrecomida;
    }

    public String getNombrecomida() {
        return this.nombrecomida;
    }

    public ArrayList<Comida_Alimento> getC_a() {
        return c_a;
    }

    @Override
    public int getItemCount() {return alimentos.size();}

    public ArrayList<Alimento> getAlimentosSeleccionados(){
        return this.alimentosSeleccionados;
    }

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
