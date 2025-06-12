package com.krakedev.test;

import com.krakedev.composicion.Direccion;
import com.krakedev.composicion.Persona;

public class TestPersona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona p1 = new Persona();
		p1.setNombre("Roman");
		p1.setApellido("Meneses");
		Direccion dir = new Direccion();
		dir.setCallePrincipal("Iglesias");
		dir.setCalleSecundaria("La que cruza");
		dir.setNumero("N-47");
		
		p1.setDireccion(dir);
		
		String nombre = p1.getNombre();
		Direccion d1 = p1.getDireccion();
		
		
		System.out.println(nombre);
		System.out.println(d1.getCallePrincipal());
		
		p1.imprimir();
		
		Persona p2= new Persona();
		Direccion d2 = new Direccion("Av Shyris","Eloy Alfaro","S/N");
		p2.setNombre("Anastasia");
		p2.setDireccion(d2);
		p2.imprimir();
		
		
		Persona p3 = new Persona();
		p3.setDireccion(new Direccion("xx","yy","123"));
		p3.imprimir();
		
		
	}

}
