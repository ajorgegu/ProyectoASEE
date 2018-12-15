package com.example.alexp.aplication.ViewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.alexp.aplication.Objects.Comida_Alimento;
import com.example.alexp.aplication.Repository.ComidasAlimentoRepository;

import java.util.ArrayList;
import java.util.List;

public class DescripcionComidaViewModel extends AndroidViewModel {

    private ComidasAlimentoRepository carep;
    private LiveData<Comida_Alimento> allca;

    public DescripcionComidaViewModel(@NonNull Application app){
        super(app);
        carep=new ComidasAlimentoRepository(app);
        allca=null;
    }

    public LiveData<List<Comida_Alimento>> getAllca(String comida, int dia , int mes, int anio) {
        return carep.getComidasAlimento(comida,dia,mes,anio);
    }
}
