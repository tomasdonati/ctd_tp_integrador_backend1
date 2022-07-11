package com.tomasdonati.tp_integrador_consultorio.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Odontologo odontologo;

    @Column
    private LocalDate fecha;

    public Turno(Long id, Paciente paciente, Odontologo odontologo) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Paciente paciente, Odontologo odontologo) {
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    public Turno() {
    }
}
