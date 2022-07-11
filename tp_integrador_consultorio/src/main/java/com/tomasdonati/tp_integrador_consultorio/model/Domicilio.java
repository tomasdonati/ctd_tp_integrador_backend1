package com.tomasdonati.tp_integrador_consultorio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    @Column
    private String calle;
    @Column
    private String localidad;
    @Column
    private String provincia;
    @Column
    private int numero;

    public Domicilio(){}

    public Domicilio(Long id, String calle, String localidad, String provincia, int numero) {
        this.id = id;
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.numero = numero;
    }

    public Domicilio(String calle, String localidad, String provincia, int numero) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.numero = numero;
    }
}
