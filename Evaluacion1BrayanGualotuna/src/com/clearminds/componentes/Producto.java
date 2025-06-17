package com.clearminds.componentes;

public class Producto {
	private String nombre;
	private double precio;
	private String codigo;
	
	
	//Contructor
	public Producto(String codigo, String nombre, double precio) {
		
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}
	//Getters and Setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	//Metodos
	
	public void incrementarPrecio(int incre) {
		precio = precio + (precio * ((double)incre / 100));
	}
	
	public void disminuirPrecio(double desc) {
		precio = precio - (precio * desc);
		precio = Math.round(precio);
	}
}