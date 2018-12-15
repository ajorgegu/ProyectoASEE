package com.example.alexp.aplication.Objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Entity(tableName = "Comida",primaryKeys ={"nombre","dia","mes","anio"})
public class Comida implements Serializable{

    @ColumnInfo
    @NonNull
    private int dia;
    @ColumnInfo
    @NonNull
    private int mes;
    @ColumnInfo
    @NonNull
    private int anio;
    @ColumnInfo
    @NonNull
    private String nombre;

    public Comida(int dia, int mes , int anio, String nombre){
        this.dia=dia;
        this.mes=mes;
        this.anio=anio;
        this.nombre=nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
