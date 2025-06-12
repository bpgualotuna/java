package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdmiTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1 = new Telefono("claro","0965342143",10);
		Telefono telf2 = new Telefono("movi","0965342143",10);
		Telefono telf3 = new Telefono("claro","0965342143",10);
		Telefono telf4 = new Telefono("claro","0965342143",10);
		
		AdmiTelefono ta = new AdmiTelefono();
		
		int claros = ta.contarClaro(telf1, telf2, telf3, telf4);
		
		System.out.println("Claros: " + claros);
		
	}

}
