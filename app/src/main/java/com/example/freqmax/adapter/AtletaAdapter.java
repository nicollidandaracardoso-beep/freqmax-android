package com.example.freqmax.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.freqmax.R;
import com.example.freqmax.model.Atleta;
import com.example.freqmax.utils.AtletaStorage;

import java.util.ArrayList;

public class AtletaAdapter extends ArrayAdapter<Atleta> {

    private Context context;
    private ArrayList<Atleta> atletas;


    public AtletaAdapter(Context context, ArrayList<Atleta> atletas) {
        super(context, 0, atletas);
        this.context = context;
        this.atletas = atletas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_atleta, parent, false);
        }


        TextView txtNome = convertView.findViewById(R.id.txtNome);
        TextView txtIdade = convertView.findViewById(R.id.txtIdade);
        TextView txtFcm = convertView.findViewById(R.id.txtFcm);
        TextView txtClassificacao = convertView.findViewById(R.id.txtClassificacao);

        Button btnExcluir = convertView.findViewById(R.id.btnExcluir);


        Atleta atleta = atletas.get(position);


        txtNome.setText(atleta.getNome());

        txtIdade.setText(
                "Idade: " + atleta.getIdade() + " anos"
        );

        txtFcm.setText(
                "FCM máxima: " + atleta.getFcm() + " bpm"
        );


        txtClassificacao.setText(
                "Intensidade: " + atleta.getClassificacao()
        );


        // Define cor conforme a intensidade
        if (atleta.getClassificacao().equals("Alta intensidade")) {

            txtClassificacao.setTextColor(Color.RED);

        } else if (atleta.getClassificacao().equals("Moderada intensidade")) {

            txtClassificacao.setTextColor(Color.rgb(255, 165, 0));

        } else {

            txtClassificacao.setTextColor(Color.GREEN);

        }


        btnExcluir.setOnClickListener(v -> {

            atletas.remove(position);

            AtletaStorage.salvarAtletas(context, atletas);

            notifyDataSetChanged();

        });


        return convertView;
    }
}