package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

public class AdminPersonas {
	
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);
	
	public static void eliminar(String cedE) throws Exception {
		
		Connection con = null;
		PreparedStatement ps;
		
		LOGGER.trace("Eliminando cedula: " + cedE);
		
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("delete from personas where cedula=?");
			ps.setString(1,cedE);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			LOGGER.error("Error al eliminar",e);
			throw new Exception("Error al eliminar");
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				LOGGER.error("Error en la base de datos",e2);
				throw new Exception("error con la base de datos");
			}
		}
	}
	
	public static void actualizar(Persona persona) throws Exception{
		Connection con = null;
		PreparedStatement ps;
		
		LOGGER.trace("Persona a actualizar" + persona);
		
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("update personas set nombre=?,apellido=?,estatura=?,fecha_nacimiento=?,hora_nacimiento=?,cantidad_ahorrada=?,numero_hijos=?,estado_civil_codigo=? where cedula=?");
			ps.setString(1,persona.getNombre());
			ps.setString(2,persona.getApellido());
			ps.setDouble(3,persona.getEstatura());
			ps.setDate(4,new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(5,new Time(persona.getHoraNacimiento().getTime()));
			ps.setBigDecimal(6,persona.getCantidadAhorrada());
			ps.setInt(7,persona.getNumeroHijos());
			ps.setString(8,persona.getEstadoCivil().getCodigo());
			ps.setString(9,persona.getCedula());
			
			ps.executeUpdate();
			
			
		} catch (Exception e) {
			
			LOGGER.error("Error al actualizar",e);
			throw new Exception("Error al actualizar");
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				// TODO: handle exception
				LOGGER.error("Error en la base de datos",e2);
				throw new Exception("error con la base de datos");
			}
		}
	}

	public static void insertar(Persona persona) throws Exception {

		
		
		/**
		 * Connection con = null;
		 * 
		 * try { //Abrir la coneccion con = ConexionBDD.conectar();
		 * System.out.println("insertar");
		 * 
		 * }catch (Exception e) { //Mostrart el error al usuario
		 * System.out.println(e.getMessage()); //Loggear el error e.printStackTrace();
		 * 
		 * }finally { //Cerrar la conexion try { con.close(); } catch (SQLException e) {
		 * // TODO Auto-generated catch block e.printStackTrace();
		 * System.out.println("Error de infraestructura"); } }
		 **/
		Connection con = null;
		PreparedStatement ps;
		
		LOGGER.trace("Persona a insertar" + persona);
		
		try {
			con = ConexionBDD.conectar();
			
			ps = con.prepareStatement("insert into personas (cedula,nombre,apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimiento)"
					+ "	values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5, persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new Time(persona.getHoraNacimiento().getTime()));
			
			ps.executeUpdate();
			
			
			
			
			
			
		} catch (Exception e) {
			
			LOGGER.error("Error al insertar",e);
			throw new Exception("Error al insertar");
		}finally {
			//Cerrar la conexion
			try{
				con.close();
			}catch (SQLException e) {
				LOGGER.error("Error en la base de datos",e);
				throw new Exception("error con la base de datos");
			}
		}
		
	}

}
