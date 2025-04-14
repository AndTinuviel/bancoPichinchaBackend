package com.microservice.cliente.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name="CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Persona{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODIGO_CLIENTE")
    private Long id;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ESTADO")
    private EstadoEnum estado;

}
