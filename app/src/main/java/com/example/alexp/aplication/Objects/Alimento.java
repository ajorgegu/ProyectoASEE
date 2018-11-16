package com.example.alexp.aplication.Objects;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "Alimento",foreignKeys = @ForeignKey(entity = Comida.class, parentColumns = "nombre", childColumns = "nombreComida", onDelete = CASCADE))
public class Alimento implements Serializable {
    @PrimaryKey
    private int id;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private float cantidad;
    @ColumnInfo
    private String unidad;
    @ColumnInfo
    private float proteinas;
    @ColumnInfo
    private float hidratos;
    @ColumnInfo
    private float grasas;
    @ColumnInfo
    private String nombreComida;

    public  Alimento(){
        this.id=0;
        this.nombre="";
        this.cantidad=0;
        this.unidad="";
        this.proteinas=0;
        this.hidratos=0;
        this.grasas=0;
    }

    public Alimento(int id, String nombre, float cantidad, String unidad, float proteinas, float hidratos, float grasas) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad= unidad;
        this.proteinas = proteinas;
        this.hidratos = hidratos;
        this.grasas = grasas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public void setHidratos(float hidratos) {
        this.hidratos = hidratos;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    public String getUnidad() {return unidad;}

    public void setUnidad(String unidad) {this.unidad = unidad;}

    public String getNombre() {return nombre;}

    public float getCantidad() {
        return cantidad;
    }

    public float getProteinas() {
        return proteinas;
    }

    public float getHidratos() {
        return hidratos;
    }

    public float getGrasas() {
        return grasas;
    }

    public int getId() {return id;}
}
