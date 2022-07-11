package com.tomasdonati.tp_integrador_consultorio.repository;

import com.tomasdonati.tp_integrador_consultorio.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorEmail(String email);
}
