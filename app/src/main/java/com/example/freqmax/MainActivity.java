package com.example.freqmax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.freqmax.adapter.AtletaAdapter;
import com.example.freqmax.model.Atleta;
import com.example.freqmax.utils.AtletaStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    EditText edtNome, edtIdade;
    Button btnAdicionar;
    ListView listaAtletas;

    ArrayList<Atleta> atletas;

    AtletaAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        listaAtletas = findViewById(R.id.listaAtletas);


        // Carrega atletas salvos no celular
        atletas = AtletaStorage.carregarAtletas(this);


        // Ordena atletas pelo maior FCM
        Collections.sort(atletas, new Comparator<Atleta>() {
            @Override
            public int compare(Atleta a1, Atleta a2) {
                return a2.getFcm() - a1.getFcm();
            }
        });


        adapter = new AtletaAdapter(
                this,
                atletas
        );


        listaAtletas.setAdapter(adapter);



        btnAdicionar.setOnClickListener(v -> {

            String nome = edtNome.getText().toString().trim();
            String idadeTexto = edtIdade.getText().toString().trim();


            if (nome.isEmpty() || idadeTexto.isEmpty()) {
                return;
            }


            int idade = Integer.parseInt(idadeTexto);


            Atleta atleta = new Atleta(nome, idade);


            atletas.add(atleta);


            Collections.sort(atletas, new Comparator<Atleta>() {
                @Override
                public int compare(Atleta a1, Atleta a2) {
                    return a2.getFcm() - a1.getFcm();
                }
            });


            // Salva no celular
            AtletaStorage.salvarAtletas(this, atletas);


            // Atualiza a lista
            adapter.notifyDataSetChanged();


            edtNome.setText("");
            edtIdade.setText("");

        });

    }
}