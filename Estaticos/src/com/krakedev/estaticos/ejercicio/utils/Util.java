package com.krakedev.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int numero) {
		String valor = "";
		if (numero < 10 && numero >= 0) {
			valor  = "0" + numero + "";
		}else {
			valor = numero + "";
		}
		
		
		return valor;
	}
	
	public static String formatearDia(int numero) {
		String valor = "";
		switch (numero) {
		case 0:
			valor = "Lunes";
			break;
		case 1:
			valor = "Martes";
			break;
		case 2:
			valor = "Miercoles";
			break;
		case 3:
			valor = "Jueves";
			break;
		case 4:
			valor = "Viernes";
			break;
		case 5:
			valor = "Sabado";
			break;
		case 6:
			valor = "Domingo";
			break;		
			
		}		
		
		return valor;
	}
}
