package com.krakedev.inventario.bbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.Proveedor;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;



public class ProveedoresBDD {
	
	
	public ArrayList<Proveedor> buscar(String subcadena) throws KrakeDevException {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proveedor proveedor = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select identificador,tipo_doc,nombre,telefono,correo,direccion "
					+ "from proveedores "
					+ "where upper(nombre) like ?");
			
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String identificador = rs.getString("identificador");
				String tipoDoc = rs.getString("tipo_doc");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				proveedor = new Proveedor(identificador,tipoDoc, nombre,telefono,correo,direccion);
				proveedores.add(proveedor);

			}

		} catch (KrakeDevException e) {

			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. detalle: " + e.getMessage());
		}

		return proveedores;
	}
}
