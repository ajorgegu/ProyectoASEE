package com.example.alexp.aplication.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Comida {

   // @PrimaryKey
   // @NonNull
    @ColumnInfo
    private int dia;
    @ColumnInfo
    private int mes;
    @ColumnInfo
    private int anio;
    @PrimaryKey
    @NonNull
    private String nombre;

   // @ColumnInfo(name="alimentos")
    //private ArrayList<Alimento> alimentos;

    public Comida(int dia, int mes , int anio, String nombre){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
        this.nombre=nombre;
        //this.alimentos=new ArrayList<>();
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

  /*  public Comida(String nombre, ArrayList<Alimento> alimentos) {
        this.nombre = nombre;
        this.alimentos = alimentos;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

  /*  public ArrayList<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimento> alimentos) {
        this.alimentos = alimentos;
    }*/
}
