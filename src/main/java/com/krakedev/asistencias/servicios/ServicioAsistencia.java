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
		RegistroAsistencia ra=null;
		Estudiante estudiante=servicioEstudiantes.buscarPorCedula(cedula);
		if(estudiante!=null) {
			Asistencia asistencia=new Asistencia(
					LocalDate.now(),
					LocalDateTime.now(),
					"p"
					);
			ra=new RegistroAsistencia(estudiante,asistencia);
			registros.add(ra);
		}
		return ra;
	}
	public ArrayList<Asistencia> consultarAsistencia(String cedula){
		ArrayList<Asistencia> asistencia=new ArrayList<Asistencia>();
		Estudiante e=servicioEstudiantes.buscarPorCedula(cedula);
		for(RegistroAsistencia ra:registros) {
			if(ra.getEstudiante()==e && e!=null) {
				Asistencia a=ra.getAsistencia();
				asistencia.add(a);
			}
		}
		return asistencia;
		
	}

}
