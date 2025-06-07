package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// variable tipo persona 
		Persona p;
		Persona p2 = new Persona();
		p = new Persona();// instanciar un objeto persona, 
		System.out.println("nombre: " + p.nombre);
		System.out.println("edad: " + p.edad);
		System.out.println("estatura" + p.estatura);
		
		p2.nombre="Angelina";
		
		System.out.println("nombre 2: " + p2.nombre);
		
		//Modificar atributos
		
		p.nombre="Mario";
		p.edad=25;
		p.estatura=1.89;
		
		
		
	}

}
