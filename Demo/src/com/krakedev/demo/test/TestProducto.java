package com.krakedev.demo.test;

import com.krakedev.demo.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto producto1 = new Producto(12,"Jabon");
		
		producto1.setDescripcion("Para manos");
		producto1.setPeso(0.8);
		
		System.out.println("El producto es: " + producto1.getNombre());
		System.out.println("Descripcion: " + producto1.getDescripcion());
		System.out.println("Codigo: " + producto1.getCodigo());
		System.out.println("Peso: " + producto1.getPeso());
	}

}
