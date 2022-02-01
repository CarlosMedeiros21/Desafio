package com.carloscaique.projeto.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController //  Retorna o objeto e os dados do objeto
@RequestMapping(value = "/clientes") //
public class ClienteResource {

    @RequestMapping(method = RequestMethod.GET) //
    public String listar(){
        return "Rest esta funcionando";
    }

}
