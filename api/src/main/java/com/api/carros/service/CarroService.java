package com.api.carros.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.carros.dto.CarroDTO;
import com.api.carros.model.CarroModel;
import com.api.carros.repository.CarroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarroService {
    @Autowired
    private CarroRepository carroRepository;

    public List<CarroDTO> listCarros() {
        List<CarroModel> carros = carroRepository.findAll();

        ArrayList<CarroDTO> list = new ArrayList<>();
        for (CarroModel carroModel : carros) {
            list.add(new CarroDTO(carroModel.getId(), carroModel.getModelo(), carroModel.getFabricante(),
                    carroModel.getAnoLancamento()));
        }

        return list;
    }

    public Optional<CarroDTO> getCarro(Long id) {
        CarroModel model = carroRepository.findById(id).orElse(null);
        if (model == null) {
            return Optional.empty();
        }

        CarroDTO dto = new CarroDTO(model.getId(), model.getModelo(), model.getFabricante(), model.getAnoLancamento());
        return Optional.of(dto);
    }

    public CarroDTO save(CarroDTO carro) {
        CarroModel carroModel = new CarroModel(carro.getModelo(), carro.getFabricante(), carro.getAnoLancamento());
        carroModel = carroRepository.save(carroModel);

        return new CarroDTO(carroModel.getId(), carroModel.getModelo(), carroModel.getFabricante(),
                carroModel.getAnoLancamento());
    }

}
