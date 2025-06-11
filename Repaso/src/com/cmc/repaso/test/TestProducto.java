package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto producto1 = new Producto("Pan",0.3);
		
		producto1.setPrecio(-0.5);
		
		producto1.calcularPrecioPromo(50);
		
	}

}
