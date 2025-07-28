package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentoBDD;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("tiposdocumento")
public class ServicioTipoDocumento {
	
	@Path("recuperar/{sub}")
	@GET
	@Produces("application/json")
	public Response buscar(@PathParam("sub")String subcadena){
		TipoDocumentoBDD provBDD = new TipoDocumentoBDD();
		ArrayList<TipoDocumento> documentos = null;
		try {
			documentos = provBDD.recuperar(subcadena);
			return Response.ok(documentos).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
			
		}
		
	}
	
}
