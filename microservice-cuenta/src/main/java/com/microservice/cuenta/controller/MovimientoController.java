package com.microservice.cuenta.controller;

import com.microservice.cuenta.entities.Movimiento;
import com.microservice.cuenta.service.IMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private IMovimientoService movimientoService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveMovimiento(@RequestBody Movimiento movimiento){
        movimientoService.save(movimiento);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(movimientoService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCuentas(){
        return ResponseEntity.ok(movimientoService.findAll());
    }

    @DeleteMapping("/delete/{codigoMovimiento}")
    public ResponseEntity<?> deleteItem(@PathVariable Long codigoMovimiento){
        movimientoService.delete(codigoMovimiento);
        return ResponseEntity.ok().build();
    }

}
