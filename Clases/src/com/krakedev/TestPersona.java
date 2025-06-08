package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// variable tipo persona 
		Persona p;
		Persona p2 = new Persona();
		p = new Persona();// instanciar un objeto persona, 
		Persona p3 = new Persona("Brayan", 25,1.8);
		
		System.out.println("nombre: " + p3.getNombre());
		System.out.println("edad: " + p3.getEdad());
		System.out.println("estatura" + p3.getEstatura());
		
		
		
		System.out.println("nombre: " + p.getNombre());
		System.out.println("edad: " + p.getEdad());
		System.out.println("estatura" + p.getEstatura());
		
		p2.setNombre("Angelina");
		
		System.out.println("nombre 2: " + p2.getNombre());
		
		//Modificar atributos
		
		p.setNombre("Matio");
		p.setEdad(25);
		p.setEstatura(1.8);
		
		
		
	}

}
