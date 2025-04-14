package com.microservice.cliente.service;

import com.microservice.cliente.entities.Cliente;
import com.microservice.cliente.http.response.CuentaByClienteResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IClienteService {

    Cliente findClientById(Long id);

    void save(Cliente cliente);

    CuentaByClienteResponse findCuentaByIdCliente(Long codigoCliente);

    CuentaByClienteResponse findMovimientosPorFechas(Long codigoCliente, LocalDateTime fechaDesde, LocalDateTime fechaHasta);

}
