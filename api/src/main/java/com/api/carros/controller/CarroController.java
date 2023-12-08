package com.api.carros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.carros.dto.CarroDTO;
import com.api.carros.service.CarroService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping("")
    @CrossOrigin(origins = "*")
    public List<CarroDTO> listCarros() {
        return service.listCarros();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "*")
    public Optional<CarroDTO> getCarro(@PathVariable Long id) {
        Optional<CarroDTO> carro = service.getCarro(id);
        if (carro.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Carro não encontrado!");
        }

        return carro;
    }

    @PostMapping("/cadastro")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> save(@RequestBody @Valid CarroDTO carro) {
        try {
            service.save(carro);
            return new ResponseEntity<>("Carro cadastrado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Não foi possível cadastrar o carro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
