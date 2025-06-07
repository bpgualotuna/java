package com.krakedev;

public class Cuadrado {
	//Atributos
	double lado;
	
	//Metodos
	public double calcularArea() {
		double respuesta = Math.pow(lado,2);
		return respuesta;
	}
	
	public double calcularPerimetro() {
		double respuesta = lado * 4;
		return respuesta;
	}
}
