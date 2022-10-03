package br.com.covid.spring03.services;

import br.com.covid.spring03.exceptions.NomeSintomaNaoEncontradoException;
import br.com.covid.spring03.modelo.Sintomas;
import br.com.covid.spring03.util.NumberGenerator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// esse package servicos é usado como uma ponte para os endpoints
//aqui é descrito os metodos, buscar, deeltar, atualizar, e inserir.
@Service
public class GerenciaSintomas {
    private Map<Integer, Sintomas> sintomas;

    public GerenciaSintomas() {
        this.sintomas = new HashMap<>();


    }
    public void inserirSintoma(Sintomas sintoma){
        sintoma.setCodigo(NumberGenerator.getInstance().proximoSintoma());
        sintomas.put(sintoma.getCodigo(), sintoma); // add um novo sintoma na lista sintomas
    }
    public List<Sintomas> consultarSintomas(){
        return sintomas.values().stream().collect(Collectors.toList()); // converter o values para uma lista
    }
    public Sintomas buscaSintomasNome(String nome) throws NomeSintomaNaoEncontradoException {
        return sintomas.values().stream().filter(s -> s.getNome().equalsIgnoreCase(nome)).findFirst().orElseThrow (() -> new NomeSintomaNaoEncontradoException("esse sintoma não existe"));

        // pegando map de sintomas, retonando so o valor e esse valor é tranformado em uma Stream e filtra essa stream pelo nome do sintoma,
        // depois de filtrado a lista, pega o primeiro sintoma da lista, e caso não é tenha nada na lista nao é retonando
        //o objeto  sintoma
    }
    public Sintomas consultarSintoma(int id){
        return sintomas.get(id);
    }

}
