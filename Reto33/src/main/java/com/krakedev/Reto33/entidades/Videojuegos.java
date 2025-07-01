package com.krakedev.Reto33.entidades;

public class Videojuegos {
	private int codigo;
	private String nombre;
	private String descripcion;
	private int valoracion;
	
	
	
	public Videojuegos() {
		
	}
	public Videojuegos(int codigo, String nombre, int valoracion) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.valoracion = valoracion;
	}
	public Videojuegos(int codigo, String nombre, String descripcion, int valoracion) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.valoracion = valoracion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getValoracion() {
		return valoracion;
	}
	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}
	
	
}
