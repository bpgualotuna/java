package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calcu;
		int resultadoSuma;
		calcu = new Calculadora();
		resultadoSuma = calcu.sumar(5, 3);
		int resultadoResta = calcu.restar(5, 3);
		double resultadoMultiplicar = calcu.multiplicar(5, 3);
		double resultadoDividir = calcu.dividir(5, 3);
		double resultadoPromedio = calcu.promediar(5, 7, 6);
		System.out.println("Resultado Suma: " + resultadoSuma);
		System.out.println("Resultado Resta: " + resultadoResta);
		System.out.println("Resultado Multiplicacion: " + resultadoMultiplicar);
		System.out.println("Resultado Division: " + resultadoDividir);
		System.out.println("Resultado Promedio: " + resultadoPromedio);
		System.out.println("Resultado Mostrar: ");
		calcu.mostrarResultado();
		
		
	}

}
