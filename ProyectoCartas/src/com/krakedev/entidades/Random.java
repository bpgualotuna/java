package com.krakedev.entidades;

public class Random {
	public static int obtenerPosicion() {
		//Math.random genera un numero entre 0 y 1, incluyendo unicamente el 0
		//Math.floor, redondea el resultado al resultado mas bajo, 0.99-->0
		//Casting (int) para apsarlo a un entero ya que el resultado en double
		int numero = (int)Math.floor(Math.random() * 52);
		
		return numero;
	}
}
