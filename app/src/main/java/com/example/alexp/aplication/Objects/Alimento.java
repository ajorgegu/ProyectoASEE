package com.example.alexp.aplication.Objects;


public class Alimento {
    private int id;
    private String nombre;
    private float cantidad;
    private float calorias;
    private float proteinas;
    private float hidratos;
    private float grasas;

    public  Alimento(){
        this.id=0;
        this.nombre="";
        this.cantidad=0;
        this.calorias=0;
        this.proteinas=0;
        this.hidratos=0;
        this.grasas=0;

    }

    public Alimento(int id, String nombre, float cantidad, float calorias, float proteinas, float hidratos, float grasas) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.calorias = calorias;
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

    public void setCalorias(float calorias) {
        this.calorias = calorias;
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

    public String getNombre() {

        return nombre;
    }

    public float getCantidad() {
        return cantidad;
    }

    public float getCalorias() {
        return calorias;
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

    public int getId() {

        return id;
    }
}
