package com.example.grupoK;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HistorialController {

    @GetMapping("/historial")
    public Map<String, Object> consultarHistorial() {
        return Map.of(
            "paciente", "Juan Pérez",
            "resumen", Map.of(
                "confirmadas", 12,
                "omitidas", 1,
                "retrasadas", 2
            ),
            "detalleTomas", List.of(
                Map.of("medicamento", "Sintrom 4mg", "horaProgramada", "09:00", "estado", "CONFIRMADA"),
                Map.of("medicamento", "Omeprazol 20mg", "horaProgramada", "14:00", "estado", "RETRASADA"),
                Map.of("medicamento", "Atorvastatina 10mg", "horaProgramada", "21:00", "estado", "OMITIDA")
            )
        );
    }
}
