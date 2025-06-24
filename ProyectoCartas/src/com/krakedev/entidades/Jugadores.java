package com.krakedev.entidades;

import java.util.ArrayList;

import com.krakedev.servicios.Juego;

public class Jugadores {
	private ArrayList<String> jugadores;

	public ArrayList<String> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<String> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void jugar() {
		ArrayList<String> jugadores = new ArrayList<String>();
		jugadores.add("1");
		jugadores.add("2");
		jugadores.add("3");
		
		Juego juego = new Juego(jugadores);
		juego.entregarCartas(5);
		
		int totalRecorrido = 0;
		
		for(int i = 0; i<jugadores.size();i++) {
			System.out.println("Jugador " + jugadores.get(i) + ": " + juego.devolverTotal(i+1));
			
		}
		
		String ganador = juego.determinarGanador();
		System.out.println("Ganador: Jugador " + ganador);
		
	}
	
	
}
