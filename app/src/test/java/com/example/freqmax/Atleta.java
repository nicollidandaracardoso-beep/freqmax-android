package com.example.freqmax;

public class Atleta {

    String nome;
    int idade;
    int fcm;

    public Atleta(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.fcm = 220 - idade;
    }
}