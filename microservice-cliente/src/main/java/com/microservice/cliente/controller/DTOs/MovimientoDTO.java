package com.microservice.cliente.controller.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovimientoDTO {

    private LocalDateTime fecha;
    private TipoMovimientoEnum tipoMovimientoEnum;
    private Float valor;
    private Float saldo;
//    private Cuenta cuenta;

}
