package com.carloscaique.projeto.services;

import java.util.Optional;

import com.carloscaique.projeto.domain.Cliente;
import com.carloscaique.projeto.repositories.ClienteRepository;
import com.carloscaique.projeto.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    public Cliente insert(Cliente obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Cliente update(Cliente obj){
        find(obj.getId());   // busca o objeto no banco para saber se tem um ID válido
        return repo.save(obj);
    }
}