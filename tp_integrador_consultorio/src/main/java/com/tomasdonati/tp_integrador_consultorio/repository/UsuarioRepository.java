package com.tomasdonati.tp_integrador_consultorio.repository;

import com.tomasdonati.tp_integrador_consultorio.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository {
    Optional<Usuario> buscarPorEmail(String email);
}
