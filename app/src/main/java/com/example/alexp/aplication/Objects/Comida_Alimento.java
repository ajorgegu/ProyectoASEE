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

    public Comida_Alimento(String comida, int id){
        this.comida=comida;
        this.id=id;
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
}
