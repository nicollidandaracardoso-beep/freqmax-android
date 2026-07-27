package com.example.freqmax.model;

public class Atleta {

    private String nome;
    private int idade;
    private int fcm;
    private String classificacao;

    public Atleta(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.fcm = 220 - idade;
        this.classificacao = calcularClassificacao();
    }

    private String calcularClassificacao() {

        if (fcm < 140) {
            return "Baixa intensidade";
        } else if (fcm < 180) {
            return "Moderada intensidade";
        } else {
            return "Alta intensidade";
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getFcm() {
        return fcm;
    }

    public String getClassificacao() {
        return classificacao;
    }
}