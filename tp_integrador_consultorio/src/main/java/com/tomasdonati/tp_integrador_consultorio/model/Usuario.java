package com.tomasdonati.tp_integrador_consultorio.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@Entity
public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String username;
    @Column
    private String email;
    @Column
    private String password;
    @Enumerated(EnumType.STRING)
    private UsuarioRoles rolesUsuario;

    public Usuario() {
    }

    public Usuario(String username, String email, String password, UsuarioRoles rolesUsuario) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rolesUsuario = rolesUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority =new SimpleGrantedAuthority(rolesUsuario.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
