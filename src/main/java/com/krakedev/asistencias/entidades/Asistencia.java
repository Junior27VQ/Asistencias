package com.krakedev.asistencias.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Asistencia {
	private LocalDate fecha;
	private LocalDateTime fechaHoraRegistro;
	private String estado;
	
	public Asistencia() {}
	public Asistencia(LocalDate fecha, LocalDateTime fechaHoraRegistro, String estado) {
		super();
		this.fecha = fecha;
		this.fechaHoraRegistro = fechaHoraRegistro;
		this.estado = estado;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalDateTime getFechaHoraRegistro() {
		return fechaHoraRegistro;
	}
	public void setFechaHoraRegistro(LocalDateTime fechaHoraRegistro) {
		this.fechaHoraRegistro = fechaHoraRegistro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Asistencia [fecha=" + fecha + ", fechaHoraRegistro=" + fechaHoraRegistro + ", estado=" + estado + "]";
	}
	

}
