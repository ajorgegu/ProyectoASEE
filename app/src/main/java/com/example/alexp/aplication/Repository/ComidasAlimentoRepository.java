package com.example.alexp.aplication.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Comida;
import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaAlimentoDAO;

import java.util.ArrayList;
import java.util.List;

public class ComidasAlimentoRepository {
    private static ComidaAlimentoDAO dao;

    public ComidasAlimentoRepository(Application app) {
        dao = AppDataBase.getInstance(app).comidaalimentoDAO();
    }

    public LiveData<List<Comida_Alimento>> getComidasAlimento(String comida, int dia, int mes, int anio){return getComidasAlimentoPrivate(comida,dia,mes,anio);}
    public void deleteComidaAlimento(String comida){deleteComidaAlimentoPrivate(comida);}
    public void insertComidaAlimento(Comida_Alimento c){insertComidaAlimentoPrivate(c);}
    public void deleteOneComidaAlimento(String com, int ident, float cant, int dia, int mes, int anio){deleteOneComidaAlimentoPrivate(com,ident,cant,dia,mes,anio);}
    public void updateComidaAlimento(Comida_Alimento c){updateComidaAlimentoPrivate(c);}

    private LiveData<List<Comida_Alimento>> getComidasAlimentoPrivate(String comida, int dia, int mes, int anio){return dao.getComidasAlimento(comida,dia,mes,anio);}
    private void deleteComidaAlimentoPrivate(String comida){dao.deleteComidaAlimento(comida);}
    private void insertComidaAlimentoPrivate(Comida_Alimento c){dao.insertComidaAlimento(c);}
    private void deleteOneComidaAlimentoPrivate(String com, int ident, float cant, int dia, int mes, int anio){dao.deleteOneComidaAlimento(com,ident,cant,dia,mes,anio);}
    private void updateComidaAlimentoPrivate(Comida_Alimento c){dao.updateComidaAlimento(c);}
}
