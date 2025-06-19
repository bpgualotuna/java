package com.krakedev.evaluacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Directorio {
	private ArrayList<Contacto> contactos = new ArrayList<Contacto>();
	private Date fechaModificacion;
	private Date ultimaModificacion;
	private ArrayList<Contacto> correctos = new ArrayList<Contacto>();
	private ArrayList<Contacto> incorrectos = new ArrayList<Contacto>();

	
	

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	public ArrayList<Contacto> getCorrectos() {
		return correctos;
	}

	public void setCorrectos(ArrayList<Contacto> correctos) {
		this.correctos = correctos;
	}

	public ArrayList<Contacto> getIncorrectos() {
		return incorrectos;
	}

	public void setIncorrectos(ArrayList<Contacto> incorrectos) {
		this.incorrectos = incorrectos;
	}

	

	// Metodos
	public boolean agregarContacto(Contacto contacto) {
		Contacto contE;
		this.ultimaModificacion = new Date();
		boolean encontrado = false;
		if (contactos.size() == 0) {
			contactos.add(contacto);
			encontrado = true;
		} else {
			for (int i = 0; i < contactos.size(); i++) {
				contE = contactos.get(i);
				if (contacto.getCedula().equals(contE.getCedula())) {
					break;
				} else {
					
					encontrado = true;
					
				}
			}
			if(encontrado == true) {
				contactos.add(contacto);
			}
		}
		
		
		return encontrado;

	}
	
	public String consultarUltimaModificacion() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd HH:mm:ss");
	    return sdf.format(ultimaModificacion);
	}

	public Contacto buscarPorCedula(String cedulaC) {
		Contacto contE;
		Contacto contactoEncontrado = null;
		for (int i = 0; i < contactos.size(); i++) {
			contE = contactos.get(i);
			if (cedulaC.equals(contE.getCedula())) {
				contactoEncontrado = contE;
			}
		}
		return contactoEncontrado;
	}
	
	public int contarPerdidos() {
		Contacto contE;
		int contador = 0;
		for(int i = 0;i<contactos.size();i++) {
			contE=contactos.get(i);
			if(contE.getDireccion() == null) {
				contador += 1;
			}
		}
		
		return contador;
	}
	
	public int contarFijos() {
		Contacto contE;
		Telefono telfE;
		int contador = 0;
		for(int i = 0;i<contactos.size();i++) {
			contE = contactos.get(i);
			for(int j = 0; j<contE.getTelefonos().size();j++) {
				telfE = contE.getTelefonos().get(j);
				if("Convencional".equals(telfE.getTipo()) && "C".equals(telfE.getEstado())) {
					contador += 1;
				}
			}
		}		
		return contador;
	}
	
	public void depurar() {
		Contacto contE;
		for(int i = 0;i<contactos.size();i++) {
			contE = contactos.get(i);
			if(contE.getDireccion() == null) {
				incorrectos.add(contE);
				
			}else {
				correctos.add(contE);
				
			}
		}
		contactos.clear();
		
	}
}
