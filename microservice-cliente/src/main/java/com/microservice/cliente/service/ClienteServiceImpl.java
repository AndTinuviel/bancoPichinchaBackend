package com.microservice.cliente.service;

import com.microservice.cliente.client.CuentaClient;
import com.microservice.cliente.controller.DTOs.CuentaDTO;
import com.microservice.cliente.entities.Cliente;
import com.microservice.cliente.http.response.CuentaByClienteResponse;
import com.microservice.cliente.persistence.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CuentaClient cuentaClient;

    @Override
    public Cliente findClientById(Long id) {
        return clienteRepository.findClientById(id);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public CuentaByClienteResponse findCuentaByIdCliente(Long codigoCliente) {
        //Consultar el cliente
        Cliente cliente =  clienteRepository.findById(codigoCliente).orElse(new Cliente());

        //Obtener las cuentas
        List<CuentaDTO> listaCuentas = cuentaClient.findCuentaByCliente(codigoCliente);

        return CuentaByClienteResponse.builder().nombreCliente(cliente.getNombre()).listaCuentas(listaCuentas).build();
    }

    @Override
    public CuentaByClienteResponse findMovimientosPorFechas(Long codigoCliente, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        //Consultar el cliente
        Cliente cliente =  clienteRepository.findById(codigoCliente).orElse(new Cliente());

        //Obtener las cuentas
        List<CuentaDTO> listaCuentas = cuentaClient.findMovimientosPorFechas(codigoCliente,fechaDesde, fechaHasta);

        return CuentaByClienteResponse.builder().nombreCliente(cliente.getNombre()).listaCuentas(listaCuentas).build();
    }
}
