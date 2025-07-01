package com.krakedev.Reto33.test;

import java.util.Date;

import com.krakedev.Reto33.entidades.Estudiantes;
import com.krakedev.Reto33.entidades.Videojuegos;
import com.krakedev.Reto33.servicios.AdminEstudiantes;
import com.krakedev.Reto33.servicios.AdminVideojuegos;
import com.krakedev.Reto33.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Estudiantes es = new Estudiantes("6234","Jenni","Marquez","jm@asd");
		try {
			
			Date fechaNac = Convertidor.convertirFecha("2003/11/28");
			es.setFecha_nacimiento(fechaNac);
			es.setCodigo_profesor(123);
			AdminEstudiantes.actualizar(es);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
		Videojuegos vj = new Videojuegos(120,"L4D2","Zombies",10);
		try {
			
			AdminVideojuegos.actualizar(vj);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
	}

}
