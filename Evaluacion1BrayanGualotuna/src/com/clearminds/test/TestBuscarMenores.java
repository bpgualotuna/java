package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {
	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
        maquina.agregarCelda(new Celda("A2"));
        maquina.agregarCelda(new Celda("B1"));
        maquina.agregarCelda(new Celda("B2"));
		
		Producto producto=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto, "A1", 4);
		
		Producto producto2=new Producto("D456","Doritos",0.50);
		maquina.cargarProducto(producto2, "A2", 6);
		Producto producto3=new Producto("BG34","Jet",0.25);
		maquina.cargarProducto(producto3, "B1", 5);
		
		Producto producto4=new Producto("JM23","DeTodito",0.60);
		maquina.cargarProducto(producto4, "B2", 9);
		
		ArrayList<Producto> menores = new ArrayList<Producto>();
		menores = maquina.buscarMenores(1);
		System.out.println("Productos Menores: " + menores.size());
		Producto productoE=null;
		for(int i=0;i<menores.size();i++) {
			productoE=menores.get(i);
			System.out.println("Nombre: " + productoE.getNombre() + " Precio: " + productoE.getPrecio());
		}
		
	}
}
