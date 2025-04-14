package com.microservice.cuenta.controller.dto;

import com.microservice.cuenta.controller.DTOs.ClienteDTO;
import com.microservice.cuenta.controller.EstadoEnum;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteDTOTest {

    @Test
    public void testDefaultConstructor() {
        ClienteDTO clienteDTO = new ClienteDTO();
        assertNull(clienteDTO.getPassword());
        assertNull(clienteDTO.getEstado());
        assertNull(clienteDTO.getNombre());
        assertNull(clienteDTO.getGenero());
        assertNull(clienteDTO.getEdad());
        assertNull(clienteDTO.getIdentificacion());
        assertNull(clienteDTO.getDireccion());
        assertNull(clienteDTO.getTelefono());
    }

    @Test
    public void testAllArgsConstructor() {
        EstadoEnum estado = EstadoEnum.ACT;
        ClienteDTO clienteDTO = new ClienteDTO("pass123", estado, "Juan Pérez", "Masculino", 30L, "1234567890", "Calle Falsa 123", "555-1234");

        assertEquals("pass123", clienteDTO.getPassword());
        assertEquals(estado, clienteDTO.getEstado());
        assertEquals("Juan Pérez", clienteDTO.getNombre());
        assertEquals("Masculino", clienteDTO.getGenero());
        assertEquals(30L, clienteDTO.getEdad());
        assertEquals("1234567890", clienteDTO.getIdentificacion());
        assertEquals("Calle Falsa 123", clienteDTO.getDireccion());
        assertEquals("555-1234", clienteDTO.getTelefono());
    }

    @Test
    public void testBuilder() {
        ClienteDTO clienteDTO = ClienteDTO.builder()
                .password("pass123")
                .estado(EstadoEnum.ACT)
                .nombre("Juan Pérez")
                .genero("Masculino")
                .edad(30L)
                .identificacion("1234567890")
                .direccion("Calle Falsa 123")
                .telefono("555-1234")
                .build();

        assertEquals("pass123", clienteDTO.getPassword());
        assertEquals(EstadoEnum.ACT, clienteDTO.getEstado());
        assertEquals("Juan Pérez", clienteDTO.getNombre());
        assertEquals("Masculino", clienteDTO.getGenero());
        assertEquals(30L, clienteDTO.getEdad());
        assertEquals("1234567890", clienteDTO.getIdentificacion());
        assertEquals("Calle Falsa 123", clienteDTO.getDireccion());
        assertEquals("555-1234", clienteDTO.getTelefono());
    }

    @Test
    public void testToString() {
        EstadoEnum estado = EstadoEnum.ACT;
        ClienteDTO clienteDTO = new ClienteDTO("pass123", estado, "Juan Pérez", "Masculino", 30L, "1234567890", "Calle Falsa 123", "555-1234");

        String expected = "ClienteDTO(password=pass123, estado=ACT, nombre=Juan Pérez, genero=Masculino, edad=30, identificacion=1234567890, direccion=Calle Falsa 123, telefono=555-1234)";
        assertEquals(expected, clienteDTO.toString());
    }

    @Test
    public void testEqualsAndHashCode() {
        ClienteDTO cliente1 = new ClienteDTO("pass123", EstadoEnum.ACT, "Juan Pérez", "Masculino", 30L, "1234567890", "Calle Falsa 123", "555-1234");
        ClienteDTO cliente2 = new ClienteDTO("pass123", EstadoEnum.ACT, "Juan Pérez", "Masculino", 30L, "1234567890", "Calle Falsa 123", "555-1234");
        ClienteDTO cliente3 = new ClienteDTO("pass456", EstadoEnum.INA, "Ana García", "Femenino", 25L, "0987654321", "Avenida Siempre Viva 742", "555-5678");

        assertEquals(cliente1, cliente2);
        assertNotEquals(cliente1, cliente3);
        assertEquals(cliente1.hashCode(), cliente2.hashCode());
    }
}
