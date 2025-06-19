package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos = new ArrayList<Telefono>();

	// Contructor
	public Contacto(String cedula, String nombre, String apellido) {

		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;

	}

	// Setters and Getters

	public String getCedula() {
		return cedula;
	}

	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	// Metodos
	public void imprimir() {

		System.out.println("Cedula: " + cedula);
		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("Direccion:");
		System.out.println(" Calle Principal: " + direccion.getCallePrincipal());
		System.out.println(" Calle Secundaria: " + direccion.getCalleSecundaria());

		/**
		 * if (direccion != null) { System.out.println("***" + nombre + " " + apellido +
		 * "****"); System.out.println("Direccion: " + direccion.getCallePrincipal() + "
		 * y " + direccion.getCalleSecundaria()); } else { System.out.println("***" +
		 * nombre + " " + apellido + "****"); System.out.println("No tiene asociada una
		 * direccion"); }
		 **/
	}

	public void agregarTelefono(Telefono telefono) {
		telefonos.add(telefono);
	}

	public void mostrarTelefonos() {
		Telefono telE;
		System.out.println("Telefonos con estado 'C':");
		for (int i = 0; i < telefonos.size(); i++) {
			telE = telefonos.get(i);
			if ("C".equals(telE.getEstado())) {
				System.out.println("Numero: " + telE.getNumero() + ", Tipo: " + telE.getTipo());
			}
		}
	}

	public ArrayList<Telefono> recuperarIncorrectos() {
		ArrayList<Telefono> incorrectos = new ArrayList<Telefono>();
		Telefono telE;
		for (int i = 0; i < telefonos.size(); i++) {
			telE = telefonos.get(i);
			if ("E".equals(telE.getEstado())) {
				incorrectos.add(telE);
			}
		}

		return incorrectos;
	}

}
