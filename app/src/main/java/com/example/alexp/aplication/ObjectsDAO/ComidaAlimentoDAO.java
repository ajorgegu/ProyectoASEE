package com.example.alexp.aplication.ObjectsDAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import com.example.alexp.aplication.Objects.Comida_Alimento;

@Dao
public interface ComidaAlimentoDAO {

    @Query("SELECT * FROM Comida_Alimento c WHERE c.comida=:comida AND c.dia=:dia AND c.mes=:mes AND c.anio=:anio")
    LiveData<List<Comida_Alimento>> getComidasAlimento(String comida, int dia, int mes, int anio);

    @Insert
    void insertComidaAlimento(Comida_Alimento...comida_alimentos);

    @Update
    void updateComidaAlimento(Comida_Alimento...comida_alimentos);

    @Query("DELETE FROM Comida_Alimento WHERE comida=:comida")
    void deleteComidaAlimento(String comida);

    @Query("DELETE FROM Comida_Alimento WHERE comida=:com AND id=:ident AND cantidad=:cant AND dia=:dia AND mes=:mes AND anio=:anio")
    void deleteOneComidaAlimento(String com, int ident, float cant, int dia, int mes ,int anio);

}
