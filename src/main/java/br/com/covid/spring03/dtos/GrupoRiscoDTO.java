package br.com.covid.spring03.dtos;

import br.com.covid.spring03.modelo.Pessoa;
import br.com.covid.spring03.modelo.Sintomas;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoRiscoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    // aqui é convertido a estrutura de dados em um formato que possa ser trafegado : json.
    private String nome;
    private int idade;
    private List<String> sintomas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(List<String> sintomas) {
        this.sintomas = sintomas;
    }

    public GrupoRiscoDTO(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
        this.sintomas = pessoa.getSintomas().stream().map(Sintomas::getNome).collect(Collectors.toList());
        //lambda: this.sintomas = pessoa.getSintomas().stream().map(sintoma -> sintoma.getNome()).collect(Collectors.toList());

    }

}
