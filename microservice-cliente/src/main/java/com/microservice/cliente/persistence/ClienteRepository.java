package com.microservice.cliente.persistence;

import com.microservice.cliente.entities.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("select c from Cliente c where c.id= :id")
    Cliente findClientById(Long id);

}
