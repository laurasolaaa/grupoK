package com.example.grupoK.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad Tratamiento (requisito RF5).
 * Cada objeto se guarda como una fila de la tabla TRATAMIENTO en la base de datos H2.
 */
@Entity
public class Tratamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicamento;
    private String dosis;
    private String frecuencia;
    private String horario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int stock;

    // JPA necesita un constructor vacío
    public Tratamiento() {
    }

    public Tratamiento(String medicamento, String dosis, String frecuencia, String horario,
            LocalDate fechaInicio, LocalDate fechaFin, int stock) {
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.horario = horario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
