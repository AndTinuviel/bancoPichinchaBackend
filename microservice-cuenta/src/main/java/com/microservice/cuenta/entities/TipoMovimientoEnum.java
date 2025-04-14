package com.microservice.cuenta.entities;

public enum TipoMovimientoEnum {

    RET("Retiro"),
    DEP("Deposito");

    private String valor;

    TipoMovimientoEnum(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
