package com.krakedev.sobrecarga;

public class Bienvenida {
	public void saluda(String nombre) {
		System.out.println("Hola" + nombre);
	}
	
	public void saluda(String nombre,String apellido) {
		System.out.println("Hola" + nombre + " " + apellido);
	}
}
