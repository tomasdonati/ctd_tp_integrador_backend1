package com.tomasdonati.tp_integrador_consultorio.service;

import com.tomasdonati.tp_integrador_consultorio.model.Usuario;
import com.tomasdonati.tp_integrador_consultorio.model.UsuarioRoles;
import com.tomasdonati.tp_integrador_consultorio.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader  implements ApplicationRunner {

    @Autowired
    UsuarioRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass = passwordEncoder.encode("admin");
        String pass2 = passwordEncoder.encode("1234");
        userRepository.save(new Usuario("tomasdonati", "tomasdonati@gmail.com", pass2, UsuarioRoles.ROLE_USER ));
        userRepository.save(new Usuario("admin" ,"admin@email.com", pass, UsuarioRoles.ROLE_ADMIN));
    }
}
