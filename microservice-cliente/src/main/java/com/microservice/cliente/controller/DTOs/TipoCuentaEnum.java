package com.microservice.cliente.controller.DTOs;

public enum TipoCuentaEnum {

    AHO ("Ahorro"),
    COR ("Corriente");

    private String valor;

    TipoCuentaEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
