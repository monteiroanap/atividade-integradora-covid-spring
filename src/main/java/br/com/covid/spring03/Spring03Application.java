package br.com.covid.spring03;

import br.com.covid.spring03.modelo.Pessoa;
import br.com.covid.spring03.modelo.Sintomas;
import br.com.covid.spring03.services.GerenciaPessoas;
import br.com.covid.spring03.services.GerenciaSintomas;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Spring03Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring03Application.class, args);
	}
	//metodo apenas para exemplo para carregar o banco no inicio do desenvolvimento
	@Bean
	//anotacao que diz que o spring gerencia todo o ciclo de vida
	CommandLineRunner initDatabase(GerenciaPessoas gerenciaPessoas, GerenciaSintomas gerenciaSintomas) { //metodo que sera executado assim que o projeto for inicializado
		return args -> {
			gerenciaSintomas.inserirSintoma(new Sintomas("febre", 2));
			gerenciaSintomas.inserirSintoma(new Sintomas("dor de cabeca", 5));
			gerenciaSintomas.inserirSintoma(new Sintomas("dor nos olhos", 7));

			gerenciaPessoas.inserirPessoa(new Pessoa("maria", "teste spring", 30, Arrays.asList(gerenciaSintomas.consultarSintoma(1))));
			gerenciaPessoas.inserirPessoa(new Pessoa("jose", "teste spring2", 58, Arrays.asList(gerenciaSintomas.consultarSintoma(2))));
			gerenciaPessoas.inserirPessoa(new Pessoa("joao", "teste spring3", 26, Arrays.asList(gerenciaSintomas.consultarSintoma(3))));
			gerenciaPessoas.inserirPessoa(new Pessoa("ana", "teste spring4", 63, Arrays.asList(gerenciaSintomas.consultarSintoma(1))));
			gerenciaPessoas.inserirPessoa(new Pessoa("pedro", "teste spring5", 79, Arrays.asList(gerenciaSintomas.consultarSintoma(3))));
			gerenciaPessoas.inserirPessoa(new Pessoa("lucas", "teste spring6", 66, Arrays.asList(gerenciaSintomas.consultarSintoma(2))));
			gerenciaPessoas.inserirPessoa(new Pessoa("lulu", "teste spring7", 60, Arrays.asList(gerenciaSintomas.consultarSintoma(3))));
			gerenciaPessoas.inserirPessoa(new Pessoa("pedro", "teste spring8", 64, Arrays.asList(gerenciaSintomas.consultarSintoma(1))));
		};
}


}

