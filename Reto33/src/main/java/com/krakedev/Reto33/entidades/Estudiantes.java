package com.krakedev.Reto33.entidades;

import java.util.Date;

public class Estudiantes {
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private Date fecha_nacimiento;
	private int codigo_profesor;
	
	
	
	public Estudiantes() {
		
	}
	public Estudiantes(String cedula, String nombre, String apellido, String email, Date fecha_nacimiento,
			int codigo_profesor) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha_nacimiento = fecha_nacimiento;
		this.codigo_profesor = codigo_profesor;
	}
	public Estudiantes(String cedula, String nombre, String apellido, String email) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public int getCodigo_profesor() {
		return codigo_profesor;
	}
	public void setCodigo_profesor(int codigo_profesor) {
		this.codigo_profesor = codigo_profesor;
	}
	@Override
	public String toString() {
		return "Estudiantes [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", codigo_profesor=" + codigo_profesor + "]";
	}
	
	
	
}
