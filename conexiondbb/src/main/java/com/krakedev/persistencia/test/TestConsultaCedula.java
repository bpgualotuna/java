package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaCedula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Persona persona = AdminPersonas.buscarPorCedula("1709342987");
			System.out.println(persona);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
