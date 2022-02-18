package com.carloscaique.projeto.repositories;

import com.carloscaique.projeto.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = ?1")
    Optional<Cliente> findByCpf(String cpf);
}