package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telef = new Telefono("claro", "0978690326", 20);
		Contacto c = new Contacto("Paola", "Quiroz", telef, 70.0);
		Telefono telef2 = new Telefono("movi", "0998100257", 10);
		Contacto c2 = new Contacto("Jenni", "Marquez", telef2, 60.0);

		AdminContactos ad = new AdminContactos();

		Contacto pesado = ad.buscarMasPesado(c, c2);
		pesado.imprimir();

		boolean compara = ad.compararOperadoras(c, c2);
		System.out.println(compara);
	}

}
