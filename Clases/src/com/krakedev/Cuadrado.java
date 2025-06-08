package com.krakedev;

public class Cuadrado {
	//Atributos
	private double lado;
	
	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}

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
