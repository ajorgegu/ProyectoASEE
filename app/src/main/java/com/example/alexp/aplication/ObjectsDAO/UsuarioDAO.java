package com.example.alexp.aplication.ObjectsDAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.alexp.aplication.Objects.Usuario;

@Dao
public interface UsuarioDAO {

    @Query("SELECT * FROM Usuario")
    Usuario getUsuario();

    @Insert
    void insertUsuario(Usuario u);

    @Update
    void updateUsuario(Usuario user);

}
