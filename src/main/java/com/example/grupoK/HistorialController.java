package com.example.grupoK;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistorialController {

    private final List detalleTomas = List.of(
        Map.of("medicamento", "Sintrom 4mg", "horaProgramada", "09:00", "estado", "CONFIRMADA"),
        Map.of("medicamento", "Omeprazol 20mg", "horaProgramada", "14:00", "estado", "RETRASADA"),
        Map.of("medicamento", "Atorvastatina 10mg", "horaProgramada", "21:00", "estado", "OMITIDA")
    );

    @GetMapping("/historial")
    public Map consultarHistorial() {
        return Map.of(
            "paciente", "Juan Pérez",
            "resumen", Map.of(
                "confirmadas", 12,
                "omitidas", 1,
                "retrasadas", 2
            ),
            "detalleTomas", detalleTomas
        );
    }

    @GetMapping("/historial/{estado}")
    public List consultarHistorialPorEstado(@PathVariable String estado) {
        List filtradas = new ArrayList();
        for (Object item : detalleTomas) {
            Map toma = (Map) item;
            if (estado.equalsIgnoreCase((String) toma.get("estado"))) {
                filtradas.add(toma);
            }
        }
        return filtradas;
    }
}
