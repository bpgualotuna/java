package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadDeMedida;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductosBDD {

	public ArrayList<Producto> buscar(String subcadena) throws KrakeDevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_prod, prod.nombre as nombre_producto, "
					+ "udm.nombre as nombre_udm,udm.descripcion as descripcion_udm, "
					+ "cast(prod.precio_venta as decimal(6,2)),prod.tiene_iva,cast(prod.coste as decimal(5,4)), "
					+ "prod.categoria,cat.nombre as nombre_categoria, " + "stock "
					+ "from productos prod,unidades_medida udm,categorias cat " + "where prod.udm = udm.nombre "
					+ "and prod.categoria = cat.codigo_cat " + "and upper(prod.nombre) like ?");

			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigoProd = rs.getInt("codigo_prod");
				String nombreProd = rs.getString("nombre_producto");
				String nombreUdm = rs.getString("nombre_udm");
				String descripcionUdm = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				Boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int categoriaCod = rs.getInt("categoria");
				String nombreCat = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadDeMedida udm = new UnidadDeMedida();
				udm.setNombre(nombreUdm);
				udm.setDescripcion(descripcionUdm);

				Categoria categoria = new Categoria();
				categoria.setCodigo(categoriaCod);
				categoria.setNombre(nombreCat);

				producto = new Producto();
				producto.setCodigo(codigoProd);
				producto.setNombre(nombreProd);
				producto.setUnidadMedida(udm);
				producto.setPrecioVenta(precioVenta);
				producto.setTieneIva(tieneIva);
				producto.setCoste(coste);
				producto.setCategoria(categoria);
				producto.setStock(stock);

				productos.add(producto);

			}

		} catch (KrakeDevException e) {

			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. detalle: " + e.getMessage());
		}

		return productos;
	}

	public void crear(Producto producto) throws KrakeDevException {
		Connection con = null;

		try {
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = con.prepareStatement(
					"insert into productos(nombre,udm,precio_venta,tiene_iva,coste,categoria,stock) "
					+ "values(?,?,?,?,?,?,?)");
			
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidadMedida().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());

			ps.executeUpdate();
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

}
