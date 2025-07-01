package com.krakedev.excepciones;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = null;
		System.out.println("INICIO");
		
		try {
			a.substring(3);
			System.out.println("FIN");
		}catch(Exception ex) {
			System.out.println("entra al catch");
		}finally {
			System.out.println("ingresa al finally");
		}
		System.out.println("Fuera del catch");
	}

}
