package com.example.alexp.aplication.API;

import android.net.Uri;
import android.util.Log;
import android.util.Pair;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {

    public static String getResponse(URL url) {

        HttpURLConnection urlConnection = null;
        BufferedReader bufferedReader;

        String line;
        StringBuilder stringBuilder = new StringBuilder();
        Log.i(NetworkUtils.class.getName(), "URL: " + url.toString());

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            while((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            Log.d("Leyendo Json:", stringBuilder.toString());
            if(urlConnection.getResponseCode() != 200)
                Log.e(NetworkUtils.class.getName(), "Connection Error: Error retrieving connection message.");
        } catch (Exception e) {
            Log.e(NetworkUtils.class.getName(), "NetworkError: " + e.getMessage());
        } finally {
            if(urlConnection != null)
                urlConnection.disconnect();
        }

        return stringBuilder.toString();
    }

    public static JSONArray getJSONResponse (URL url) {
        String result = getResponse(url);

        if(result != null && !result.equals("null")) {
            try {
                return new JSONArray(result);
            } catch (JSONException e) {
                Log.e(NetworkUtils.class.getName(), "Error creating JSON object from retrieved data: " + e.getMessage());
            }
        }

        return null;
    }

}