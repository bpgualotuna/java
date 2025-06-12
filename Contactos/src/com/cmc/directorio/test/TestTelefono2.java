package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdmiTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi","098234234",20);
		AdmiTelefono at = new AdmiTelefono();
		at.activarMensajeria(telf);
		
		telf.imprimir();
	}

}
