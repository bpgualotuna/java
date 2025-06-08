package clearminds.cuentas.test;

import clearminds.cuentas.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creo el objeto CUenta y lo referencio con cuenta1
		
		Cuenta cuenta1 = new Cuenta("03476");
		
		//Coloco un valor de saldo en cuenta 1
		
		cuenta1.setSaldo(675);
		
		//Creo el objeto cuenta y lo referencio con cuenta2
		Cuenta cuenta2 = new Cuenta("03476","C",98);
		
		//Creo el objeto Cuenta y lo referencio con cuenta 3
		Cuenta cuenta3 = new Cuenta("03476");
		
		//Modificio el tipo de cuenta
		
		cuenta3.setTipo("C");
		
		//Imprimo cuenta 1, cuenta2,cuenta3
		
		System.out.println("-------Valores Iniciales-----");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		System.out.println("------Valores Modificados----");
		
		//Modificaciones
		
		cuenta1.setSaldo(444);
		cuenta3.setSaldo(567);
		cuenta2.setTipo("D");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		
		//Crear cuenta 4 y modificaciones
		
		Cuenta cuenta4 = new Cuenta("0987");
		cuenta4.setSaldo(10);
		
		//Crear cuenta5 y modificaciones
		
		Cuenta cuenta5 = new Cuenta("0557","C",10);
		
		//Crear cuenta6 y modificaciones
		
		Cuenta cuenta6 = new Cuenta("0666");
		
		cuenta4.imprimirConMiEstilo();
		cuenta5.imprimirConMiEstilo();
		cuenta6.imprimirConMiEstilo();
		
		
	}

}
