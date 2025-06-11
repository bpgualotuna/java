package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Estudiante;
import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {
	public static void main(String[] args) {
		Validacion validacion = new Validacion();
		validacion.validarMonto(-4);
		validacion.validarMonto(100);
		
		Estudiante estudiante1 = new Estudiante("Brayan");
		estudiante1.calificar(9);
		estudiante1.calificar(5);
		
	}
}
