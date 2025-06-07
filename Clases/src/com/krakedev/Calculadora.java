package com.krakedev;

public class Calculadora {
	public int sumar(int valor1,int valor2) {
		int resultado;//declarar la variable
		resultado = valor1 + valor2;
		return resultado;
	}
	
	public int restar(int valor1, int valor2) {
		int resultado;
		resultado = valor1 - valor2;
		return resultado;
	}
	
	public double multiplicar(double valor1,double valor2) {
		double resultado = valor1 * valor2;		
		return resultado;
	}
	
	public double dividir(double dividendo, double divisor) {
		double resultado = dividendo / divisor;
		return resultado;
	}
	
	public double promediar(double valor1, double valor2, double valor3) {
		double resultado = (valor1 + valor2 + valor3) / 3;
		return resultado;
	}
	
	public void mostrarResultado() {
		System.out.println("Ahorita no joven, Sali al almuerzo. Regreso en 15 minutos");
	}
	
}
