package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas = new ArrayList<Celda>();
	private double saldo;

	// Setters and Getters
	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Metodos

	public void agregarCelda(Celda nCelda) {
		// Celda nCelda = new Celda(cod);
		celdas.add(nCelda);
	}

	public void mostrarConfiguracion() {
		Celda nCelda;
		for (int i = 0; i < celdas.size(); i++) {
			nCelda = celdas.get(i);
			System.out.println("Celda " + (i + 1) + ": " + nCelda.getCodigo());
		}
	}

	public Celda buscarCelda(String cod) {
		Celda eCelda = null;
		Celda celdaEncontrada = null;
		for (int i = 0; i < celdas.size(); i++) {
			eCelda = celdas.get(i);
			if (cod == eCelda.getCodigo()) {
				celdaEncontrada = celdas.get(i);
			}
		}
		return celdaEncontrada;
	}

	public void cargarProducto(Producto producto, String cod, int items) {
		Celda celdaRecuperada = buscarCelda(cod);
		celdaRecuperada.ingresarProducto(producto, items);
	}

	public void mostrarProductos() {
		Celda eCelda = null;
		for (int i = 0; i < celdas.size(); i++) {
			eCelda = celdas.get(i);
			if (eCelda.getProducto() == null) {
				System.out.println(
						"Celda: " + eCelda.getCodigo() + " Stock: " + eCelda.getStock() + " Sin Producto Asignado");
			} else {
				System.out.println("Celda: " + eCelda.getCodigo() + " Stock: " + eCelda.getStock() + " Producto: "
						+ eCelda.getProducto().getNombre() + " Precio: " + eCelda.getProducto().getPrecio());
			}
		}
		System.out.println("Saldo: " + saldo);
	}

	public Producto buscarProductoEnCelda(String cod) {
		Producto productoE = null;
		Celda celdaE = null;
		for (int i = 0; i < celdas.size(); i++) {
			celdaE = celdas.get(i);
			if (celdaE.getProducto() != null) {
				if (celdaE.getCodigo() == cod) {
					productoE = celdaE.getProducto();
				}
			}
		}
		return productoE;
	}

	public double consultarPrecio(String cod) {
		Producto productoE;
		double precio;
		productoE = buscarProductoEnCelda(cod);
		precio=productoE.getPrecio();
		return precio;
	}
	
	public Celda buscarCeldaProducto(String cod) {
		Celda celdaE;
		Celda celdaProducto = null;
		for(int i = 0 ; i<celdas.size();i++) {
			celdaE = celdas.get(i);
			if(celdaE.getProducto() != null) {
				if(celdaE.getProducto().getCodigo() == cod) {
					celdaProducto = celdaE;
				}
			}
		}
		return celdaProducto;		
	}
	
	public void incrementarProductos(String codP,int items) {
		Celda celdaEncontrada = buscarCeldaProducto(codP);
		int stock = celdaEncontrada.getStock();
		stock += items;
		celdaEncontrada.setStock(stock);
		
	}
	
	public void vender(String codC) {
		Celda celdaE = buscarCelda(codC);
		int stock = celdaE.getStock();
		stock -= 1;
		celdaE.setStock(stock);
		
		double precio = celdaE.getProducto().getPrecio();
		saldo += precio;
		mostrarProductos();
		
	}
	
	public double venderConCambio(String codC, double valorI) {
		Celda celdaE = buscarCelda(codC);
		int stock = celdaE.getStock();
		stock -= 1;
		celdaE.setStock(stock);
		
		double precio = celdaE.getProducto().getPrecio();
		saldo += precio;
		double cambio = valorI - precio;
		return cambio;
	}
	
	public ArrayList<Producto> buscarMenores(double limite){
		ArrayList<Producto> menores = new ArrayList<Producto>();
		Celda celdaE;
		for(int i = 0;i<celdas.size();i++) {
			celdaE=celdas.get(i);
			if(celdaE.getProducto() != null) {
				if(celdaE.getProducto().getPrecio() < limite) {
					menores.add(celdaE.getProducto());
				}
			}
		}
		return menores;
	}
}
