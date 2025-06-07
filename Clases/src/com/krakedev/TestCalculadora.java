package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calcu;
		int resultadoSuma;
		calcu = new Calculadora();
		resultadoSuma = calcu.sumar(2, 3);
		int resultadoResta = calcu.restar(5, 2);
		System.out.println("Resultado: " + resultadoSuma);
		System.out.println("Resultado: " + resultadoResta);
		
	}

}
