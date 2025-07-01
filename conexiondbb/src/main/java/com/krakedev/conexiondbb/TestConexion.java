package com.krakedev.conexiondbb;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {
	public static void main(String[] args) {
		Connection conecction  = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conecction = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","bpg2000");
			System.out.println("conexion exitosa");
			
			ps = conecction.prepareStatement("insert into personas (cedula,nombre,apellido,estado_civil_codigo,numero_hijos,estatura,cantidad_ahorrada,fecha_nacimiento,hora_nacimiento)"
					+ "	values (?,?,?,?,?,?,?,?,?)");
			ps.setString(1, "1709362162");
			ps.setString(2, "Patri");
			ps.setString(3, "Gutuna");
			ps.setString(4, "U");
			ps.setInt(5, 2);
			ps.setDouble(6, 1.56);
			ps.setBigDecimal(7, new BigDecimal(1200.45));
			
			//Insert para la tabla Compras
			PreparedStatement ps2 = conecction.prepareStatement("insert into compras (id_compra,cedula,fecha_compra,monto)"
					+ "values(?,?,?,?)");
			
			ps2.setInt(1, 610);
			ps2.setString(2, "1725914236");
			ps2.setBigDecimal(4, new BigDecimal(3.2));
			
			PreparedStatement ps3 = conecction.prepareStatement("insert into cuentas (numero_cuenta,cedula_propietario,fecha_creacion,saldo)"
					+ "values (?,?,?,?)");
			
			ps3.setString(1, "86723");
			ps3.setString(2, "61237");
			ps3.setBigDecimal(4,new BigDecimal(3900.90));
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr = "2020/03/22 10:05:04";
			try {
				Date fecha = sdf.parse(fechaStr);
				System.out.println(fecha);
				long fechaMilis = fecha.getTime();
				System.out.println(fechaMilis);
				//Crea un java.saqlDate, partiendo de un java.util.Date
				java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);
						
				System.out.println(fechaSQL);
				
				Time timeSQL = new Time(fechaMilis);
				System.out.println(timeSQL);
				
				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSQL);
				//fecha del ingreso en la tabla compras
				ps2.setDate(3, fechaSQL);
				//fecha para la tabla cuentas
				ps3.setDate(3, fechaSQL);
				
				ps.executeUpdate();
				ps2.executeUpdate();
				ps3.executeUpdate();
				System.out.println("ejecuta insert");
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
