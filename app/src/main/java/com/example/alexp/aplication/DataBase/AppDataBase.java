package com.example.alexp.aplication.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;

@Database(entities = {Comida.class}, version =3)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ComidaDAO comidaDAO();
}
