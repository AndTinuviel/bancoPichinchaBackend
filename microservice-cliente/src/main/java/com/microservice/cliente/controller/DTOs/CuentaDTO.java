package com.microservice.cliente.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {




    private String numeroCuenta;
    private TipoCuentaEnum tipoCuenta;
    private Float saldoInicial;
    private Float saldoActual;
    private EstadoEnum estado;
    private List<MovimientoDTO> listaMovimientos;

    private Long cliente;
}
