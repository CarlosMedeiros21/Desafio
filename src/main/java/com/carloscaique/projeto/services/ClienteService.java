package com.carloscaique.projeto.services;

import java.util.Optional;

import com.carloscaique.projeto.domain.Cliente;
import com.carloscaique.projeto.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id) {
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElse(null);
    }
}