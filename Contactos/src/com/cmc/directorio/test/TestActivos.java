package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdmiTelefono;
import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi","0978690326",20);
		Contacto contac = new Contacto("Brayan","Gualotuna",telf,20);
		
		telf.imprimir();
		contac.imprimir();
		
		AdminContactos ad = new AdminContactos();
		AdmiTelefono at = new AdmiTelefono();
		
		at.activarMensajeria(telf);
		ad.activarUsuario(contac);
		
		telf.imprimir();
		contac.imprimir();
	}

}
