package com.krakedev.asistencias.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.servicios.ServicioEstudiante;

@RestController

@RequestMapping("/estudiante")
public class ControladorEstudiantes {
	private final ServicioEstudiante servicioEstudiante; 
	public ControladorEstudiantes(ServicioEstudiante servicioEstudiante) {
		this.servicioEstudiante=servicioEstudiante;
	}
	
	@PostMapping
	public void guardar(@RequestBody Estudiante estudiante) {
		servicioEstudiante.agregar(estudiante);
	}
	@GetMapping("/{cedula}")
	public Estudiante buscar(@PathVariable String cedula) {
		return servicioEstudiante.buscarPorCedula(cedula);
	}
	@DeleteMapping("/{cedula}")
	public void eliminar(@PathVariable String cedula) {
		servicioEstudiante.eliminar(cedula);
	}
	@PutMapping("/{cedula}")
	public void actualizar(@PathVariable String cedula, @RequestBody Estudiante estudiante) {
		servicioEstudiante.actualizar(cedula, estudiante);
	}
	@GetMapping
	public ArrayList<Estudiante> lista(){
		return servicioEstudiante.listar();
	}

}
