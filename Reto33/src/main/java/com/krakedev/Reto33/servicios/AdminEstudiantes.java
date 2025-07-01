package com.krakedev.Reto33.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.Reto33.entidades.Estudiantes;
import com.krakedev.Reto33.utils.ConexionBDD;


public class AdminEstudiantes {

	private static final Logger LOGGER = LogManager.getLogger(AdminEstudiantes.class);

	public static void eliminar(String cedE) throws Exception {

		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Eliminando cedula: " + cedE);

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("delete from estudiantes where cedula=?");
			ps.setString(1, cedE);
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

	public static void actualizar(Estudiantes estudiante) throws Exception {
		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Persona a actualizar" + estudiante);

		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement(
					"update estudiantes set nombre=?,apellido=?,email=?,fecha_nacimiento=?,codigo_profesor=? where cedula=?");
			ps.setString(1, estudiante.getNombre());
			ps.setString(2, estudiante.getApellido());
			ps.setString(3, estudiante.getEmail());
			ps.setDate(4, new java.sql.Date(estudiante.getFecha_nacimiento().getTime()));
			ps.setInt(5, estudiante.getCodigo_profesor());
			ps.setString(6, estudiante.getCedula());

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

	public static void insertar(Estudiantes estudiante) throws Exception {

		
		Connection con = null;
		PreparedStatement ps;

		LOGGER.trace("Persona a insertar" + estudiante);

		try {
			con = ConexionBDD.conectar();

			ps = con.prepareStatement(
					"insert into estudiantes (cedula,nombre,apellido,email,fecha_nacimiento,codigo_profesor)"
							+ "	values (?,?,?,?,?,?)");
			ps.setString(1, estudiante.getCedula());
			ps.setString(2, estudiante.getNombre());
			ps.setString(3, estudiante.getApellido());
			ps.setString(4, estudiante.getEmail());
			ps.setDate(5,new java.sql.Date(estudiante.getFecha_nacimiento().getTime()) );
			ps.setDouble(6, estudiante.getCodigo_profesor());

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
