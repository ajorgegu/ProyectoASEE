package com.example.alexp.aplication.ObjectsDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;

@Dao
public interface AlimentoDAO {

    @Query("SELECT * FROM Alimento a")
    List<Alimento> getAlimentos();

    @Query("SELECT * FROM Alimento a WHERE a.id=:id")
    Alimento getAlimento(int id);

    @Insert
    void insertAlimento(Alimento...alimentos);

    @Delete
    void deleteAlimento(Alimento...alimentos);
}
