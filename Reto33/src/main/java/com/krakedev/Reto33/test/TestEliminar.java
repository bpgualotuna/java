package com.krakedev.Reto33.test;

import com.krakedev.Reto33.servicios.AdminEstudiantes;
import com.krakedev.Reto33.servicios.AdminVideojuegos;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			AdminEstudiantes.eliminar("3234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
		try {
			AdminVideojuegos.eliminar(126);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error en el sistema: " + e.getMessage());
		}
	}

}
