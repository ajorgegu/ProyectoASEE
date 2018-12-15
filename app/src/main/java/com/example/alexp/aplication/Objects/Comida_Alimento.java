package com.example.alexp.aplication.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "Comida_Alimento",primaryKeys ={"comida","id","dia","mes","anio"} )

public class Comida_Alimento implements Serializable {

    @ColumnInfo
    @NonNull
    private String comida;
    @ColumnInfo
    @NonNull
    private int id;
    @ColumnInfo
    private float cantidad;
    @ColumnInfo
    @NonNull
    private int dia;
    @ColumnInfo
    @NonNull
    private int mes;
    @ColumnInfo
    @NonNull
    private int anio;

    public Comida_Alimento(String comida, int id, float cantidad, int dia, int mes, int anio){
        this.comida=comida;
        this.id=id;
        this.cantidad=cantidad;
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
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

    @NonNull
    public int getDia() { return dia; }

    public void setDia(@NonNull int dia) { this.dia = dia; }

    @NonNull
    public int getMes() { return mes; }

    public void setMes(@NonNull int mes) { this.mes = mes; }

    @NonNull
    public int getAnio() { return anio; }

    public void setAnio(@NonNull int anio) { this.anio = anio; }
}
