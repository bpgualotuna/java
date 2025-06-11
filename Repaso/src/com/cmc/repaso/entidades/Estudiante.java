package com.cmc.repaso.entidades;

public class Estudiante {
	private String nombre;
	private double nota;
	private String resultado;
	
	//Contructor con nombre
	public Estudiante(String nombre) {
		this.nombre = nombre;
		
	}
	
	//Metodos 
	public void calificar(double nota) {
		this.nota = nota;
		if(nota < 8) {
			this.resultado = "F";
		}else if(nota >= 8) {
			this.resultado = "A";
		}
	}
	
	
	
}
