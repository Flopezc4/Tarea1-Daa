package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import org.junit.Test;

public class CRUDOperaciones {

	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	public int Buscar(Productos p) {
		int resultado = 0;
		conexion = ConexionBaseDatos.conectar();
		try {
			preparedStatement = conexion.prepareStatement("Select Codigo_Producto , Tipo_Producto , Valor_Producto, Stock from inventario Where Nom_Producto= ?");
			
			preparedStatement.setString(1,p.getNom_Producto());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				p.setCodigo_Producto(Integer.parseInt(resultSet.getString("Codigo_Producto")));
				p.setTipo_Producto(resultSet.getString("Tipo_Producto"));
				p.setValor_Producto(Integer.parseInt(resultSet.getString("Valor_Producto")));
				p.setStock(Integer.parseInt(resultSet.getString("Stock")));
				
				
			}else {
				JOptionPane.showMessageDialog(null,"Nombre de producto no encontrado");
			}
			conexion.close();
		
	} catch(SQLException e1) {
		JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos");
	}
		finally {
			return resultado;
		}
}
	
	public int Eliminar(Productos p) {
		int resultado = 0;
		conexion = ConexionBaseDatos.conectar();
		try {
			preparedStatement = conexion.prepareStatement("DELETE FROM inventario Where Nom_Producto =?");
			
			preparedStatement.setString(1,p.getNom_Producto());
			
			resultado = preparedStatement.executeUpdate();
			if(resultado > 0) {
				JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
				conexion.close();
			}else {
				JOptionPane.showMessageDialog(null, "No se puede eliminar el registro");
			}
			
		}catch(SQLException e1) {
				JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos");
		}finally {
			return resultado;
		}
	}
	
	
	public int Modificar(Productos p) {
		int resultado = 0;
		conexion = ConexionBaseDatos.conectar();
		try {
			preparedStatement = conexion.prepareStatement("UPDATE inventario SET  Codigo_Producto = ?,Tipo_Producto=?,Valor_Producto=?, Stock = ? Where Nom_Producto = ?");
			
			preparedStatement.setInt(1,p.getCodigo_Producto());
			preparedStatement.setString(2,p.getTipo_Producto());
			preparedStatement.setInt(3,p.getValor_Producto());
			preparedStatement.setInt(4,p.getStock());
			preparedStatement.setString(5,p.getNom_Producto());
			
			resultado = preparedStatement.executeUpdate();
			if(resultado > 0) {
				JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
				conexion.close();
			}else {
				JOptionPane.showMessageDialog(null, "No se puede modificar el registro");
			}
			
		}catch(SQLException e1) {
				JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos");
		}finally {
			return resultado;
		}
		
	}
	
	
	public int Agregar(Productos p) {
		int resultado = 0;
		conexion = ConexionBaseDatos.conectar();
		try {
			
		
			preparedStatement = conexion.prepareStatement("Insert into inventario(Nom_Producto,Codigo_Producto,Tipo_Producto,Valor_Producto,Stock)values(?,?,?,?,?)");

			
			preparedStatement.setString(1,p.getNom_Producto());
			preparedStatement.setInt(2,p.getCodigo_Producto());
			preparedStatement.setString(3,p.getTipo_Producto());
			preparedStatement.setInt(4,p.getValor_Producto());
			preparedStatement.setInt(5,p.getStock());
			
			
			
			resultado = preparedStatement.executeUpdate();
			conexion.close();
			if(resultado > 0) {
				JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
				
				
			}else {
				JOptionPane.showMessageDialog(null, "No se puede agregar el registro");
			}
			
		}catch(SQLException e1) {
				JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos");
				
		}finally {
			return resultado;
		}
		
		
	}
	
}
