package com.example.alexp.aplication.Repository;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;

import com.example.alexp.aplication.API.NetworkingAndroidHttpClientJSONActivity;
import com.example.alexp.aplication.DataBase.AppDataBase;
import com.example.alexp.aplication.Objects.Alimento;
import com.example.alexp.aplication.ObjectsDAO.AlimentoDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
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
    private static AlimentoDAO dao;
    private static Application app;

    public AlimentosRepository(Application app) {
        dao = AppDataBase.getInstance(app).alimentoDAO();
        this.app=app;
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

    public Alimento getAlimentoById(int id){ return getAlimentoByIdPrivate(id); }

    public void insertAlimento(Alimento a){insertAlimentoPrivate(a);}

    public void deleteAlimento(Alimento a){deleteAlimentoPrivate(a);}

    private static class getAlimentosPrivate extends AsyncTask<Void, Void, List<Alimento>>{

        protected List<Alimento> doInBackground (Void...params){

            Calendar c = Calendar.getInstance();
            int dia1 = c.get(Calendar.DAY_OF_MONTH);
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(app.getApplicationContext());
            int dia2 = pref.getInt("day",0);
            List<Alimento> alimentos = new ArrayList<Alimento>();
            if(dia2 != dia1){
                SharedPreferences.Editor e = pref.edit();
                e.putInt("day",dia1);
                e.commit();
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
            } catch (JSONException exc) {
                exc.printStackTrace();
            }
            }
            else alimentos=dao.getAlimentos();
            return alimentos;
        }
    }

    private Alimento getAlimentoByIdPrivate(int id){ return dao.getAlimento(id); }

    private void insertAlimentoPrivate(Alimento a){ dao.insertAlimento(a);}

    private void deleteAlimentoPrivate(Alimento a){dao.deleteAlimento(a);}
}
