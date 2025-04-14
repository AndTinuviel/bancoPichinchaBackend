package com.microservice.cuenta.service;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.entities.Movimiento;
import com.microservice.cuenta.persistence.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public List<Cuenta> findByCliente(Long codigoCliente) {
        return cuentaRepository.findByCliente(codigoCliente);
    }


    public List<Cuenta> findMovimientosPorFechas(Long clienteId, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        List<Cuenta> cuentas = cuentaRepository.findByCliente(clienteId);
        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = cuentaRepository.findMovimientosPorFechas(cuenta.getId(), fechaDesde, fechaHasta);
            cuenta.setListaMovimientos(movimientos); // Asegúrate de tener un setter en Cuenta o usa un DTO
        }
        return cuentas;
    }

}
