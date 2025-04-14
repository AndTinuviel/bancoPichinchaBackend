package com.microservice.cuenta.service;

import com.microservice.cuenta.entities.Movimiento;

import java.util.List;

public interface IMovimientoService {

    void save (Movimiento movimiento);

    Movimiento findById(Long id);

    List<Movimiento> findAll();

    void delete(Long codigoMovimiento);

}
