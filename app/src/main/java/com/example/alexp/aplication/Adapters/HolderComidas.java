package com.example.alexp.aplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.example.alexp.aplication.R;

public class HolderComidas extends RecyclerView.ViewHolder implements  View.OnClickListener{

    Button b,borrar;
    itemClickListener icl;
    itemClickListener ic2;

    public HolderComidas(@NonNull View itemView) {
        super(itemView);
        b = (Button) itemView.findViewById(R.id.fila_comida);
        borrar=(Button) itemView.findViewById(R.id.borrarcomida);
        b.setOnClickListener(this);
        borrar.setOnClickListener(this);
    }

    public void setItemClickListener(itemClickListener icl){
        this.icl=icl;
    }

    public void setItemClickListenerBorrar(itemClickListener icl){
        this.ic2=ic2;
    }

    @Override
    public void onClick(View v) {
        this.icl.onItemClick(v,getLayoutPosition());
    }
}
