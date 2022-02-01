package com.carloscaique.projeto.resources;

import com.carloscaique.projeto.domain.Cliente;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController //  Retorna o objeto e os dados do objeto
@RequestMapping(value = "/clientes") //
public class ClienteResource {

    @RequestMapping(method = RequestMethod.GET) //
    public List<Cliente> listar(){

        Cliente cli1 = new Cliente(1, "Carlos Caique", "47125874126", "959874597", "caique@hotmail.com");
        Cliente cli2 = new Cliente(2, "Caio Vinicius", "12345678965", "958745214", "caio@hotmail.com");
        Cliente cli3 = new Cliente(3, "Jordane Medel", "98765432198", "921212525", "Jordane@hotmail.com");

        List<Cliente> lista = new ArrayList<>();
        lista.add(cli1);
        lista.add(cli2);
        lista.add(cli3);

        return lista;
    }

}
