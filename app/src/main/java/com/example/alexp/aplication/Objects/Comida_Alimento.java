package com.example.alexp.aplication.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "Comida_Alimento",primaryKeys ={"comida","id"} )

public class Comida_Alimento implements Serializable {

    @ColumnInfo
    @NonNull
    private String comida;
    @ColumnInfo
    @NonNull
    private int id;
    @ColumnInfo
    private float cantidad;

    public Comida_Alimento(String comida, int id, float cantidad){
        this.comida=comida;
        this.id=id;
        this.cantidad=cantidad;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}
