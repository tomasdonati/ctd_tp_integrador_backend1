package com.tomasdonati.tp_integrador_consultorio.repository;

import com.tomasdonati.tp_integrador_consultorio.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    @Query("Select p From Paciente p where p.email=?1")
    Optional<Paciente> buscarPacientePorEmail(String email);
}
