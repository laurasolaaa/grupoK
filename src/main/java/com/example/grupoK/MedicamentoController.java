package com.example.grupoK;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/medicamentos")
    public FichaMedicamento[] obtenerMedicamentos() {
        FichaMedicamento med1 = new FichaMedicamento(
            "Enalapril 10 mg",
            "Indicado para el tratamiento de la hipertensión arterial y la insuficiencia cardíaca.",
            "Mareos al levantarse, tos seca persistente y fatiga leve.",
            "Evitar suplementos de potasio y antiinflamatorios como el ibuprofeno."
        );

        FichaMedicamento med2 = new FichaMedicamento(
            "Adiro 100 mg",
            "Antiagregante plaquetario utilizado para prevenir la formación de coágulos sanguíneos.",
            "Acidez estomacal o molestias digestivas leves; tomar tras las comidas.",
            "Aumenta el riesgo de sangrado si se combina con anticoagulantes como Sintrom."
        );

        return new FichaMedicamento[] { med1, med2 };
    }
}
