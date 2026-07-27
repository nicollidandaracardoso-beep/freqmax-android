package com.example.freqmax.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.freqmax.model.Atleta;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AtletaStorage {

    private static final String NOME_ARQUIVO = "atletas";
    private static final String CHAVE_ATLETAS = "lista_atletas";


    public static void salvarAtletas(Context context, ArrayList<Atleta> atletas) {

        SharedPreferences preferences = context.getSharedPreferences(
                NOME_ARQUIVO,
                Context.MODE_PRIVATE
        );


        JSONArray array = new JSONArray();


        try {

            for (Atleta atleta : atletas) {

                JSONObject objeto = new JSONObject();

                objeto.put("nome", atleta.getNome());
                objeto.put("idade", atleta.getIdade());

                array.put(objeto);
            }


            preferences.edit()
                    .putString(CHAVE_ATLETAS, array.toString())
                    .apply();


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



    public static ArrayList<Atleta> carregarAtletas(Context context) {

        ArrayList<Atleta> atletas = new ArrayList<>();


        SharedPreferences preferences = context.getSharedPreferences(
                NOME_ARQUIVO,
                Context.MODE_PRIVATE
        );


        String dados = preferences.getString(CHAVE_ATLETAS, null);


        if (dados != null) {

            try {

                JSONArray array = new JSONArray(dados);


                for (int i = 0; i < array.length(); i++) {

                    JSONObject objeto = array.getJSONObject(i);


                    String nome = objeto.getString("nome");
                    int idade = objeto.getInt("idade");


                    atletas.add(new Atleta(nome, idade));
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


        return atletas;
    }
}