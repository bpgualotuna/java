package com.krakedev.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles = new ArrayList<Numero>();
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	public Naipe() {
		//Inicializacion numeros y valores
		int[] valores = {11,2,3,4,5,6,7,8,9,10,10,10,10};
		String[] numero = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for(int i = 0; i<valores.length;i++) {
			Numero numeroE = new Numero(numero[i],valores[i]);
			numerosPosibles.add(numeroE);
		}
		
		//inicializacion palos
		String[] palos = {"CR","CN","DI","TR"};
		
		//Convinacion numeros con cada palo
		for(int i = 0;i<numerosPosibles.size();i++) {
			for(int j = 0; j<palos.length;j++) {
				cartas.add(new Carta(numerosPosibles.get(i),palos[j]));
			}
		}
		
	}

	public void getCartas(Carta cartas) {
		this.cartas.add(cartas);
	}

}
