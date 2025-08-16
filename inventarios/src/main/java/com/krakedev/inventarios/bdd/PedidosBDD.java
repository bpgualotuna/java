package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.EstadoPedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {

	public void insertar(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;

		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido(proveedor,fecha,estado) " + "values(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");

			ps.executeUpdate();

			rsClave = ps.getGeneratedKeys();

			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement(
						"insert into detalle_pedido(cabecera_ped, producto, cantidad_sol, subtotal,cantidad_rec) "
								+ "values(?,?,?,?,?);");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidadSolicitada());
				// psDet.setBigDecimal(4,det.getSubtotal());
				psDet.setInt(5, 0);

				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtotal = pv.multiply(cantidad);

				psDet.setBigDecimal(4, subtotal);

				psDet.executeUpdate();

			}

			System.out.println("CODIGO GENERADO>>>>> " + codigoCabecera);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar el Producto Detalles: " + e.getMessage());
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void recibir(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psStock = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		
		

		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update cabecera_pedido "
					+ "set estado='R' where numero = ?" );
			ps.setInt(1, pedido.getCodigo());
	
			ps.executeUpdate();

			ArrayList<DetallePedido> detallesPedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement(
						"update detalle_pedido "
						+ "set cantidad_rec=?, subtotal = ? "
						+ "where codigo = ?");
				psDet.setInt(1, det.getCantidadRecibida());
				
				psDet.setInt(3, det.getCodigo());
				

				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadRecibida());
				BigDecimal subtotal = pv.multiply(cantidad);

				psDet.setBigDecimal(2, subtotal);

				psDet.executeUpdate();
				
				psStock = con.prepareStatement("insert into historial_stock(fecha,referencia,producto,cantidad) "
						+ "values(?,?,?,?);");
				psStock.setTimestamp(1,fechaHoraActual);
				psStock.setString(2,"Pedido " + pedido.getCodigo());
				psStock.setInt(3, det.getProducto().getCodigo());
				psStock.setInt(4,det.getCantidadRecibida());
				
				psStock.executeUpdate();

			}
			
			
			
			
			

			System.out.println("CODIGO GENERADO>>>>> " + codigoCabecera);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar el Producto Detalles: " + e.getMessage());
		} catch (KrakeDevException e) {
			// TODO Auto-generated catch block
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public ArrayList<Pedido> busquedaProveedor(String identificador)throws KrakeDevException {
		
		ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
		
		Connection con  = null;
		PreparedStatement psC = null;
		ResultSet rs = null;
		Proveedor proveedor = new Proveedor();
		EstadoPedido estadoPedido = new EstadoPedido();
		
		
		try {
			
			con = ConexionBDD.obtenerConexion();
			psC = con.prepareStatement("select * from cabecera_pedido "
					+ "where proveedor = ?");
			psC.setString(1, identificador);
			rs = psC.executeQuery();
			
			while(rs.next()) {
				int numeroCab = rs.getInt("numero");
				proveedor.setIdentificador(identificador);
				Date fecha = rs.getDate("fecha");
				estadoPedido.setCodigo(rs.getString("estado"));
				
				PreparedStatement psD = con.prepareStatement("select codigo,cabecera_ped,producto,cantidad_sol,cast(subtotal as decimal(6,2)),cantidad_rec "
						+ "from detalle_pedido "
						+ "where cabecera_ped = ?");
				psD.setInt(1, numeroCab);
				ResultSet rsD = psD.executeQuery();
				ArrayList<DetallePedido> detalles = new ArrayList<DetallePedido>();
				
				while(rsD.next()) {
					DetallePedido detalle = new DetallePedido();
					Producto producto = new Producto();
					producto.setCodigo(rsD.getInt("producto"));
					int cantidadSol = rsD.getInt("cantidad_sol");
					BigDecimal subtotal = rsD.getBigDecimal("subtotal");
					int cantidadRec = rsD.getInt("cantidad_rec");
					
					detalle.setProducto(producto);
					detalle.setCantidadSolicitada(cantidadSol);
					detalle.setSubtotal(subtotal);
					detalle.setCantidadRecibida(cantidadRec);
					
					detalles.add(detalle);
				}
				
				Pedido pedido = new Pedido();
				
				pedido.setCodigo(numeroCab);
				pedido.setProveedor(proveedor);
				pedido.setFecha(fecha);
				pedido.setEstado(estadoPedido);
				pedido.setDetalles(detalles);
				
				pedidos.add(pedido);
				
				
				
			}
			
			
		} catch (KrakeDevException e) {

			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al buscar proveedor. detalle: " + e.getMessage());
		}

		
		
		return pedidos;
	}

}
