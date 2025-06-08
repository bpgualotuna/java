package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables 
		Producto productoA;
		Producto productoB;
		//Intanciamiento de objetos
		productoA = new Producto("","Hibuprofeno",2.5,60);
		productoB = new Producto("","Henterogermina",0.8,60);
		//Modificacion de atributos
		productoA.setDescripcion("Hibuprofeno");
		productoA.setPrecio(2.5);
		productoA.setStockActual(50);
		
		productoB.setDescripcion("henterogermina");
		productoB.setPrecio(0.8);
		productoB.setStockActual(80);
		//muestra en pantalla
		System.out.println("Producto1");
		System.out.println("Descripcion: " + productoA.getDescripcion());
		System.out.println("Precio: " + productoA.getPrecio());
		System.out.println("StockActual: " + productoA.getStockActual());

		System.out.println("Producto2");
		System.out.println("Descripcion: " + productoB.getDescripcion());
		System.out.println("Precio: " + productoB.getPrecio());
		System.out.println("StockActual: " + productoB.getStockActual());
		
		
	}

}
