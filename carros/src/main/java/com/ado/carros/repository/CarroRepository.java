package com.ado.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ado.carros.model.CarroModel;

public interface CarroRepository extends JpaRepository<CarroModel, Long> {

}
