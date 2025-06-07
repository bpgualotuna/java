package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo();
		//Definicion bases y alturas
		r1.base = 10;
		r1.altura = 5;
		
		r2.base = 8;
		r2.altura = 3; 
		
		// calculos Areas
		int areaR1 = r1.calcularArea();
		int areaR2 = r2.calcularArea();
		// calculo perimetros
		double periR1 = r1.calcularPerimetro();
		double periR2 = r2.calcularPerimetro();
		
		
		
		System.out.println("Area de R1: " + areaR1);
		System.out.println("Area de R2: " + areaR2);
		System.out.println("Perimetro R1: " + periR1);
		System.out.println("Perimetro R1: " + periR2);
		
	}

}
