package com.krakedev.Reto33.test;

import java.util.Date;

import com.krakedev.Reto33.entidades.Estudiantes;
import com.krakedev.Reto33.entidades.Videojuegos;
import com.krakedev.Reto33.servicios.AdminEstudiantes;
import com.krakedev.Reto33.servicios.AdminVideojuegos;
import com.krakedev.Reto33.utils.Convertidor;

public class TestInsertar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Estudiantes es = new Estudiantes("0201","JenniB","Gualo","asdm@asd");
		try {
			
			Date fechaNac = Convertidor.convertirFecha("2003/11/28");
			es.setFecha_nacimiento(fechaNac);
			es.setCodigo_profesor(123);
			AdminEstudiantes.insertar(es);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
		
		Videojuegos vj = new Videojuegos(002,"LoL","MOBA",10);
		try {
			
			AdminVideojuegos.insertar(vj);
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
		
	}
	

}
