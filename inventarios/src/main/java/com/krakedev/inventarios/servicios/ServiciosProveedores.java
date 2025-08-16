package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedoresBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("proveedores")
public class ServiciosProveedores {

	@Path("buscar/{sub}")
	@GET
	@Produces("application/json")
	public Response buscar(@PathParam("sub") String subcadena) {
		ProveedoresBDD provBDD = new ProveedoresBDD();
		ArrayList<Proveedor> proveedores = null;
		try {
			proveedores = provBDD.buscar(subcadena);
			return Response.ok(proveedores).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();

		}

	}
	
	@Path("buscarId/{sub}")
	@GET
	@Produces("application/json")
	public Response buscarIden(@PathParam("sub") String subcadena) {
		ProveedoresBDD provBDD = new ProveedoresBDD();
		ArrayList<Proveedor> proveedores = null;
		try {
			proveedores = provBDD.buscarIden(subcadena);
			return Response.ok(proveedores).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();

		}

	}

	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Proveedor proveedor) {
		System.out.println(">>>>" + proveedor);
		ProveedoresBDD cli = new ProveedoresBDD();
		try {
			cli.insertar(proveedor);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
