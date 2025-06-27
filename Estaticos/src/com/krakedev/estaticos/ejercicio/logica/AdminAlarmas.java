package com.krakedev.estaticos.ejercicio.logica;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;

public class AdminAlarmas {
	private ArrayList<Alarma> alarmas = new ArrayList<Alarma>();

	
	//Revisar el get 
	public ArrayList<Alarma> getAlarmas() {
		return alarmas;
	}
	
	//Metodos
	
	public void agregarAlarma(Alarma alarma) {
		alarmas.add(alarma);
	}
	
	
}
