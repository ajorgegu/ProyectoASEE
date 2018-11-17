package com.example.alexp.aplication.API;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alexp.aplication.Activities.ListaAlimentosActivity;
import com.example.alexp.aplication.Objects.Alimento;

import static java.nio.file.Paths.get;

public class NetworkingAndroidHttpClientJSONActivity extends AppCompatActivity {

    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String CANTIDAD = "cantidad";
    private static final String UNIDAD = "calorias";
    private static final String PROTEINAS = "proteinas";
    private static final String HIDRATOS = "hidratos";
    private static final String GRASAS = "grasas";
    private ArrayList<Alimento> alimentos ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HttpGetTask().execute();
    }

    private class HttpGetTask extends AsyncTask<Void, Void, ArrayList<Alimento>> {

        private static final String BASE_URL = "https://drive.google.com/a/alumnos.unex.es/uc?authuser=1&id=1w50uRcKXheRXkqyXjkAa7QAyOvmfpMPG&export=download";

        @Override
        protected ArrayList<Alimento> doInBackground(Void... params) {
            URL queryURL;
            JSONArray result;

            try {
                queryURL = new URL(BASE_URL);
                result = NetworkUtils.getJSONResponse(queryURL);
                if(result != null)
                    return jsonToList(result);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Alimento> result) {
            alimentos = result;
            Intent i=  new Intent(NetworkingAndroidHttpClientJSONActivity.this, ListaAlimentosActivity.class);
            i.putExtra("lista",alimentos);
            i.putExtra("nombrecomida",getIntent().getExtras().getString("nombrecomida"));
            i.putExtra("anio",getIntent().getExtras().getInt("anio"));
            i.putExtra("mes",getIntent().getExtras().getInt("mes"));
            i.putExtra("dia",getIntent().getExtras().getInt("dia"));
            startActivity(i);
        }
    }

    public ArrayList<Alimento> jsonToList(JSONArray responseObject) {
        ArrayList<Alimento> result = new ArrayList<Alimento>();

        try {
            for (int i = 0; i < responseObject.length(); i++) {
                JSONObject alimento = responseObject.getJSONObject(i);
                Alimento a = new Alimento(alimento.getInt(ID),
                        alimento.getString(NOMBRE),
                        (float)alimento.getDouble(CANTIDAD),
                        alimento.getString(UNIDAD),(float)
                        alimento.getDouble(PROTEINAS),
                        (float)alimento.getDouble(HIDRATOS),
                        (float)alimento.getDouble(GRASAS));
              result.add(a);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}

