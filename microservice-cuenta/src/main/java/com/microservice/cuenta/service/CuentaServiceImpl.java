package com.microservice.cuenta.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.microservice.cuenta.entities.Cuenta;
import com.microservice.cuenta.entities.Movimiento;
import com.microservice.cuenta.persistence.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service
public class CuentaServiceImpl implements ICuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Override
    public void save(Cuenta cuenta) {
        cuentaRepository.save(cuenta);
    }

    @Override
    public Cuenta findById(Long id) {
        return cuentaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cuenta> findAll() {
        return (List<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public List<Cuenta> findByCliente(Long codigoCliente) {
        return cuentaRepository.findByCliente(codigoCliente);
    }


    public List<Cuenta> findMovimientosPorFechas(Long clienteId, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        List<Cuenta> cuentas = cuentaRepository.findByCliente(clienteId);
        for (Cuenta cuenta : cuentas) {
            List<Movimiento> movimientos = cuentaRepository.findMovimientosPorFechas(cuenta.getId(), fechaDesde, fechaHasta);
            cuenta.setListaMovimientos(movimientos); // Asegúrate de tener un setter en Cuenta o usa un DTO
        }
        return cuentas;
    }

    @Override
    public String findMovementsByDates(Long clienteId, LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        List<Cuenta> cuentas = findMovimientosPorFechas(clienteId, fechaDesde, fechaHasta);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Reporte de Movimientos"));
            document.add(new Paragraph("Cliente ID: " + clienteId));
            document.add(new Paragraph("Fecha Desde: " + fechaDesde.toString()));
            document.add(new Paragraph("Fecha Hasta: " + fechaHasta.toString()));
            document.add(new Paragraph(" "));

            for (Cuenta cuenta : cuentas) {
                document.add(new Paragraph("Cuenta: " + cuenta.getNumeroCuenta()));
                document.add(new Paragraph("Saldo: " + cuenta.getSaldoActual()));
                document.add(new Paragraph("Tipo: " + cuenta.getTipoCuenta()));
                document.add(new Paragraph("Movimientos: "));

                for (Movimiento mov : cuenta.getListaMovimientos()) {
                    document.add(new Paragraph("  - " + mov.getFecha() + " | " + mov.getTipoMovimientoEnum() + " | $" + mov.getValor()));
                }
                document.add(new Paragraph(" "));
            }

            document.close();
            String base64Pdf = Base64.getEncoder().encodeToString(baos.toByteArray());
            return base64Pdf;

        } catch (Exception e) {
            e.printStackTrace();
            return "Error generando PDF";
        }
    }

}
