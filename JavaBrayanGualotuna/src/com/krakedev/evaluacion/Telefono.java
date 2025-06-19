package com.krakedev.evaluacion;

public class Telefono {
	private String numero;
	private String tipo;
	private String estado;

	public Telefono(String numero, String tipo) {

		if (numero != null && tipo != null) {
			if (tipo == "Movil" || tipo == "Convencional") {
				if (tipo == "Movil") {
					if (numero.length() == 10) {
						this.estado = "C";
					} else {
						this.estado = "E";
					}
				} else {
					if (numero.length() == 7) {
						this.estado = "C";
					} else {
						this.estado = "E";
					}
				}
			} else {
				this.estado = "E";
			}
		} else {
			this.estado = "E";
		}

		this.numero = numero;
		this.tipo = tipo;
	}

	// Getters
	public String getNumero() {
		return numero;
	}

	public String getTipo() {
		return tipo;
	}

	public String getEstado() {
		return estado;
	}

}
