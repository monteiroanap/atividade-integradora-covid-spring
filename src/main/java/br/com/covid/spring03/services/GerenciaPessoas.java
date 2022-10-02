package br.com.covid.spring03.services;

import br.com.covid.spring03.modelo.Pessoa;
import br.com.covid.spring03.modelo.Sintomas;
import br.com.covid.spring03.util.NumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


// esse package servicos é usado como uma ponte para os endpoints
//aqui é descrito os metodos, buscar, deletar, atualizar, e inserir.
@Service
public class GerenciaPessoas {
    @Autowired
    private GerenciaSintomas gerenciaSintomas;

    private Map<Integer, Pessoa> pessoas;

    public GerenciaPessoas() {
        this.pessoas = new HashMap<>();
        int id = NumberGenerator.getInstance().proximaPessoa();
        this.pessoas.put(id, new Pessoa(id, "ana", "teste", 20, new ArrayList<>()));
//        id = NumberGenerator.getInstance().proximaPessoa();
//        this.pessoas.put(id, new Pessoa(id, "paula", "teste1", 30, Arrays.asList(gerenciaSintomas.consultarSintoma(2))));
//        id = NumberGenerator.getInstance().proximaPessoa();
//        this.pessoas.put(id, new Pessoa(id, "joao", "altinho", 67, Arrays.asList(gerenciaSintomas.consultarSintoma(3))));
//        id = NumberGenerator.getInstance().proximaPessoa();
//        this.pessoas.put(id, new Pessoa(id, "jose", "baixinho", 71, Arrays.asList(gerenciaSintomas.consultarSintoma(1))));
    }
    public List<Pessoa> consultarPessoaRisco(){
        return pessoas.values().stream().filter(p ->{ // quando eu tenho mais de uma condicao,coisas, dentro do lambda é obrigado colocar dentro de {}
            return p.getIdade() >= 60 && !p.getSintomas().isEmpty(); // isEmpty funcao que retorna se a lista é vazia
        }).collect(Collectors.toList());

        // usando referencia: return pessoas.values().stream().filter(Pessoa::isGrupoRisco).collect(Collectors.toList());
    }

}
