package com.krakedev.Reto33.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.krakedev.Reto33.entidades.Videojuegos;
import com.krakedev.Reto33.utils.ConexionBDD;

public class AdminVideojuegos {
	private static final Logger LOGGER = LogManager.getLogger(AdminEstudiantes.class);

	public static void eliminar(int cod) throws Exception {

		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Eliminando cedula: " + cod);

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("delete from videojuegos where codigo=?");
			ps.setInt(1, cod);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				LOGGER.error("Error en la base de datos", e2);
				throw new Exception("error con la base de datos");
			}
		}
	}

	public static void actualizar(Videojuegos videojuegos) throws Exception {
		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Persona a actualizar" + videojuegos);

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"update videojuegos set nombre=?,descripcion=?,valoracion=? where cedula=?");
			ps.setString(1, videojuegos.getNombre());
			ps.setString(2, videojuegos.getDescripcion());
			ps.setInt(3, videojuegos.getValoracion());
			ps.setInt(4, videojuegos.getCodigo());

			ps.executeUpdate();

		} catch (Exception e) {

			LOGGER.error("Error al actualizar", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				LOGGER.error("Error en la base de datos", e2);
				throw new Exception("error con la base de datos");
			}
		}
	}

	public static void insertar(Videojuegos videojuegos) throws Exception {

		
		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Persona a insertar" + videojuegos);

		try {
			con = ConexionBDD.conectar();

			ps = con.prepareStatement(
					"insert into videojuegos (codigo,nombre,descripcion,valoracion)"
							+ "	values (?,?,?,?)");
			ps.setInt(1, videojuegos.getCodigo());
			ps.setString(2, videojuegos.getNombre());
			ps.setString(3, videojuegos.getDescripcion());
			ps.setInt(4, videojuegos.getValoracion());
			

			ps.executeUpdate();

		} catch (Exception e) {

			LOGGER.error("Error al insertar", e);
			throw new Exception("Error al insertar");
		} finally {
			// Cerrar la conexion
			try {
				con.close();
			} catch (SQLException e) {
				LOGGER.error("Error en la base de datos", e);
				throw new Exception("error con la base de datos");
			}
		}

	}
}
