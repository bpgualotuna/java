package com.cmc.evaluacion.servicios;

public class Util {
	public static double redondear(double valor) {
		return Math.round(valor * 100.0) / 100.0;
	}
}