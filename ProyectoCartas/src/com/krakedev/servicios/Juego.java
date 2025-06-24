package com.krakedev.servicios;

import java.util.ArrayList;

import com.krakedev.entidades.Carta;
import com.krakedev.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugadores;
	private ArrayList<Carta> naipeBarajado;

	
	/**
	public Juego(ArrayList<Integer> idsJugadores) {
		this.naipe = new Naipe();
		this.cartasJugadores = new ArrayList<ArrayList<Carta>>();

		for (int i = 0; i < idsJugadores.size(); i++) {
			ArrayList<Carta> cartaJ = new ArrayList<Carta>();
			cartasJugadores.add(cartaJ);
		}

	}
	**/

	public Juego(ArrayList<String> nombresJugadores) {
		this.naipe = new Naipe();
		this.cartasJugadores = new ArrayList<ArrayList<Carta>>();

		// Convertir nombres a IDs implícitos (índices + 1)
		for (int i = 0; i < nombresJugadores.size(); i++) {
			ArrayList<Carta> cartaJ = new ArrayList<Carta>();
			cartasJugadores.add(cartaJ);
		}
		this.naipeBarajado = naipe.barajar();
	}

	public Juego() {
		this.naipe = new Naipe();
		this.naipeBarajado = naipe.barajar();

	}

	// Getter
	public ArrayList<ArrayList<Carta>> getCartasJugadores() {
		return cartasJugadores;
	}

	// Metodo

	public void entregarCartas(int cartasPorJugador) {
		int naipe = 0;
		for (int i = 0; i < cartasPorJugador; i++) {
			for (int j = 0; j < cartasJugadores.size(); j++) {
				cartasJugadores.get(j).add(naipeBarajado.get(naipe));
				naipe++;
				//System.out.println("Asignada carta a Jugador " + (j + 1) + ": " + naipeBarajado.get(naipe - 1).getNumero().getNumeroCarta());
			}
		}
	}

	public int devolverTotal(int idJ) {
	    int total = 0;
	    if (idJ <= cartasJugadores.size()) {
	        int index = idJ ; // Ajustar índice (0-based)
	        for (Carta carta : cartasJugadores.get(index)) {
	            total += carta.getNumero().getValor();
	        }
	    }
	    return total;
	}

	public String determinarGanador() {
		int idGanador = 1;
		int sumaGanador = devolverTotal(0);
		String ganador = "";

		for (int i = 1; i < cartasJugadores.size(); i++) {
			int sumaA = devolverTotal(i);
			if (sumaA > sumaGanador) {
				sumaGanador = sumaA;
				idGanador = i;
			}
		}

		ganador += "Jugador " + idGanador;
		return ganador;
	}

}
