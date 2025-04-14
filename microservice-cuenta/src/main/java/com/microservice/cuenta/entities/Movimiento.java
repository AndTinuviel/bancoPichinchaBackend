package com.microservice.cuenta.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name="MOVIMIENTO")
@AllArgsConstructor
@NoArgsConstructor
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_MOVIMIENTO")
    private Long id;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "TIPO_MOVIMIENTO")
    private TipoMovimientoEnum tipoMovimientoEnum;

    @Column(name = "VALOR")
    private Float valor;

    @Column(name = "SALDO")
    private Float saldo;

    @ManyToOne
    @JoinColumn(name = "CODIGO_CUENTA")
    @JsonBackReference
    private Cuenta cuenta;


}
