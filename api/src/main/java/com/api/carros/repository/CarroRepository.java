package com.api.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.carros.model.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {

}
