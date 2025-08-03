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

import com.krakedev.inventarios.entidades.DetalleVenta;
import com.krakedev.inventarios.entidades.Venta;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {
	public void insertar(Venta venta) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psCab = null;
		PreparedStatement psDet = null;
		PreparedStatement psStock = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;
		BigDecimal t = new BigDecimal(0);
		
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_ventas(fecha,total_sin,iva,total) " + "values(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, fechaHoraActual);
			ps.setBigDecimal(2,t);
			ps.setBigDecimal(3,t);//Inicializado en 0 porque es solo la creación
			ps.setBigDecimal(4,t);

			ps.executeUpdate();

			rsClave = ps.getGeneratedKeys();

			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetalleVenta> detallesVentas = venta.getDetalles();
			DetalleVenta det;
			for (int i = 0; i < detallesVentas.size(); i++) {
				
				//creacion detalle pedidos
				det = detallesVentas.get(i);
				psDet = con.prepareStatement(
						"insert into detalle_ventas(cabecera_ventas, producto, cantidad, precio_vent,subtotal,subtotal_iva) "
								+ "values(?,?,?,?,?,?);");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidad());
				psDet.setBigDecimal(4,det.getProducto().getPrecioVenta());
				//Multiplicaciones Big Decimal para ventas
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				BigDecimal subtotal = pv.multiply(cantidad);
				BigDecimal subtotalIva = new BigDecimal(0);
				psDet.setBigDecimal(5, subtotal);
				
				if(det.getProducto().isTieneIva() == true) {
					subtotalIva = subtotal.multiply(new BigDecimal(1.14));
					psDet.setBigDecimal(6, subtotalIva);
				}else {
					subtotalIva = subtotal;
					psDet.setBigDecimal(6, subtotalIva);
				}


				psDet.executeUpdate();

				//Actualizar Cabecera 
				BigDecimal totalSin = new BigDecimal(0);
				BigDecimal iva = new BigDecimal(0);
				BigDecimal total = new BigDecimal(0);
				
				totalSin = totalSin.add(det.getProducto().getPrecioVenta());
				
				
				if(det.getProducto().isTieneIva()==true) {
					iva = iva.add(det.getProducto().getPrecioVenta().multiply(new BigDecimal(1.14)));
					total = total.add(det.getProducto().getPrecioVenta().multiply(new BigDecimal(1.14)));
				}else {
					total = total.add(det.getProducto().getPrecioVenta());
				}
				
				psCab = con.prepareStatement("update cabecera_ventas "
						+ "set total_sin=?, iva=?, total=? "
						+ "where codigo=?");
				psCab.setBigDecimal(1, totalSin);
				psCab.setBigDecimal(2, iva);
				psCab.setBigDecimal(3, total);
				psCab.setInt(4, codigoCabecera);
				
				psCab.executeUpdate();
				
				//Registrar movimiento Stock
				psStock = con.prepareStatement("insert into historial_stock(fecha,referencia,producto,cantidad) "
						+ "values(?,?,?,?);");
				psStock.setTimestamp(1,fechaHoraActual);
				psStock.setString(2,"Venta " + codigoCabecera);
				psStock.setInt(3, det.getProducto().getCodigo());
				psStock.setInt(4,det.getCantidad()*(-1));
				
				psStock.executeUpdate();
				
			}

			System.out.println("CODIGO GENERADO>>>>> " + codigoCabecera);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar el Venta Detalles: " + e.getMessage());
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
}
