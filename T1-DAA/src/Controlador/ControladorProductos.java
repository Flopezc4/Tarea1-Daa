package Controlador;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.ConexionBaseDatos;
import Modelo.ExcelOperaciones;
import Modelo.Productos;
import Vista.MarcoPrincipal;



public class ControladorProductos implements ActionListener {

	private Productos p ;
	private CRUDOperaciones crud;
	private MarcoPrincipal frame;
	private ExcelOperaciones excel;
	
	
	public ControladorProductos(Productos p, CRUDOperaciones crud, MarcoPrincipal frame,ExcelOperaciones excel) {

		//super();
		this.p = p;
		this.crud = crud;
		this.frame = frame;
		this.excel=excel;
		
		this.frame.btnNewButton.addActionListener(this);
		this.frame.btnNewButton_1.addActionListener(this);
		this.frame.btnNewButton_2.addActionListener(this);
		this.frame.btnNewButton_3.addActionListener(this);
		this.frame.btnNewButton_4.addActionListener(this);
		this.frame.btnNewButton_5.addActionListener(this);
		this.frame.Exportar.addActionListener(this);
		this.frame.Importar.addActionListener(this);
	}


	public void limpiarCuadrosDeTexto() {
		
		frame.txtId.setText(null);
		frame.txtNombre.setText(null);
		frame.txtValorProducto.setText(null);
		frame.txtStock.setText(null);
		
}
	
	
	public void actualizartabla() {
		frame.CrearTabla();
	}
	
	@Override
	
	public void actionPerformed(ActionEvent escuchador) {
		

		if(escuchador.getSource()==frame.btnNewButton) {
			
			p.setNom_Producto(frame.txtNombre.getText());
			p.setCodigo_Producto(Integer.parseInt(frame.txtId.getText()));
			p.setTipo_Producto(frame.comboBox.getSelectedItem().toString());
			p.setValor_Producto(Integer.parseInt(frame.txtValorProducto.getText()));
			
			
			crud.Agregar(p);
			frame.limpiarCuadrosDeTexto();
			frame.CrearTabla();
		
		
		}
		if(escuchador.getSource()==frame.btnNewButton_1) {
			
			p.setNom_Producto(frame.txtNombre.getText());
			p.setCodigo_Producto(Integer.parseInt(frame.txtId.getText()));
			p.setTipo_Producto(frame.comboBox.getSelectedItem().toString());
			p.setValor_Producto(Integer.parseInt(frame.txtValorProducto.getText()));
			
			
			crud.Modificar(p);
			frame.limpiarCuadrosDeTexto();
			frame.CrearTabla();
		
		
		}
		
		if(escuchador.getSource()==frame.btnNewButton_2) {
			
			p.setNom_Producto(frame.txtNombre.getText());

			
			crud.Eliminar(p);
			frame.limpiarCuadrosDeTexto();
			frame.CrearTabla();
		
		
		}
		if(escuchador.getSource()==frame.btnNewButton_3) {
			
			p.setNom_Producto(frame.txtNombre.getText());
			
			crud.Buscar(p);
			frame.txtNombre.setText(p.getNom_Producto());
			frame.txtId.setText(Integer.toString(p.getCodigo_Producto()));
			frame.txtValorProducto.setText(Integer.toString(p.getValor_Producto()));
			frame.txtStock.setText(Integer.toString(p.getStock()));
			frame.comboBox.setToolTipText(p.getTipo_Producto());
			
		
		
		}
		
		if(escuchador.getSource()==frame.Exportar) {
			
			
			try {
				excel.exportarExcel();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			
		}
		if(escuchador.getSource()==frame.Importar) {
			
			ArrayList<Productos> lista = new ArrayList<>();
			JFileChooser examinar = new JFileChooser(); 
			examinar.setFileFilter(new FileNameExtensionFilter("Archivos excel","xlsx"));
			int opcion = examinar.showOpenDialog(frame);
			File archivoExcel=null;
			
			if(opcion==JFileChooser.APPROVE_OPTION) {
				System.out.println("Se ha encontrado Fichero");
				archivoExcel = examinar.getSelectedFile();	
				
				try {
					lista = excel.ImportarExcel(archivoExcel);
					for(int i=0;i<lista.size();i++) {
						p=lista.get(i);
						crud.Agregar(p);
						frame.CrearTabla();
						
					}
					JOptionPane.showMessageDialog(frame, "Se importo correctamente");
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}
			
			
			
		}
	}
	
}
