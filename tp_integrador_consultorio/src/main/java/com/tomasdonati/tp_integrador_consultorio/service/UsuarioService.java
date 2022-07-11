package com.tomasdonati.tp_integrador_consultorio.service;

import com.tomasdonati.tp_integrador_consultorio.model.Usuario;
import com.tomasdonati.tp_integrador_consultorio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado = userRepository.findByEmail(username);
        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else {
            throw new UsernameNotFoundException("El email ingresado no es correcto");
        }
    }
}
