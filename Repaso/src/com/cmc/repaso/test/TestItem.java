package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instancia del objeto
		Item item1 = new Item("Queso");
		// Seteo de productos actuales
		item1.setProductosActuales(20);
		// Pruebas de metodos
		item1.imprimir();
		item1.vender(5);
		item1.imprimir();
		item1.devolver(2);
		item1.imprimir();
		// Creacion segundo producto, Intancia Item2
		Item item2 = new Item("Pan");
		// Seteo productos
		item2.setProductosActuales(30);
		// Pruebas de metodos
		item2.imprimir();
		item2.vender(10);
		item2.imprimir();
		item2.devolver(5);
		item2.imprimir();

	}

}
