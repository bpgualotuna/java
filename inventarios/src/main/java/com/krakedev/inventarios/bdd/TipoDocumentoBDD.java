package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoDocumentoBDD {
	
	
	public ArrayList<TipoDocumento> recuperar(String subcadena) throws KrakeDevException {
		ArrayList<TipoDocumento> documentos = new ArrayList<TipoDocumento>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TipoDocumento documento = null;

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select codigo, descripcion "
					+ "from tipo_documento "
					+ "where upper(descripcion) like ?");
			
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String codigo = rs.getString("codigo");
				String descripcion = rs.getString("descripcion");
				
				documento = new TipoDocumento(codigo,descripcion);
				documentos.add(documento);

			}

		} catch (KrakeDevException e) {

			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. detalle: " + e.getMessage());
		}

		return documentos;
	}
}
