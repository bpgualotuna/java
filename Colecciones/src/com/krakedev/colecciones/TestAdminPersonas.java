package com.krakedev.colecciones;

import java.util.ArrayList;

public class TestAdminPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdminPersonas admin = new AdminPersonas();
		admin.agregar(new Persona("Mario","Benedetti",50));
		admin.agregar(new Persona("Clark","kent",30));
		admin.agregar(new Persona("Pedro","Detti",50));
		admin.imprimir();
		
		Persona p1=admin.buscarPorNombre("Pedro");
		if(p1 != null) {

			System.out.println("Encontrad: " + p1.getApellido() + " " + p1.getEdad());
		}else {
			System.out.println("No existe persona con ese nombre " );
		}
		
		ArrayList<Persona> personasMayores = admin.buscarMayores(35);
		System.out.println(personasMayores.size());
		
	}

}
