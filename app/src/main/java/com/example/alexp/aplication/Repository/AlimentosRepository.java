package com.example.alexp.aplication.Repository;

import android.app.Application;
import android.os.AsyncTask;

import com.example.alexp.aplication.API.NetworkingAndroidHttpClientJSONActivity;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.ObjectsDAO.ComidaDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class AlimentosRepository {

    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String CANTIDAD = "cantidad";
    private static final String UNIDAD = "calorias";
    private static final String PROTEINAS = "proteinas";
    private static final String HIDRATOS = "hidratos";
    private static final String GRASAS = "grasas";
    private static ComidaDAO dao;

    public AlimentosRepository(Application app) {
        dao = AppDataBase.getInstance(app).comidaDAO();
    }

    public List<Alimento> getAlimentos(){
        getAlimentosPrivate myTask = new getAlimentosPrivate();
        List<Alimento> a = new ArrayList<Alimento>();
        try {
            return myTask.execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return a;
    }
    private static class getAlimentosPrivate extends AsyncTask<Void, Void, List<Alimento>>{

        protected List<Alimento> doInBackground (Void...params){
            List<Alimento> alimentos = new ArrayList<Alimento>();
            alimentos = dao.getAlimentos();
            if (alimentos.size() == 0) {
                try {
                JSONArray responseObject = NetworkingAndroidHttpClientJSONActivity.devolverJson();
                for (int i = 0; i < responseObject.length(); i++) {
                    JSONObject alimento = responseObject.getJSONObject(i);
                    Alimento a = new Alimento(alimento.getInt(ID),
                            alimento.getString(NOMBRE),
                            (float) alimento.getDouble(CANTIDAD),
                            alimento.getString(UNIDAD), (float)
                            alimento.getDouble(PROTEINAS),
                            (float) alimento.getDouble(HIDRATOS),
                            (float) alimento.getDouble(GRASAS));

                        dao.insertAlimento(a);
                        alimentos.add(a);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            }
            return alimentos;
        }
    }
}
