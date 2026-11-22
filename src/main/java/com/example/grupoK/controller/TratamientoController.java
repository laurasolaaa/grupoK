package com.example.grupoK.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TratamientoController {

    public record Tratamiento(
            int id,
            String medicamento,
            String dosis,
            String frecuencia,
            String horario,
            String fechaInicio,
            String fechaFin,
            int stock) {}

    private final List<Tratamiento> tratamientos = List.of(
            new Tratamiento(1, "Omeprazol", "20 mg", "1 vez al dia", "08:00",
                    "2026-11-01", "2026-12-01", 25),
            new Tratamiento(2, "Paracetamol", "1 g", "Cada 8 horas", "08:00, 16:00, 00:00",
                    "2026-11-15", "2026-11-25", 12),
            new Tratamiento(3, "Enalapril", "10 mg", "2 veces al dia", "09:00, 21:00",
                    "2026-10-01", "2027-10-01", 4)
    );

    @GetMapping("/tratamientos")
    public List<Tratamiento> listarTratamientos() {
        return tratamientos;
    }

    @GetMapping("/tratamientos/{id}")
    public Tratamiento obtenerTratamiento(@PathVariable int id) {
        return tratamientos.stream()
                .filter(t -> t.id() == id)
                .findFirst()
                .orElse(null);
    }
}