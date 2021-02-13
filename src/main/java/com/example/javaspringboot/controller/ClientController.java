package com.example.javaspringboot.controller;

import com.example.javaspringboot.model.ClientModel;
import com.example.javaspringboot.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired // injeta essa implementação (tipo clientRespo) em tempo de execução.
    private ClientRepository clientRepository;

    @GetMapping(path = "/api/list")
    public List<ClientModel> getClientList() {
        return clientRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientModel addClient(@RequestBody ClientModel client) {
        return clientRepository.save(client);
    }

    @DeleteMapping(path = "/api/delete/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

}
