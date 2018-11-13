package ObjectsDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import Objects.Alimento;
import Objects.Comida;

@Dao
public interface ComidaDAO {
    @Query("SELECT * FROM Comida")
    List<Comida> getAllComidas();
/*
    @Query("SELECT alimentos FROM Comida")
    List<Alimento> getAllAlimentos();*/

    @Insert
    void insertComidas(Comida...comidas);


}
