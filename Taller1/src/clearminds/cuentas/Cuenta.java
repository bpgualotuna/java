package clearminds.cuentas;

public class Cuenta {
	private String id;
	private String tipo = "A";
	private double saldo;
	
	//Constructores
	public Cuenta(String id) {
		this.id = id;
		this.tipo="A";
	}
	
	public Cuenta(String id, String tipo, double saldo) {
		this.id = id;
		this.tipo = tipo;
		this.saldo = saldo;
	}

	// Setters and Getters
	public String getId() {
		return id;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	//Metodos
	
	public void imprimir() {
		System.out.println("************************");
	    System.out.println("CUENTA");
	    System.out.println("************************");
	    System.out.println("Número de Cuenta: " + id);
	    System.out.println("Tipo: " + tipo);
	    System.out.println("Saldo: USD " + saldo);
	    System.out.println("************************");
	}
	
	public void imprimirConMiEstilo() {
	    System.out.println("--- DETALLE DE CUENTA ---");
	    System.out.println("- Cuenta No.: " + id);
	    System.out.println("- Cuenta Tipo: " + tipo);
	    System.out.println("- Fondos: $" + saldo + " USD");
	    System.out.println("-------------------");
	}
	
}
