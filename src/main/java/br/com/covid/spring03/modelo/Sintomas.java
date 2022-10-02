package br.com.covid.spring03.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sintomas {
    private Integer codigo;
    private String nome;
    @JsonProperty("nivel_de_gravidade")
    private Integer nivelGravidade;

    public Sintomas(String nome, Integer nivelGravidade) {
        this.nome = nome;
        this.nivelGravidade = nivelGravidade;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNivelGravidade() {
        return nivelGravidade;
    }

    public void setNivelGravidade(Integer nivelGravidade) {
        this.nivelGravidade = nivelGravidade;
    }
}
