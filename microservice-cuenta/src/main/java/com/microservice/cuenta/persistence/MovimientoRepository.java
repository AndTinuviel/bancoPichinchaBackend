package com.microservice.cuenta.persistence;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.entities.Movimiento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimientoRepository extends CrudRepository<Movimiento, Long> {

}
