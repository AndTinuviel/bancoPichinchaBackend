package com.microservice.cliente.controller;

import com.microservice.cliente.entities.Cliente;
import com.microservice.cliente.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCliente(@RequestBody Cliente cliente){
        clienteService.save(cliente);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.findClientById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllClientes(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/search-cuentas/{idCliente}")
    public ResponseEntity<?> findCuentasByIdCliente(@PathVariable Long idCliente){
        return ResponseEntity.ok(clienteService.findCuentaByIdCliente(idCliente));
    }

    @GetMapping("/reportes/{idCliente}")
    public ResponseEntity<?> findMovimientosPorFechas(@PathVariable Long idCliente,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaDesde,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaHasta) {
        return ResponseEntity.ok(clienteService.findMovimientosPorFechas(idCliente,fechaDesde,fechaHasta ));
    }

}
