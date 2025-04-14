package com.microservice.cuenta.service;

import com.microservice.cuenta.entities.Cuenta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ICuentaService {

    void save(Cuenta cuenta);

    Cuenta findById(Long id);

    List<Cuenta> findAll();

    List<Cuenta> findByCliente(Long codigoCliente);

    List<Cuenta> findMovimientosPorFechas(Long clienteId, LocalDateTime fechaDesde, LocalDateTime fechaHasta) ;

}
