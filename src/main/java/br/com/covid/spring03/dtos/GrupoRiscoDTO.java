package br.com.covid.spring03.dtos;

import br.com.covid.spring03.modelo.Pessoa;
import br.com.covid.spring03.modelo.Sintomas;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoRiscoDTO implements Serializable {
// aqui é convertido a estrutura de dados em um formato que possa ser trafegado : json.
    String nome;
    int idade;
    List<String> sintomas;

    public GrupoRiscoDTO(Pessoa pessoa){
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
        this.sintomas = pessoa.getSintomas().stream().map(Sintomas::getNome).collect(Collectors.toList());
        //lambda: this.sintomas = pessoa.getSintomas().stream().map(sintoma -> sintoma.getNome()).collect(Collectors.toList());

    }

}
