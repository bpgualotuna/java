package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiasSemana;



public class TestAlarmas {
	public static void main(String[] args) {
		Alarma a1 = new Alarma(DiasSemana.LUNES,9,30);
		Alarma a2 = new Alarma(DiasSemana.JUEVES,10,20);
		Alarma a3 = new Alarma(DiasSemana.DOMINGO,4,12);
		
		AdminAlarmas ad = new AdminAlarmas();
		ad.agregarAlarma(a1);
		ad.agregarAlarma(a2);
		ad.agregarAlarma(a3);
		
		ArrayList<Alarma> alarmasActuales = ad.getAlarmas();
		
		System.out.println(alarmasActuales);
	}
}
