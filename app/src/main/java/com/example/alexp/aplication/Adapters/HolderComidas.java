package com.example.alexp.aplication.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.example.alexp.aplication.R;

public class HolderComidas extends RecyclerView.ViewHolder implements  View.OnClickListener{

    Button b;
    itemClickListener icl;

    public HolderComidas(@NonNull View itemView) {
        super(itemView);
        b = (Button) itemView.findViewById(R.id.fila_comida);
        b.setOnClickListener(this);
    }

    public void setItemClickListener(itemClickListener icl){
        this.icl=icl;
    }

    @Override
    public void onClick(View v) {
        this.icl.onItemClick(v,getLayoutPosition());
    }
}
