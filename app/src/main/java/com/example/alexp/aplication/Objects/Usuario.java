package com.example.alexp.aplication.Objects;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Usuario")
public class Usuario implements Serializable{

    @PrimaryKey ()
    private long id;
    @ColumnInfo
    private String nombre;
    @ColumnInfo
    private String apellidos;
    @ColumnInfo
    private float peso;
    @ColumnInfo
    private int edad;

    public Usuario(long id, String nombre, String apellidos, float peso, int edad) {
        this.id = 0;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.peso = peso;
        this.edad = edad;
    }

    @Ignore
    public Usuario(String nombre, String apellidos, float peso, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.peso = peso;
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
