package com.example.grupoK;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicamentoController {

    public static class FichaMedicamento {
        private String nombre;
        private String prospecto;
        private String efectosSecundarios;
        private String interacciones;

        public FichaMedicamento(String nombre, String prospecto, String efectosSecundarios, String interacciones) {
            this.nombre = nombre;
            this.prospecto = prospecto;
            this.efectosSecundarios = efectosSecundarios;
            this.interacciones = interacciones;
        }

        public String getNombre() {
            return nombre;
        }

        public String getProspecto() {
            return prospecto;
        }

        public String getEfectosSecundarios() {
            return efectosSecundarios;
        }

        public String getInteracciones() {
            return interacciones;
        }
    }

    private List<FichaMedicamento> obtenerListaMedicamentos() {
        return List.of(
            new FichaMedicamento(
                "Enalapril 10 mg",
                "Indicado para el tratamiento de la hipertensión arterial y la insuficiencia cardíaca. Tomar 1 comprimido al día.",
                "Mareos, tos seca persistente, fatiga o hipotensión.",
                "Evitar suplementos de potasio, diuréticos ahorradores de potasio y AINEs como el ibuprofeno."
            ),
            new FichaMedicamento(
                "Adiro 100 mg",
                "Antiagregante plaquetario indicado para la prevención de eventos cardiovasculares. Tomar 1 comprimido al día tras la comida.",
                "Molestias gastrointestinales, acidez o mayor tendencia al sangrado.",
                "Precaución con anticoagulantes orales, corticoides y otros antiinflamatorios."
            ),
            new FichaMedicamento(
                "Paracetamol",
                "Analgésico y antipirético indicado para el alivio del dolor leve o moderado y estados febriles. Tomar 1 comprimido cada 8 horas si precisa.",
                "Raros a dosis terapéuticas; hepatotoxicidad en caso de sobredosis.",
                "Evitar el consumo de alcohol y otros medicamentos que contengan paracetamol."
            )
        );
    }

    @GetMapping("/medicamentos")
    public List<FichaMedicamento> listarMedicamentos() {
        return obtenerListaMedicamentos();
    }

    @GetMapping("/medicamentos/{nombre}")
    public FichaMedicamento consultarMedicamentoPorNombre(@PathVariable String nombre) {
        return obtenerListaMedicamentos().stream()
            .filter(m -> m.getNombre().toLowerCase().contains(nombre.toLowerCase()))
            .findFirst()
            .orElse(new FichaMedicamento(nombre, "Medicamento no encontrado en el sistema", "No disponible", "No disponible"));
    }
}