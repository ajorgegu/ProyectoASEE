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

public class HolderAlimentos extends RecyclerView.ViewHolder implements  View.OnClickListener{

    public TextView t;
    public  CheckBox cb;
    public EditText et;
    public itemClickListener icl;

    public HolderAlimentos(@NonNull View itemView) {
        super(itemView);
        t = (TextView) itemView.findViewById(R.id.fila_alimento);
        cb = (CheckBox) itemView.findViewById(R.id.checkBox);
        cb.setOnClickListener(this);
        et=(EditText) itemView.findViewById(R.id.cantidadAlimento);
    }

    public void setItemClickListener(itemClickListener icl){this.icl=icl;}

    @Override
    public void onClick(View v) {
        this.icl.onItemClick(v,getLayoutPosition());
    }
}
