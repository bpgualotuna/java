package com.cmc.evaluacion.servicios;

import com.cmc.evaluacion.entidades.Cuota;
import com.cmc.evaluacion.entidades.Prestamo;

public class CalculadoraAmortizacion {

	public static double calcularCuota(Prestamo prestamo) {
		double monto = prestamo.getMonto();
		double interesAnual = prestamo.getInteres();
		int plazo = prestamo.getPlazo();

		double i = (interesAnual / 12) / 100;
		int n = plazo;

		return (monto * i) / (1 - Math.pow(1 + i, -n));
	}

	public static void generarTabla(Prestamo prestamo) {
		double cuotaMensual = calcularCuota(prestamo);
		double saldoAnterior = prestamo.getMonto();
		double tasaMensual = (prestamo.getInteres() / 12) / 100;

		for (int i = 0; i < prestamo.getPlazo(); i++) {
			Cuota cuota = new Cuota(i + 1);
			cuota.setCuota(cuotaMensual);
			cuota.setCapitalInicio(saldoAnterior);

			double interes = saldoAnterior * tasaMensual;
			double abonoCapital = cuotaMensual - interes;
			saldoAnterior -= abonoCapital;

			if (i == prestamo.getPlazo() - 1) {
				abonoCapital += saldoAnterior;
				saldoAnterior = 0;
			}

			cuota.setInteres(interes);
			cuota.setAbonoCapital(abonoCapital);
			cuota.setSaldo(saldoAnterior);

			prestamo.getCuotas().add(cuota);
		}
	}

	public static void mostrarTabla(Prestamo prestamo) {
		System.out.println("N° | Cuota | Inicio | Interés | Abono | Saldo");
		for (int i = 0; i < prestamo.getCuotas().size(); i++) {
			Cuota cuota = prestamo.getCuotas().get(i);
			cuota.mostrarPrestamo();
		}
	}
}