package com.krakedev.entidades;

import java.util.ArrayList;

public class Curso {
	private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	
	//Metodos
	
	public Estudiante buscarEstudiantePorCedula(Estudiante estudiante) {
		Estudiante estudianteE;
		
		for(int i = 0;i<estudiantes.size();i++){
			estudianteE = estudiantes.get(i);
			if(estudianteE.getCedula() == estudiante.getCedula()) {
				System.out.println("Estudiante encontrado");
			}
		}
		return null;
	}
	
	public void matricularEstudiante(Estudiante estudiante) {
		if(buscarEstudiantePorCedula(estudiante) == null) {
			estudiantes.add(estudiante);
		}
	}
	
	public double calcularPromedioCurso() {
		double promedio;
		Estudiante estudiantesE;
		double notas = 0.0;
		for(int i = 0; i<estudiantes.size();i++) {
			estudiantesE=estudiantes.get(i);
			notas += estudiantesE.calcularPromedioNotasEstudiante();
		}
		promedio = notas / estudiantes.size();
		return promedio;
	}
	
	public void mostrar() {
		String estudiantesL = "";
		Estudiante estudiantesA;
		for(int i = 0;i<estudiantes.size();i++) {
			estudiantesA = estudiantes.get(i);
			estudiantesL += "Estudiante " + (i+1) + ": " + estudiantesA.getNombre();
		}
		System.out.println("Curso: [" + estudiantesL);
	}
	
}
