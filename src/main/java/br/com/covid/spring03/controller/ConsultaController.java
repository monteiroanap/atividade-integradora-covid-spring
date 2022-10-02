package br.com.covid.spring03.controller;

import br.com.covid.spring03.dtos.GrupoRiscoDTO;
import br.com.covid.spring03.modelo.Pessoa;
import br.com.covid.spring03.modelo.Sintomas;
import br.com.covid.spring03.services.GerenciaPessoas;
import br.com.covid.spring03.services.GerenciaSintomas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired // anotacao para ingecao de dependencias
    private GerenciaSintomas gerenciaSintomas;
    @Autowired
    private GerenciaPessoas gerenciaPessoas;

    @GetMapping ("/findSymptom")
    public ResponseEntity<List<Sintomas>> mostrarSintomas(){ // lista se sintomas dentro de responseEntity
        List<Sintomas> sintomas = gerenciaSintomas.consultarSintomas(); // criado uma lista de sintomas
        return new ResponseEntity<>(sintomas, HttpStatus.OK);
    }
    @GetMapping ("/findSymptom/{nome}")
    public ResponseEntity<String> buscarSintomas(@PathVariable String nome){
        Sintomas sintoma = gerenciaSintomas.buscaSintomasNome(nome); // busca sintoma pelo nome
        if(sintoma != null){
            return new ResponseEntity<>(sintoma.getNivelGravidade().toString(), HttpStatus.OK);
        }
        return new ResponseEntity<>("sintomas not Found", HttpStatus.NO_CONTENT);
    }
    @GetMapping("/findRiskPerson")
    public ResponseEntity<List<GrupoRiscoDTO>> consutarGrupoRisco(){
        // referenciaList<GrupoRiscoDTO> gruposRisco = gerenciaPessoas.consultarPessoaRisco().stream().map(GrupoRiscoDTO::new).collect(Collectors.toList());
       List<GrupoRiscoDTO> gruposRisco = gerenciaPessoas.consultarPessoaRisco().stream().map(p -> new GrupoRiscoDTO(p)).collect(Collectors.toList());
        return new ResponseEntity<>(gruposRisco, HttpStatus.OK);

    }



}

