package com.example.alexp.aplication.API;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static java.nio.file.Paths.get;

public class NetworkingAndroidHttpClientJSONActivity extends AppCompatActivity {

    private static final String BASE_URL = "https://drive.google.com/a/alumnos.unex.es/uc?authuser=1&id=1w50uRcKXheRXkqyXjkAa7QAyOvmfpMPG&export=download";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static JSONArray devolverJson () {

            URL queryURL;
            JSONArray result;

            try {
                queryURL = new URL(BASE_URL);
                result = NetworkUtils.getJSONResponse(queryURL);
                if (result != null)
                    return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

