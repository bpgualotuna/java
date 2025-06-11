package com.cmc.repaso.entidades;

public class Producto {
	private String nombre;
	private double precio;
	
	//Constructor
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}
	
	//Setter and Getters
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
		if (precio >= 0) {
			this.precio = precio;
		}else {
			this.precio = (precio * (-1));
		}
	}
	
	public double calcularPrecioPromo(double descuento) {
		double resultado;
		resultado = precio - (precio * (descuento/100));
		return resultado;
	}
	
}
