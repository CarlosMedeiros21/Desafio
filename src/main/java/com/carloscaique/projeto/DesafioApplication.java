package com.carloscaique.projeto;

import com.carloscaique.projeto.domain.Cliente;
import com.carloscaique.projeto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DesafioApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente cli1 = new Cliente(null, "Carlos Caique" , "47125836978" , "932165498", "carlos@hotmail.com");
		Cliente cli2 = new Cliente(null, "Caio Lima" , "14725836998" , "223696369", "caio@hotmail.com");
		Cliente cli3 = new Cliente(null, "Joao Alves" , "74185236985" , "114741478", "joao@hotmail.com");

		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3));


	}
}
