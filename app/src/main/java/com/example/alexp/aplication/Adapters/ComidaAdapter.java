package com.example.alexp.aplication.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.alexp.aplication.Activities.ComidasActivity;
import com.example.alexp.aplication.Activities.DescripcionComidaActivity;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.R;

import java.util.List;


public class ComidaAdapter extends RecyclerView.Adapter<HolderComidas> {

   private List<String> comidas;
   private Context c;

    public ComidaAdapter(Context c,List<String> comidas){
        this.comidas=comidas;
        this.c=c;
    }

    @Override
    public HolderComidas onCreateViewHolder(ViewGroup viewGroup, int i) {
      View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filacomida,viewGroup,false);
      return new HolderComidas(v);
    }

    @Override
    public void onBindViewHolder(final HolderComidas holder, int i) {

        holder.b.setText(comidas.get(i));

        holder.setItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick (View v, int pos) {
                if(v.getId()==R.id.fila_comida) {
                    Intent i = new Intent(c, DescripcionComidaActivity.class);
                    i.putExtra("nombrecomida", holder.b.getText().toString());
                    c.startActivity(i);
                }
                else{
                    ComidaDAO cdao = AppDataBase.getInstance(c).comidaDAO();
                    String comida = holder.b.getText().toString();
                    cdao.deleteComidaAlimento(comida);
                    cdao.deleteComida(comida);
                    comidas.remove(pos);
                    notifyDataSetChanged();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return comidas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public Button comida;
        public Button borrar;

        public ViewHolder(View itemView) {
            super(itemView);
            comida=itemView.findViewById(R.id.fila_comida);
            borrar=itemView.findViewById(R.id.borrarcomida);
        }
    }
}
