package Modelo;


import java.sql.*;

import javax.swing.JOptionPane;


public class ConexionBaseDatos {

	private static final String url = "jdbc:mysql://localhost:3306/inventario";
	private static final String username = "root";
	private static final String password = "-voodoo18";
	
	public static Connection conectar() {
		Connection conexion = null;
		try {
			
			conexion=DriverManager.getConnection(url,username,password);
			//JOptionPane.showMessageDialog(null, "Conexion exitosa");
			
		}catch(SQLException e) {
			System.out.println("Ocurrio un error al conectar con la base de datos"+e.getMessage());
			return null;
		}
		return conexion;
	}
}
