package com.example.grupoK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grupoK.model.Tratamiento;

/**
 * Repositorio JPA de Tratamiento.
 * Al extender JpaRepository, Spring crea automáticamente los métodos
 * findAll, findById, save, deleteById, existsById...
 */
@Repository
public interface TratamientoRepository extends JpaRepository<Tratamiento, Long> {
}
