package com.example.grupoK.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.grupoK.model.Tratamiento;
import com.example.grupoK.service.TratamientoService;

/**
 * Controlador REST con el CRUD completo de Tratamiento.
 *
 *   GET    /tratamientos       -> leer todos
 *   GET    /tratamientos/{id}  -> leer uno
 *   POST   /tratamientos       -> crear
 *   PUT    /tratamientos/{id}  -> actualizar
 *   DELETE /tratamientos/{id}  -> borrar
 */
@RestController
@RequestMapping("/tratamientos")
public class TratamientoController {

    private final TratamientoService servicio;

    public TratamientoController(TratamientoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<Tratamiento> listar() {
        return servicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Tratamiento obtener(@PathVariable Long id) {
        return servicio.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tratamiento crear(@RequestBody Tratamiento tratamiento) {
        return servicio.crear(tratamiento);
    }

    @PutMapping("/{id}")
    public Tratamiento actualizar(@PathVariable Long id, @RequestBody Tratamiento tratamiento) {
        return servicio.actualizar(id, tratamiento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable Long id) {
        servicio.borrar(id);
    }
}
