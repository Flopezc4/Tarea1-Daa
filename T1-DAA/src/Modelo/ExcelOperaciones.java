package Modelo;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JTable;



public class ExcelOperaciones{
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Productos p = null;
	
	private ArrayList<Productos> lista2;
	/*public static void crearExcel() {
		
		
	       HSSFWorkbook book = new HSSFWorkbook();
	       HSSFSheet sheet = book.createSheet("Hola Java");
	       Row fila;
	       Row row = sheet.createRow(0);
	       row.createCell(0).setCellValue("Hola");
	       
	       
		try{
			FileOutputStream fileout = new FileOutputStream("Excel.xls");
			book.write(fileout);
			fileout.close();
		}catch(FileNotFoundException ex) {
			Logger.getLogger(Excel.class.getName()).log(Level.SEVERE,null,ex);
		}catch (IOException ex) {
			Logger.getLogger(Excel.class.getName()).log(Level.SEVERE,null,ex);
		}
	}*/

	
	public ArrayList<Productos> ImportarExcel(File archivoExcel) throws IOException{
		
		Productos pro;
		lista2 = new ArrayList<>();
		try {
			FileInputStream archivo = new FileInputStream(archivoExcel);
			XSSFWorkbook libro = new XSSFWorkbook(archivo);
			XSSFSheet hoja = libro.getSheetAt(0);
			Iterator<Row> itr = hoja.iterator();
			Row fila;
			while(itr.hasNext()) {
				
				fila=itr.next();
				pro = new Productos();

				pro.setNom_Producto(fila.getCell(0).getStringCellValue());
				pro.setCodigo_Producto((int)fila.getCell(1).getNumericCellValue());
				pro.setTipo_Producto(fila.getCell(2).getStringCellValue());
				pro.setValor_Producto((int)fila.getCell(3).getNumericCellValue());
				pro.setStock((int)fila.getCell(4).getNumericCellValue());
				lista2.add(pro);
				
			}
			return lista2;
		}catch (FileNotFoundException ex) {
			
			ex.printStackTrace();
			lista2=null;
		}finally {
			return lista2;
			
			
		}
	}
	
	
	
	
	
	
	public boolean exportarExcel() throws SQLException {

		ArrayList<Productos> lista = getAll();
		XSSFWorkbook libro = new XSSFWorkbook();
		Sheet hoja = libro.createSheet("nuevo");

		for (int i = 0; i < lista.size(); i++) {
			p = lista.get(i);
			
			Row fila = hoja.createRow(i);
			fila.createCell(0).setCellValue(p.getNom_Producto());
			fila.createCell(1).setCellValue(p.getCodigo_Producto());
			fila.createCell(2).setCellValue(p.getTipo_Producto());
			fila.createCell(3).setCellValue(p.getValor_Producto());
			fila.createCell(4).setCellValue(p.getStock());
		}

		try {
			FileOutputStream archivo = new FileOutputStream("Tabla Productos.xlsx");
			libro.write(archivo);
			archivo.close();
			System.out.println("Se exporto los productos correctamente");
			return true;
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;

		}
	}

	public ArrayList<Productos> getAll() {
		lista2 = new ArrayList<>();

		conexion = ConexionBaseDatos.conectar();
		try {
			preparedStatement = conexion.prepareStatement("Select * from inventario ");

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				p = new Productos();
				p.setNom_Producto(resultSet.getString("Nom_Producto"));
				p.setCodigo_Producto(Integer.parseInt(resultSet.getString("Codigo_Producto")));
				p.setTipo_Producto(resultSet.getString("Tipo_Producto"));
				p.setValor_Producto(Integer.parseInt(resultSet.getString("Valor_Producto")));
				p.setStock(Integer.parseInt(resultSet.getString("Stock")));
				lista2.add(p);
			}

			conexion.close();

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos");
			return null;
		} finally {
			return lista2;
		}
	}

}


