package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telef = new Telefono("movi","0978690326",20);
		Contacto c = new Contacto("Brayan","Gualotuna",telef,90.0);
		
		c.imprimir();
	}

}
