package com.clearminds.maquina;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private Celda celda1;
	private Celda celda2;
	private Celda celda3;
	private Celda celda4;
	private double saldo;

	public Celda getCelda1() {
		return celda1;
	}

	public void setCelda1(Celda celda1) {
		this.celda1 = celda1;
	}

	public Celda getCelda2() {
		return celda2;
	}

	public void setCelda2(Celda celda2) {
		this.celda2 = celda2;
	}

	public Celda getCelda3() {
		return celda3;
	}

	public void setCelda3(Celda celda3) {
		this.celda3 = celda3;
	}

	public Celda getCelda4() {
		return celda4;
	}

	public void setCelda4(Celda celda4) {
		this.celda4 = celda4;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	// Metodos
	public void configurarMaquina(String c1, String c2, String c3, String c4) {
		this.celda1 = new Celda(c1);
		this.celda2 = new Celda(c2);
		this.celda3 = new Celda(c3);
		this.celda4 = new Celda(c4);

	}

	public void mostrarConfiguracion() {
		System.out.println("CELDA 1: " + celda1.getCodigo());
		System.out.println("CELDA 2: " + celda2.getCodigo());
		System.out.println("CELDA 3: " + celda3.getCodigo());
		System.out.println("CELDA 4: " + celda4.getCodigo());

	}

	public Celda buscarCelda(String cod) {
		if (celda1.getCodigo() == cod) {
			return celda1;
		} else if (celda2.getCodigo() == cod) {
			return celda2;
		} else if (celda3.getCodigo() == cod) {
			return celda3;
		} else if (celda4.getCodigo() == cod) {
			return celda4;
		} else {
			return null;
		}
	}

	public void cargarProducto(Producto producto, String cod, int items) {
		Celda celdaRecuperada = buscarCelda(cod);
		celdaRecuperada.ingresarProducto(producto, items);
	}

	public void mostrarProductos() {
		System.out.println("********CELDA " + celda1.getCodigo());
		System.out.println("Saldo: " + saldo);
		System.out.println("Stock: " + celda1.getStock());
		if (celda1.getProducto() == null) {
			System.out.println("La celda no tiene Producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda1.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda1.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda1.getProducto().getCodigo());
		}
		System.out.println("********CELDA " + celda2.getCodigo());
		System.out.println("Saldo: " + saldo);
		System.out.println("Stock: " + celda2.getStock());
		if (celda2.getProducto() == null) {
			System.out.println("La celda no tiene Producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda2.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda2.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda2.getProducto().getCodigo());
		}
		System.out.println("********CELDA " + celda3.getCodigo());
		System.out.println("Saldo: " + saldo);
		System.out.println("Stock: " + celda3.getStock());
		if (celda3.getProducto() == null) {
			System.out.println("La celda no tiene Producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda3.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda3.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda3.getProducto().getCodigo());
		}
		System.out.println("********CELDA " + celda4.getCodigo());
		System.out.println("Saldo: " + saldo);
		System.out.println("Stock: " + celda4.getStock());
		if (celda4.getProducto() == null) {
			System.out.println("La celda no tiene Producto!!!");
		} else {
			System.out.println("Nombre Producto: " + celda4.getProducto().getNombre());
			System.out.println("Precio Producto: " + celda4.getProducto().getPrecio());
			System.out.println("Codigo Producto: " + celda4.getProducto().getCodigo());
		}
		
	}

	public Producto buscarProductoEnCelda(String cod) {
		if (celda1.getCodigo() == cod) {
			return celda1.getProducto();
		} else if (celda2.getCodigo() == cod) {
			return celda2.getProducto();
		} else if (celda3.getCodigo() == cod) {
			return celda3.getProducto();
		} else if (celda4.getCodigo() == cod) {
			return celda4.getProducto();
		} else {
			return null;
		}
	}

	public double consultarPrecio(String cod) {
		Producto producEncontrado = buscarProductoEnCelda(cod);

		return producEncontrado.getPrecio();
	}

	public Celda buscarCeldaProducto(String cod) {
		if (celda1.getProducto() != null) {
			if (celda1.getProducto().getCodigo() == cod) {
				return celda1;
			}
		} else if (celda2.getProducto() != null) {
			if (celda2.getProducto().getCodigo() == cod) {
				return celda2;
			}
		} else if (celda3.getProducto() != null) {
			if (celda3.getProducto().getCodigo() == cod) {
				return celda3;
			}
		} else if (celda4.getProducto() != null) {
			if (celda4.getProducto().getCodigo() == cod) {
				return celda4;
			}
		} 
		return null;
		
	}

	public void incrementarProductos(String cod, int items) {
		Celda celdaEncontrada = buscarCeldaProducto(cod);
		int aumen = celdaEncontrada.getStock();
		aumen += items;
		celdaEncontrada.setStock(aumen);
		
	}

	public void vender(String cod) {
		int st;
		double prec;
		Celda celdaEncontrada = buscarCelda(cod);
		st = celdaEncontrada.getStock();
		st -= 1;
		celdaEncontrada.setStock(st);
		prec = celdaEncontrada.getProducto().getPrecio();
		saldo += prec;
		mostrarProductos();
	}

	public double venderConCambio(String cod, double ingreso) {
		Celda celdaEncontrada = buscarCelda(cod);
		double cambio = ingreso - celdaEncontrada.getProducto().getPrecio();
		vender(cod);
		return cambio;
	}
}
