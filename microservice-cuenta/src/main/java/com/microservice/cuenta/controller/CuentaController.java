package com.microservice.cuenta.controller;

import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCuenta(@RequestBody Cuenta cuenta){
        cuentaService.save(cuenta);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(cuentaService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCuentas(){
        return ResponseEntity.ok(cuentaService.findAll());
    }

    @GetMapping("/search-by-cliente/{codigoCliente}")
    public ResponseEntity<?> findCuentaByCliente(@PathVariable  Long codigoCliente){
        return ResponseEntity.ok(cuentaService.findByCliente(codigoCliente));
    }

    @GetMapping("/reportes/{codigoCliente}")
    public ResponseEntity<?> findMovimientosPorFechas(@PathVariable  Long codigoCliente,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaDesde,
                                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaHasta) {
        return ResponseEntity.ok(cuentaService.findMovimientosPorFechas(codigoCliente, fechaDesde, fechaHasta));
    }

}
