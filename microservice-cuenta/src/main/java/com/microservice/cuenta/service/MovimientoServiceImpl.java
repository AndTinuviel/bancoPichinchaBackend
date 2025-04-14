package com.microservice.cuenta.service;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.entities.Movimiento;
import com.microservice.cuenta.persistence.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoServiceImpl implements IMovimientoService{

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Override
    public void save(Movimiento movimiento) {
        movimientoRepository.save(movimiento);
    }

    @Override
    public Movimiento findById(Long id) {
        return movimientoRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movimiento> findAll() {
        return (List<Movimiento>) movimientoRepository.findAll();
    }

    @Override
    public void delete(Long codigoMovimiento) {
        Optional<Movimiento> movimientoOptional= movimientoRepository.findById(codigoMovimiento);
        Movimiento movimiento = movimientoOptional.get();
        movimientoRepository.delete(movimiento);
    }
}
