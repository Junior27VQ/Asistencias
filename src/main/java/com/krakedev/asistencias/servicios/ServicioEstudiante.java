package com.krakedev.asistencias.servicios;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.krakedev.asistencias.entidades.Estudiante;

@Service
public class ServicioEstudiante {
	private ArrayList<Estudiante> estudiantes=new ArrayList<Estudiante>();
	
	public void agregar(Estudiante estudiante) {
		for(Estudiante e : estudiantes) {
			if(e.getCedula() != estudiante.getCedula()) {
				estudiantes.add(estudiante);
				break;
			}
		}
	}
	public Estudiante buscarPorCedula(String cedula) {
		Estudiante encontrado=null;
		for(Estudiante e:estudiantes) {
			if(e.getCedula().equals(cedula)) {
				encontrado=e;
				break;
			}
		}
		return encontrado;
	}
	public void eliminar(String cedula) {
		Estudiante  e=buscarPorCedula(cedula);
		if(e!=null) {
			estudiantes.remove(e);
		}
	}
	public void actualizar(String cedula, Estudiante nuevo) {
		Estudiante  e=buscarPorCedula(cedula);
		if(e!=null) {
			e.setNombre(nuevo.getNombre());
			e.setApellido(nuevo.getApellido());
		}
	}
	public ArrayList<Estudiante> listar(){
		return estudiantes;
	}

}
