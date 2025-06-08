package com.krakedev;

public class TestCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//instancia
		Cuadrado c1 = new Cuadrado();
		Cuadrado c2 = new Cuadrado();
		Cuadrado c3 = new Cuadrado();
		
		c1.setLado(4);
		c2.setLado(6);;
		c3.setLado(8);;
		//calculo areas
		double areaC1 = c1.calcularArea();
		double areaC2 = c2.calcularArea();
		double areaC3 = c3.calcularArea();
		//Calculos perimetros
		double periC1 = c1.calcularPerimetro();
		double periC2 = c2.calcularPerimetro();
		double periC3 = c3.calcularPerimetro();
		//muestra resultados
		
		System.out.println("Area C1: " + areaC1);
		System.out.println("Area C2: " + areaC2);
		System.out.println("Area C3: " + areaC3);
		
		System.out.println("Perimetro C1: " + periC1);
		System.out.println("Perimetro C2: " + periC2);
		System.out.println("Perimetro C3: " + periC3);
		
		
		
	}

}
