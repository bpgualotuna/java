package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

//System.out.println solo se va a poder usar en los test

public class TestAdminPersona {
	public static void main(String[] args) {
		
		EstadoCivil ec = new EstadoCivil("U","Union Libre");
		Persona p = new Persona("1702398752", "Julio", "Guaraca", ec);
		try {
			Date fechaNac = Convertidor.convertirFecha("2000/12/10");
			Date horaNac = Convertidor.convertirHora("12:23");
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimiento(horaNac);
			p.setCantidadAhorrada(new BigDecimal(1234.23));
			p.setNumeroHijos(50);
			AdminPersonas.insertar(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
	}
	
}
