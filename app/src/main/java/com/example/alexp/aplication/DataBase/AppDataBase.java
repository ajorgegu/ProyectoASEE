package com.example.alexp.aplication.DataBase;

import  android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.Objects.Usuario;
import com.example.alexp.aplication.ObjectsDAO.AlimentoDAO;
import com.example.alexp.aplication.ObjectsDAO.ComidaAlimentoDAO;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;
import com.example.alexp.aplication.ObjectsDAO.UsuarioDAO;

@Database(entities = {Comida.class , Alimento.class, Comida_Alimento.class, Usuario.class}, version =1)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase apd = null;
    public static AppDataBase getInstance(Context c){
        if(apd==null){
            apd= Room.databaseBuilder(c.getApplicationContext(),AppDataBase.class,"appdb.bd").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return apd;
    }

    public abstract ComidaDAO comidaDAO();
    public abstract AlimentoDAO alimentoDAO();
    public abstract ComidaAlimentoDAO comidaalimentoDAO();
    public abstract UsuarioDAO usuarioDAO();
}