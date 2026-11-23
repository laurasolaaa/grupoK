package com.example.grupoK.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.grupoK.model.Tratamiento;
import com.example.grupoK.repository.TratamientoRepository;

/**
 * Servicio de Tratamiento: capa intermedia entre el controlador y el repositorio.
 * Aquí está la lógica de negocio (validaciones) antes de guardar en la base de datos.
 */
@Service
public class TratamientoService {

    private final TratamientoRepository repositorio;

    public TratamientoService(TratamientoRepository repositorio) {
        this.repositorio = repositorio;
    }

    // LEER: todos los tratamientos
    public List<Tratamiento> obtenerTodos() {
        return repositorio.findAll();
    }

    // LEER: un tratamiento por su id
    public Tratamiento obtenerPorId(Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe ningún tratamiento con id " + id));
    }

    // CREAR
    public Tratamiento crear(Tratamiento tratamiento) {
        validar(tratamiento);
        tratamiento.setId(null); // el id lo genera la base de datos
        return repositorio.save(tratamiento);
    }

    // ACTUALIZAR
    public Tratamiento actualizar(Long id, Tratamiento datos) {
        Tratamiento existente = obtenerPorId(id);
        validar(datos);
        existente.setMedicamento(datos.getMedicamento());
        existente.setDosis(datos.getDosis());
        existente.setFrecuencia(datos.getFrecuencia());
        existente.setHorario(datos.getHorario());
        existente.setFechaInicio(datos.getFechaInicio());
        existente.setFechaFin(datos.getFechaFin());
        existente.setStock(datos.getStock());
        return repositorio.save(existente);
    }

    // BORRAR
    public void borrar(Long id) {
        if (!repositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No existe ningún tratamiento con id " + id);
        }
        repositorio.deleteById(id);
    }

    // Lógica de negocio: reglas que debe cumplir un tratamiento
    private void validar(Tratamiento t) {
        if (t.getMedicamento() == null || t.getMedicamento().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El medicamento es obligatorio");
        }
        if (t.getDosis() == null || t.getDosis().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La dosis es obligatoria");
        }
        if (t.getStock() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El stock no puede ser negativo");
        }
        if (t.getFechaInicio() != null && t.getFechaFin() != null
                && t.getFechaFin().isBefore(t.getFechaInicio())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "La fecha de fin no puede ser anterior a la fecha de inicio");
        }
    }
}
