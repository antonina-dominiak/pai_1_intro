package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        String url = "https://mdn.github.io/learning-area/javascript/oojs/json/superheroes.json";

        try {
            String json = downloadJson(url);
            //System.out.println(json);

            Gson gson = new GsonBuilder().create();
            Squad myObject = gson.fromJson(json, Squad.class);

            for (Superhero hero: myObject.members) {
                System.out.println(hero.name);
            }

        } catch (IOException e) {
            System.err.println("failed to download and parse" + e.getMessage());
        }
    }

    private static String downloadJson(String url) throws IOException {
        URL jsonUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) jsonUrl.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                 BufferedReader bufferedReader = new BufferedReader(reader)) {

                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                return stringBuilder.toString();
            }
        } else {
            throw new IOException("http request failed" + responseCode);
        }
    }
}

class Squad {
    List<Superhero> members;
}

class Superhero {
    String name;
}