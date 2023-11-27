package com.ado.carros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.ado.carros.dto.CarroDTO;
import com.ado.carros.service.CarroService;

import jakarta.validation.Valid;

@Controller
public class CarroController {

    @Autowired
    private CarroService service;

    @GetMapping("")
    public String paginaInicial() {
        return "index";
    }

    @GetMapping("/carros/cadastro")
    public String paginaCadastroCarro(Model model) {
        model.addAttribute("carro", new CarroDTO());
        return "cadastro";
    }

    @GetMapping("/carros")
    public String listCarros(Model model) {
        Optional<List<CarroDTO>> carros = service.listCarros();
        model.addAttribute("carros", carros.orElse(null));
        return "carros";
    }

    @GetMapping("/carros/{id}")
    public String getCarro(@PathVariable Long id, Model model) {
        CarroDTO carro = service.getCarro(id);
        model.addAttribute("carro", carro);

        return "carro";
    }

    @PostMapping("/carros/cadastro")
    public String save(@Valid @ModelAttribute("carro") CarroDTO carro, RedirectAttributes redirectAttributes,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "cadastro";
        }

        service.save(carro);
        redirectAttributes.addFlashAttribute("msg", "Carro salvo com sucesso!");

        return "redirect:/carros";
    }

}
