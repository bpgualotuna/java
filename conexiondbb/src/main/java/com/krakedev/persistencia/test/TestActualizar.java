package com.krakedev.persistencia.test;

import java.math.BigDecimal;
import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstadoCivil ec = new EstadoCivil("U","Union Libre");
		Persona p = new Persona("1709362987", "Jose", "Chiliguano", ec);
		
		try {
			Date fechaNac = Convertidor.convertirFecha("1966/06/16");
			Date horaNac = Convertidor.convertirHora("01:58");
			p.setFechaNacimiento(fechaNac);
			p.setHoraNacimiento(horaNac);
			p.setCantidadAhorrada(new BigDecimal(6666.66));
			p.setNumeroHijos(50);
			AdminPersonas.actualizar(p);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en el sistema: " + e.getMessage());
		}
		
	}

}
