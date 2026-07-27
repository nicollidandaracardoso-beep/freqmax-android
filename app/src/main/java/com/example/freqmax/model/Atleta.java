package com.example.freqmax.model;

public class Atleta {

    private String nome;
    private int idade;
    private int fcm;

    public Atleta(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.fcm = 220 - idade;
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
}