package com.carloscaique.projeto.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.carloscaique.projeto.domain.Cliente;
import com.carloscaique.projeto.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {
        @Autowired
        private ClienteService service;

        @RequestMapping(value="/{id}", method=RequestMethod.GET)
        public ResponseEntity<?> find(@PathVariable Integer id) {
            Cliente obj = service.find(id);
            return ResponseEntity.ok().body(obj);
        }

    @RequestMapping(value="/{cpf}/by_cpf", method=RequestMethod.GET)
    public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
        Cliente obj = service.findByCpf(cpf);
        return ResponseEntity.ok().body(obj);
    }

        @RequestMapping(method = RequestMethod.POST) // Metodo de Criação
        public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
            obj = service.insert(obj);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").buildAndExpand(obj.getId()).toUri();

            return ResponseEntity.created(uri).build();
        }

        @RequestMapping(value="/{id}", method=RequestMethod.PUT) // Atualizando Dados do Cliente
        public ResponseEntity<Void> update(@RequestBody Cliente obj, @PathVariable Integer id){
            obj.setId(id);
            obj = service.update(obj);
            return ResponseEntity.noContent().build();
        }

        @RequestMapping(value="/{id}", method=RequestMethod.DELETE) // Deletando Cliente
        public ResponseEntity<Void> delete(@PathVariable Integer id) {
                service.delete(id);
                return ResponseEntity.noContent().build();
        }

        @RequestMapping(method=RequestMethod.GET) // lista de Cliente
        public ResponseEntity<List<Cliente>> findAll() {
            List<Cliente> list = service.findAll();
            return ResponseEntity.ok().body(list);
        }

}