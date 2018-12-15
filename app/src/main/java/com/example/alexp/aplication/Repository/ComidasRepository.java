package com.example.alexp.aplication.Repository;

import android.app.Application;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;

import java.util.List;

public class ComidasRepository {

    private static ComidaDAO dao;

    public ComidasRepository(Application app) {
        dao = AppDataBase.getInstance(app).comidaDAO();
    }
    public List<String> getAllComidas(int dia, int mes, int anio){return getAllComidasPrivate(dia, mes, anio);}
    //public Comida getComida(String comida){return getComidaPrivate(comida);}
    public void insertComida(Comida c){insertComidaPrivate(c);}
    public void deleteComida(String c){deleteComidaPrivate(c);}

    private List<String> getAllComidasPrivate(int dia, int mes, int anio){return dao.getAllComidas(dia,mes,anio);}
    //private Comida getComidaPrivate(String comida){return dao.getComida(comida);}
    private void insertComidaPrivate(Comida c){dao.insertComidas(c);}
    private void deleteComidaPrivate(String c){dao.deleteComida(c);}
}
