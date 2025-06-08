package com.krakedev.test;

import com.krakedev.Rectangulo;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1 = new Rectangulo(10,5);
		Rectangulo r2 = new Rectangulo(5,3);
		//Definicion bases y alturas
		/**r1.setBase(10);
		r1.setAltura(5);
		
		r2.setBase(5);
		r2.setAltura(3); 
		**/
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
