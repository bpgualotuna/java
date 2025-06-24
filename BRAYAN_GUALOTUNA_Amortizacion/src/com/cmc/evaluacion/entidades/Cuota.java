package com.cmc.evaluacion.entidades;

import com.cmc.evaluacion.servicios.Util;

public class Cuota {
	private int numero;
	private double cuota;
	private double capitalInicio;
	private double inicio;
	private double interes;
	private double abonoCapital;
	private double saldo;

	public Cuota(int numero) {
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}

	public double getInicio() {
		return inicio;
	}

	public void setInicio(double inicio) {
		this.inicio = inicio;
	}

	public double getCuota() {
		return cuota;
	}

	public void setCuota(double cuota) {
		this.cuota = Util.redondear(cuota);
	}

	public double getCapitalInicio() {
		return capitalInicio;
	}

	public void setCapitalInicio(double capitalInicio) {
		this.capitalInicio = Util.redondear(capitalInicio);
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = Util.redondear(interes);
	}

	public double getAbonoCapital() {
		return abonoCapital;
	}

	public void setAbonoCapital(double abonoCapital) {
		this.abonoCapital = Util.redondear(abonoCapital);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = Util.redondear(saldo);
	}

	public void mostrarPrestamo() {
		String resultado = numero + " | " + cuota + " | " + capitalInicio + " | " + interes + " | " + abonoCapital
				+ " | " + saldo;
		System.out.println(resultado);
	}
}