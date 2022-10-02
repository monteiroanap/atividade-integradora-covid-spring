package br.com.covid.spring03.modelo;

import java.util.List;

public class Pessoa {
    private long id;
    private String nome;
    private String sobrenome;
    private int idade;
    private List<Sintomas> sintomas;

    public Pessoa(long id, String nome, String sobrenome, int idade, List<Sintomas> sintomas) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.sintomas = sintomas;
    }

    public long getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Sintomas> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<Sintomas> sintomas) {
        this.sintomas = sintomas;
    }

    public boolean isGrupoRisco(){
        return this.idade >= 60 && !this.sintomas.isEmpty();
    }
}
