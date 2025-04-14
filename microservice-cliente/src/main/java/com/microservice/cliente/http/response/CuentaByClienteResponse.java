package com.microservice.cliente.http.response;

import com.microservice.cliente.controller.DTOs.CuentaDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaByClienteResponse {

    private String nombreCliente;
    private List<CuentaDTO> listaCuentas;
}
