package com.example.alexp.aplication.Holders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alexp.aplication.Adapters.itemClickListener;
import com.example.alexp.aplication.R;

public class HolderDescripcion extends RecyclerView.ViewHolder implements  View.OnClickListener{

    public TextView t;
    public EditText et;
    public itemClickListener icl;
    public Button borrar;
    public Button guardar;

    public HolderDescripcion(@NonNull View itemView) {
        super(itemView);
        t = (TextView) itemView.findViewById(R.id.fila_alimento);
        borrar= (Button) itemView.findViewById(R.id.borrarcomida);
        borrar.setOnClickListener(this);
        et=(EditText) itemView.findViewById(R.id.cantidadAlimento);
    }

    public void setItemClickListener(itemClickListener icl){this.icl=icl;}

    @Override
    public void onClick(View v) {
        this.icl.onItemClick(v,getLayoutPosition());
    }
}
