package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instanciando 2 autos
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		//Modificacion atributos auto 1
		auto1.marca="Chevrolet";
		auto1.anio=2024;		
		auto1.precio= 26000;
		//modificacion atributos auto 2
		auto2.marca="Mercedez";
		auto2.anio=2020;		
		auto2.precio= 24000;
		//Muestra de valores
		System.out.println("Auto de marca: " + auto1.marca + ", año: " + auto1.anio + ", precio: " + auto1.precio);
		System.out.println("Auto de marca: " + auto2.marca + ", año: " + auto2.anio + ", precio: " + auto2.precio);
		

	}

}
