package com.microservice.cliente.service;

import com.microservice.cliente.entities.Cliente;
import com.microservice.cliente.http.response.CuentaByClienteResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface IClienteService {

    Cliente findClientById(Long id);

    void save(Cliente cliente);

    List<Cliente> findAll();

    CuentaByClienteResponse findCuentaByIdCliente(Long codigoCliente);

    CuentaByClienteResponse findMovimientosPorFechas(Long codigoCliente, LocalDateTime fechaDesde, LocalDateTime fechaHasta);

}
