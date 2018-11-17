package com.example.alexp.aplication.ObjectsDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;

@Dao
public interface ComidaDAO {
    @Query("SELECT c.nombre FROM Comida c WHERE c.dia=:dia AND c.mes=:mes AND c.anio=:anio")
    List<String> getAllComidas(int dia, int mes, int anio);

    @Insert
    void insertComidas(Comida...comidas);

    @Insert
    void insertAlimento(Alimento...alimentos);

    @Delete
    void deleteAlimento(Alimento...alimentos);

    @Query("SELECT * FROM Alimento WHERE nombrecomida=:ncomida")
    List<Alimento> getAlimentos(String ncomida);

}
