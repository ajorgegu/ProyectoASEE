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
public interface ComidaDAO {
    @Query("SELECT c.nombre FROM Comida c WHERE c.dia=:dia AND c.mes=:mes AND c.anio=:anio")
    List<String> getAllComidas(int dia, int mes, int anio);

    @Query("SELECT * FROM Alimento a")
    List<Alimento> getAlimentos();

    @Query("SELECT * FROM Comida_Alimento c WHERE c.comida=:comida")
    List<Comida_Alimento> getComidasAlimento(String comida);

    @Query("SELECT * FROM Comida c WHERE c.nombre=:comida")
    Comida getComida(String comida);

    @Query("SELECT * FROM Alimento a WHERE a.id=:id")
    Alimento getAlimento(int id);

    @Insert
    void insertComidas(Comida...comidas);

    @Insert
    void insertAlimento(Alimento...alimentos);

    @Insert
    void insertComidaAlimento(Comida_Alimento...comida_alimentos);

    @Update
    void updateComidaAlimento(Comida_Alimento...comida_alimentos);

    @Delete
    void deleteAlimento(Alimento...alimentos);

    @Query("DELETE FROM Comida_Alimento WHERE comida=:comida")
    void deleteComidaAlimento(String comida);

    @Query("DELETE FROM Comida_Alimento WHERE comida=:com AND id=:ident AND cantidad=:cant")
    void deleteOneComidaAlimento(String com, int ident, float cant);

    @Query("DELETE FROM Comida WHERE nombre=:comida")
    void deleteComida(String comida);
}
