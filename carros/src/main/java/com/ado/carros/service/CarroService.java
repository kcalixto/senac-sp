package com.ado.carros.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ado.carros.dto.CarroDTO;
import com.ado.carros.model.CarroModel;
import com.ado.carros.repository.CarroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public Optional<List<CarroDTO>> listCarros() {
        List<CarroModel> carros = carroRepository.findAll();

        ArrayList<CarroDTO> list = new ArrayList<>();
        for (CarroModel carroModel : carros) {
            list.add(new CarroDTO(carroModel.getId(), carroModel.getModelo(), carroModel.getFabricante(),
                    carroModel.getAnoLancamento()));
        }

        return Optional.ofNullable(list);
    }

    public CarroDTO getCarro(Long id) {
        CarroModel model = carroRepository.findById(id).orElse(null);
        if (model == null) {
            throw new IllegalArgumentException("Carro não encontrado!");
        }

        CarroDTO dto = new CarroDTO(model.getId(), model.getModelo(), model.getFabricante(), model.getAnoLancamento());
        return dto;
    }

    public CarroDTO save(CarroDTO carro) {
        if (carro == null) {
            throw new IllegalArgumentException("Não foi possível salvar as informações do carro!");
        }

        CarroModel carroModel = new CarroModel(carro.getModelo(), carro.getFabricante(), carro.getAnoLancamento());
        carroModel = carroRepository.save(carroModel);

        return new CarroDTO(carroModel.getId(), carroModel.getModelo(), carroModel.getFabricante(),
                carroModel.getAnoLancamento());
    }

}
