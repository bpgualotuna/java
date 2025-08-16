package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriaBDD {
	
	public void crear(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		
		try {
			
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = null;
			
			if(categoria.getCategoriaPadre()==null) {
				ps = con.prepareStatement("insert into categorias(nombre) "
						+ "values(?)");
				ps.setString(1, categoria.getNombre());
				ps.executeUpdate();
			}else {
				ps = con.prepareStatement("insert into categorias(nombre,categoria_padre) "
						+ "values(?,?)");
				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
				ps.executeUpdate();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new KrakeDevException("Error al crear Categoria");
		}
		
		
	}
	
	
	public void actualizar(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		
		try {
			
			con = ConexionBDD.obtenerConexion();
			PreparedStatement ps = null;
			
			if(categoria.getCategoriaPadre()==null) {
				ps = con.prepareStatement("update categorias "
						+ "set nombre=? "
						+ "where codigo_cat=?");
				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCodigo());
				ps.executeUpdate();
			}else {
				ps = con.prepareStatement("update categorias "
						+ "set nombre=?,categoria_padre=? "
						+ "where codigo_cat=?");
				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
				ps.setInt(3, categoria.getCodigo());
				ps.executeUpdate();
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new KrakeDevException("Error al crear Categoria");
		}
		
		
	}
	
	
	public ArrayList<Categoria> recuperar() throws KrakeDevException {
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from categorias");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigoCat = rs.getInt("codigo_cat");
				String nombre = rs.getString("nombre");
				int categoriaPadre = rs.getInt("categoria_padre");
				
				if(categoriaPadre == 0) {
					Categoria categoria = new Categoria();
					Categoria categoriaP = new Categoria();
					categoria.setCodigo(codigoCat);
					categoria.setNombre(nombre);
					categoria.setCategoriaPadre(categoriaP);
					
					categorias.add(categoria);
				}else {
					Categoria categoria = new Categoria();
					Categoria categoriaP = new Categoria(categoriaPadre);
					categoria.setCodigo(codigoCat);
					categoria.setNombre(nombre);
					
					categoria.setCategoriaPadre(categoriaP);
					
					categorias.add(categoria);
				}
				
				
			}
			
			
			
		} catch (KrakeDevException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. detalle: " + e.getMessage());
		}
		
		return categorias;
		
	}
	
}
