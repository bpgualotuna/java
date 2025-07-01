package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AdminPersonas.eliminar("1725914236");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sistema: " + e.getMessage());
		}
	}

}
