package com.krakedev.test;

import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Instanciando 2 autos
		Auto auto1 = new Auto("Chevrolet",2000,16000);
		Auto auto2 = new Auto("Mercedez",2026,36000);
		//Modificacion atributos auto 1
		/**
		auto1.setMarca("Chevrolet");
		auto1.setAnio(2000);		
		auto1.setPrecio(160000);
		//modificacion atributos auto 2
		auto2.setMarca("Mercedez");
		auto2.setAnio(2026);		
		auto2.setPrecio(36000);*/
		//Muestra de valores
		System.out.println("Auto de marca: " + auto1.getMarca() + ", año: " + auto1.getAnio() + ", precio: " + auto1.getPrecio());
		System.out.println("Auto de marca: " + auto2.getMarca() + ", año: " + auto2.getAnio() + ", precio: " + auto2.getPrecio());
		

	}

}
