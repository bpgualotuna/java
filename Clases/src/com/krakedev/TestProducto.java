package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables 
		Producto productoA;
		Producto productoB;
		//Intanciamiento de objetos
		productoA = new Producto();
		productoB = new Producto();
		//Modificacion de atributos
		productoA.descripcion="Hibuprofeno";
		productoA.precio=2.5;
		productoA.stockActual=50;
		
		productoB.descripcion="Henterogermina";
		productoB.precio=0.8;
		productoB.stockActual=90;
		//muestra en pantalla
		System.out.println("Producto1");
		System.out.println("Descripcion: " + productoA.descripcion);
		System.out.println("Precio: " + productoA.precio);
		System.out.println("StockActual: " + productoA.stockActual);

		System.out.println("Producto2");
		System.out.println("Descripcion: " + productoB.descripcion);
		System.out.println("Precio: " + productoB.precio);
		System.out.println("StockActual: " + productoB.stockActual);
		
		
	}

}
