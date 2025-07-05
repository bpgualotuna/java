package krakedev.com.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import krakedev.com.inventario.entidades.Categoria;
import krakedev.com.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto producto) {
		System.out.println("Insertando>>>" + producto);
	}
	
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("Actualizando>>>" + producto);
	}
	
	
	@Path("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos(){
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Categoria ct = new Categoria(1,"algo");
		
		Producto p1 = new Producto("123","papas",ct,0.5,20);
		Producto p2 = new Producto("124","doritos",ct,0.8,30);
		Producto p3 = new Producto("125","pan",ct,0.2,60);
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		
		return productos;
	}
	
}
