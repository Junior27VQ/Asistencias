package com.krakedev.asistencias.servicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Asistencia;
import com.krakedev.asistencias.entidades.Estudiante;
import com.krakedev.asistencias.entidades.RegistroAsistencia;

@Service
public class ServicioAsistencia {
	private ArrayList<RegistroAsistencia> registros=new ArrayList<>();
	private final ServicioEstudiante servicioEstudiantes;
	
	public ServicioAsistencia(ServicioEstudiante servicioEstudiantes) {
		this.servicioEstudiantes=servicioEstudiantes;
	}
	public RegistroAsistencia registroAsistencia(String cedula) {
		Estudiante estudiante=servicioEstudiantes.buscarPorCedula(cedula);
		if(estudiante!=null) {
			Asistencia asistencia=new Asistencia(LocalDate.now(),LocalDateTime.now(),"P");
			RegistroAsistencia nuevo=new RegistroAsistencia(estudiante,asistencia);
			registros.add(nuevo);
			return nuevo;
		}
		return null;
	}
	public ArrayList<Asistencia> consultarAsistencia(String cedula){
		ArrayList<Asistencia> asistencia=new ArrayList<Asistencia>();
		for(RegistroAsistencia registro:registros) {
			if(registro.getEstudiante().getCedula().equals(cedula)) {
				asistencia.add(registro.getAsistencia());
			}
		}
		return asistencia;
		
	}

}
