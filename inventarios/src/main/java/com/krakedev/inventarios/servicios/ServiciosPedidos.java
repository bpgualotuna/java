package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidosBDD;
import com.krakedev.inventarios.bdd.ProductosBDD;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("pedidos")
public class ServiciosPedidos {
	
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Pedido pedido) {
			PedidosBDD pedidoBDD = new PedidosBDD();
			try {
				pedidoBDD.insertar(pedido);
				return Response.ok().build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return Response.serverError().build();
			}
	}
	
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recibir(Pedido pedido) {
			PedidosBDD pedidoBDD = new PedidosBDD();
			try {
				pedidoBDD.recibir(pedido);
				return Response.ok().build();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return Response.serverError().build();
			}
	}
	
	@Path("buscar/{sub}")
	@GET
	@Produces("application/json")
	public Response buscar(@PathParam("sub") String subcadena) {
		PedidosBDD pedidoBDD = new PedidosBDD();
		ArrayList<Pedido> pedido = null;
		try {
			pedido = pedidoBDD.busquedaProveedor(subcadena);
			return Response.ok(pedido).build();
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();

		}

	}
	
}
