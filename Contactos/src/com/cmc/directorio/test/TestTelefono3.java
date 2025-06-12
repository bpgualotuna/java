package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdmiTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1 = new Telefono("movi","0978690325",15);
		Telefono telf2 = new Telefono("claro","0956438643",10);
		Telefono telf3 = new Telefono("movi","0735298463",34);
		
		AdmiTelefono ta = new AdmiTelefono();
		
		int movis = ta.contarMovi(telf1, telf2, telf3);
		
		System.out.println("Movis: " + movis);
	}

}
