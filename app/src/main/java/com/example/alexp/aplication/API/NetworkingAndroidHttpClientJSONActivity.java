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

import com.example.alexp.aplication.Activities.ListaAlimentosActivity;

public class NetworkingAndroidHttpClientJSONActivity extends AppCompatActivity {

    private static final String ID = "id";
    private static final String NOMBRE = "nombre";
    private static final String CANTIDAD = "cantidad";
    private static final String CALORIAS = "calorias";
    private static final String PROTEINAS = "proteinas";
    private static final String HIDRATOS = "hidratos";
    private static final String GRASAS = "grasas";
    private ArrayList<String> alimentos ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new HttpGetTask().execute();
    }

    private class HttpGetTask extends AsyncTask<Void, Void, ArrayList<String>> {

        private static final String BASE_URL = "https://drive.google.com/a/alumnos.unex.es/uc?authuser=1&id=1w50uRcKXheRXkqyXjkAa7QAyOvmfpMPG&export=download";

        @Override
        protected ArrayList<String> doInBackground(Void... params) {
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
        protected void onPostExecute(ArrayList<String> result) {
            alimentos = result;
            Intent i=  new Intent(NetworkingAndroidHttpClientJSONActivity.this, ListaAlimentosActivity.class);
            i.putExtra("lista",alimentos);
            startActivity(i);
        }
    }

    public ArrayList<String> jsonToList(JSONArray responseObject) {
        ArrayList<String> result = new ArrayList<String>();

        try {
         //   JSONArray alimentos = responseObject
                   // .getJSONArray(NOMBRE);

            for (int i = 0; i < responseObject.length(); i++) {
                JSONObject alimento = responseObject.getJSONObject(i);
                result.add(alimento.get(NOMBRE)  + "\n"
                        +  "ID: "+ alimento.get(ID) + '\n'
                        +  " Cantidad: "+ alimento.get(CANTIDAD) + '\n'
                        +  " Unidad: "+ alimento.get(CALORIAS) + '\n'
                        +  " Proteinas: "+ alimento.get(PROTEINAS) + '\n'
                        +  " Hidratos: "+ alimento.get(HIDRATOS)+ '\n'
                        +  " Grasas: "+ alimento.get(GRASAS));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }
}

