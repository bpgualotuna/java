package com.krakedev.entidades;

import java.util.ArrayList;
import java.util.Iterator;

public class Naipe {
	private ArrayList<Numero> numerosPosibles = new ArrayList<Numero>();
	private ArrayList<Carta> cartas = new ArrayList<Carta>();

	public Naipe() {
		//Inicializacion numeros y valores
		int[] valores = {11,2,3,4,5,6,7,8,9,10,10,10,10};
		String[] numero = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		
		for(int i = 0; i<valores.length;i++) {
			
			numerosPosibles.add(new Numero(numero[i],valores[i]));
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

	public ArrayList<Carta> barajar(){
		ArrayList<Carta> auxiliar = new ArrayList<Carta>();
		Carta cartaE;
		for(int i = 0;i<100;i++) {
			int posicion = Random.obtenerPosicion();
			cartaE=cartas.get(posicion);
			if("N".equals(cartaE.getEstado())) {
				auxiliar.add(cartaE);
				cartaE.setEstado("C");
			}
		}
		for(int i = 0; i<cartas.size();i++) {
			cartaE = cartas.get(i);
			if("N".equals(cartaE.getEstado())) {
				auxiliar.add(cartaE);
				cartaE.setEstado("C");
			}
		}
		
		return auxiliar;
	}
	
}
