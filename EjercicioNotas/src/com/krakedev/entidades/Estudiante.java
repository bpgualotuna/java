package com.krakedev.entidades;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String apellido;
	private String cedula;
	private ArrayList<Nota> notas = new ArrayList<Nota>();

	
	
	public Estudiante(String cedula,String nombre, String apellido) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
	}

	// Setters and Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public ArrayList<Nota> getNotas() {
		return notas;
	}

	public void setNotas(ArrayList<Nota> notas) {
		this.notas = notas;
	}

	// Metodos

	public void agregarNota(Nota nuevaNota) {
		Nota notaE;
		boolean materiaRepetida = true;
		boolean notaValida = true;
		for (int i = 0; i < notas.size(); i++) {
			notaE = notas.get(i);
			if (notaE.getMateria().getCodigo() == nuevaNota.getMateria().getCodigo()) {
				materiaRepetida = false;
			}
		}
		if (nuevaNota.getCalificacion() > 10 && nuevaNota.getCalificacion() < 0) {
			notaValida = false;
		}

		if (materiaRepetida == true && notaValida == true) {
			notas.add(nuevaNota);
		}
	}

	public void modificarNota(String codigo, double nuevaNota) {

		Nota notaE;
		boolean materiaEncontrada = false;

		if (nuevaNota < 0 && nuevaNota > 10) {

			for (int i = 0; i < notas.size(); i++) {
				notaE = notas.get(i);
				if (notaE.getMateria().getCodigo() == codigo) {
					materiaEncontrada = true;
					notaE.setCalificacion(nuevaNota);
				}
			}
			if (materiaEncontrada == false) {
				System.out.println("Materia no encontrada");
			}
		}

	}

	public double calcularPromedioNotasEstudiante() {
		double promedio;
		double nota = 0.0;
		Nota notaE;
		for (int i = 0; i < notas.size(); i++) {
			notaE = notas.get(i);
			nota += notaE.getCalificacion();
		}
		promedio = (nota / notas.size());
		return promedio;
	}

	public void mostrar() {
		Nota notaE;
		String notasI = "";
		for(int i = 0; i<notas.size();i++) {
			notaE = notas.get(i);
			notasI += Double.toString(notaE.getCalificacion())+",";
		}
		System.out.println("Estudiante: [Nombre: " + nombre + ", apellido: " + apellido + " ,Notas: " + notasI);
	}

}
