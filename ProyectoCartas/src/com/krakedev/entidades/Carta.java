package com.krakedev.entidades;

public class Carta {
	private Numero numero;
	private String palo;
	
	//Constructor
	public Carta(Numero numero, String palo) {
		
		this.numero = numero;
		this.palo = palo;
	}
	//Getters and Setters
	public Numero getNumero() {
		return numero;
	}
	public void setNumero(Numero numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	//Metodos
	
	public void mostra() {
		System.out.println(numero.getNumeroCarta() + "-" + palo);
	}
	
}
