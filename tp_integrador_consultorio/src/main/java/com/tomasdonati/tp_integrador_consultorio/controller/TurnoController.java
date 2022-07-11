package com.tomasdonati.tp_integrador_consultorio.controller;

import com.tomasdonati.tp_integrador_consultorio.exceptions.BadRequestException;
import com.tomasdonati.tp_integrador_consultorio.exceptions.ResourceNotFoundException;
import com.tomasdonati.tp_integrador_consultorio.model.Odontologo;
import com.tomasdonati.tp_integrador_consultorio.model.Paciente;
import com.tomasdonati.tp_integrador_consultorio.model.Turno;
import com.tomasdonati.tp_integrador_consultorio.service.OdontologoService;
import com.tomasdonati.tp_integrador_consultorio.service.PacienteService;
import com.tomasdonati.tp_integrador_consultorio.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService service;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;


    @GetMapping
    public ResponseEntity<List<Turno>> listar(){
        List<Turno> lista = service.listarTurnos();
        ResponseEntity response = ResponseEntity.status(HttpStatus.NO_CONTENT).build() ;
        if ( lista!= null) {
            response = ResponseEntity.ok(lista);
        }
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable Long id){
        Optional<Turno> turno = service.buscarTurno(id);
        ResponseEntity response = ResponseEntity.notFound().build();
        if (turno.isPresent()){
            response = ResponseEntity.ok(turno);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Turno> guardar(@RequestBody Turno turno){
        ResponseEntity<Turno> response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        Optional<Paciente> pacienteBus = pacienteService.buscarPaciente(turno.getPaciente().getId());
        Optional<Odontologo> odontologoBus = odontologoService.buscarOdontologo(turno.getPaciente().getId());
        if (pacienteBus.isPresent() && odontologoBus.isPresent()){
            response = ResponseEntity.ok(service.guardarTurno(turno));
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) throws BadRequestException {
        Turno turnoActualizado = service.actualizarTurno(turno);
        return ResponseEntity.ok(turnoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        service.eliminarTurno(id);
        return ResponseEntity.ok("Turno eliminado");
    }

}
