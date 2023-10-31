package com.ado;

/**
 * https://github.com/kcalixto/senac-sp/tree/4na-2303-ds-ado-03
 */

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @GetMapping("/lista")
    public List<Carro> listar() throws InterruptedException {
        // ADO 3 - Pequeno sleep para testar tag p de 'carregando...'
        Long sec_2 = 2000L;
        Thread.sleep(sec_2);
        //

        List<Carro> lista = new ArrayList<>();
        lista.add(new Carro("Corolla", "Toyota", 1998));
        lista.add(new Carro("Gol", "VW", 1980));
        lista.add(new Carro("HB20", "Hyundai", 2012));
        return lista;
    }
}
