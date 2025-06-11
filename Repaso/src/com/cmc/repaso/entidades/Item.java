package com.cmc.repaso.entidades;

public class Item {
	private String nombre;
	private int productosActuales;
	private int productosDevueltos;
	private int productosVendidos;
	
	
	//Constructor
	public Item(String nombre) {
		this.nombre = nombre;
	}
	//Setters and Getters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getProductosActuales() {
		return productosActuales;
	}
	public void setProductosActuales(int productosActuales) {
		this.productosActuales = productosActuales;
	}
	public int getProductosDevueltos() {
		return productosDevueltos;
	}
	public void setProductosDevueltos(int productosDevueltos) {
		this.productosDevueltos = productosDevueltos;
	}
	public int getProductosVendidos() {
		return productosVendidos;
	}
	public void setProductosVendidos(int productosVendidos) {
		this.productosVendidos = productosVendidos;
	}
	//Metodos
	//Imprime datos en pantalla
	public void imprimir() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Productos Actuales: " + this.productosActuales);
		System.out.println("Productos Devueltos: " + this.productosDevueltos);
		System.out.println("Productos Vendidos: " + this.productosVendidos);
	}
	//Metodo vender
	public void vender(int productosVendidos) {
		this.productosVendidos += productosVendidos;
		this.productosActuales -= productosVendidos;
	}
	//Método devolver
	public void devolver(int productosVendidos) {
		this.productosActuales += productosVendidos;
		this.productosVendidos -= productosVendidos;
		this.productosDevueltos += productosVendidos;
	}
	
}
