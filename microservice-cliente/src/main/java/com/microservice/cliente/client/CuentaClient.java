package com.microservice.cliente.client;

import com.microservice.cliente.controller.DTOs.CuentaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@FeignClient(name = "msvc-cuenta", url = "localhost:9090/api/cuentas")
public interface CuentaClient {

    @GetMapping("/search-by-cliente/{codigoCliente}")
    List<CuentaDTO> findCuentaByCliente(@PathVariable Long codigoCliente);

    @GetMapping("/reportes/{codigoCliente}")
    List<CuentaDTO> findMovimientosPorFechas(@PathVariable Long idCliente,
                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaDesde,
                                             @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDateTime fechaHasta );

}
