package Vista;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import Modelo.ConexionBaseDatos;
import Modelo.Productos;

import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.SystemColor;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.List;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JTable;
import java.io.File;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

/**
 * Declaracion clase Productos extendida JFrame
 * Clase Productos
 * @author Fernando
 *
 */


public class MarcoPrincipal extends JFrame {

	public JFrame frmComercialLaRojita;
	public JComboBox comboBox;
	public JTable table;
	public JTable table_1;
	public JTabbedPane tabbedPane;
	
	public JTextField txtId;
	public JTextField txtNombre;
	public JTextField txtStock;
	public JTextField txtValorProducto;
	
	public JButton btnNewButton;
	public JButton btnNewButton_1;
	public JButton btnNewButton_2;
	public JButton btnNewButton_3;
	public JButton btnNewButton_4;
	public JButton btnNewButton_5;
	public JButton Exportar;
	public JButton Importar;
	
	public JLabel lblNewLabel_2;
	public JLabel lblValorProducto;
	public JLabel lblSeRecomiendaUtilizar;
	public JLabel lblPesos;
	public JLabel lblStock;
	public JLabel lblNewLabel_5;
	public JLabel lblNewLabel_6;
	public JLabel lblNewLabel_9;
	public JLabel lblNewLabel;
	public JLabel lblNewLabel_1;
	public JLabel lblNewLabel_8;
	public JLabel lblNewLabel_10;
	public JLabel lblNewLabel_11;
	public JLabel lblNewLabel_12 ;
	public JLabel lblNewLabel_13;
	public JLabel lblNewLabel_14;
	public JLabel lblNewLabel_15;
	public JLabel lblNewLabel_16;
	
	public JPanel panel1;
	public JPanel Registro;
	public JPanel panel2;
	public JPanel ProductosInventario;
	public JPanel contentPane;
	public JPanel panel_1;
	public JPanel panel_2;
	public JPanel panel3;
	public JPanel panel;
	public JPanel panel_3;
	public JPanel panel_4;
	
	public String name;
	public JEditorPane dtrpnControlDeInventariominimarket;
	public JEditorPane dtrpnLaRojitaDe;
	
	Connection conexion = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	
	private JScrollPane scrollPane;
	
	public void limpiarCuadrosDeTexto() {
		
		txtId.setText(null);
		txtNombre.setText(null);
		txtValorProducto.setText(null);
		txtStock.setText(null);
		
		
}
	
	
	public void CrearTabla() {
		
		conexion = ConexionBaseDatos.conectar();
		String sql = "SELECT Nom_Producto,Codigo_Producto,Tipo_Producto,Valor_Producto,Stock FROM inventario";
		Statement st;
		DefaultTableModel model = new DefaultTableModel();
		
		
		model.addColumn("Nombre Producto");
		model.addColumn("Codigo Producto");
		model.addColumn("Tipo Producto");
		model.addColumn("Valor Producto");
		model.addColumn("Stock");
		
		
		ProductosInventario.removeAll();
		ProductosInventario.revalidate();
		ProductosInventario.repaint();
		
		panel_3 = new JPanel();
		ProductosInventario.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		table = new JTable(); 
		table.setBackground(Color.LIGHT_GRAY);
		panel_3.add(table);
		table.setModel(model);
		
		
		scrollPane = new JScrollPane(table);
		panel_3.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(javax.swing.JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			
		String[] dato = new String[5];
		try {
			st = conexion.createStatement();
			ResultSet result = st.executeQuery(sql);
			
			while(result.next()) {
				dato[0]=result.getString(1);
				dato[1]=result.getString(2);
				dato[2]=result.getString(3);
				dato[3]=result.getString(4);
				dato[4]=result.getString(5);
				
				
				model.addRow(dato);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
	}
	
	public MarcoPrincipal() {
		
		initialize();
		CrearTabla();

	}
		
		
		public void initialize() {
			frmComercialLaRojita = new JFrame();
			frmComercialLaRojita.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
			frmComercialLaRojita.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmComercialLaRojita.setTitle("Comercial La Rojita");
			frmComercialLaRojita.setForeground(SystemColor.activeCaption);
			frmComercialLaRojita.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
			frmComercialLaRojita.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fernando\\Desktop\\LaRojitaSwing\\src\\Vista\\logo.jpg"));
			frmComercialLaRojita.setType(Type.POPUP);
			frmComercialLaRojita.setBounds(100, 100, 671, 536);
			frmComercialLaRojita.setResizable(true);
			//frmComercialLaRojita.setExtendedState(6);
			
			frmComercialLaRojita.setLocationRelativeTo(null);
			frmComercialLaRojita.getContentPane().setLayout(null);
			
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			tabbedPane.setBackground(Color.LIGHT_GRAY);
			tabbedPane.setBounds(0, 0, 702, 507);
			frmComercialLaRojita.getContentPane().add(tabbedPane);
			
			panel1 = new JPanel();
			panel1.setBackground(Color.LIGHT_GRAY);
			tabbedPane.addTab("Registro", null, panel1, null);
			panel1.setLayout(null);
			
			Registro = new JPanel();
			Registro.setBounds(10, 11, 646, 448);
			Registro.setBackground(SystemColor.activeCaption);
			Registro.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Registro Productos", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel1.add(Registro);
			Registro.setLayout(null);
			
			btnNewButton = new JButton("Agregar");
			btnNewButton.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
			btnNewButton.setBounds(344, 278, 101, 23);
			Registro.add(btnNewButton);
			
			lblNewLabel = new JLabel("Codigo Producto:");
			lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblNewLabel.setBounds(40, 125, 123, 14);
			Registro.add(lblNewLabel);
			
			lblNewLabel_1 = new JLabel("Nombre Producto:");
			lblNewLabel_1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(33, 69, 130, 14);
			Registro.add(lblNewLabel_1);
			
			txtId = new JTextField();
			txtId.setBounds(163, 123, 86, 20);
			Registro.add(txtId);
			txtId.setColumns(10);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(163, 67, 86, 20);
			Registro.add(txtNombre);
			txtNombre.setColumns(10);
			
			btnNewButton_1 = new JButton("Modificar");
			btnNewButton_1.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
			btnNewButton_1.setBounds(481, 278, 101, 23);
			Registro.add(btnNewButton_1);
			
			btnNewButton_2 = new JButton("Borrar");
			btnNewButton_2.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
			btnNewButton_2.setBounds(481, 317, 101, 23);
			Registro.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Buscar");
			btnNewButton_3.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
			btnNewButton_3.setBounds(344, 317, 101, 23);
			Registro.add(btnNewButton_3);
			
			btnNewButton_4 = new JButton("Salir");
			btnNewButton_4.setFont(new Font("Showcard Gothic", Font.PLAIN, 11));
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnNewButton_4.setBounds(527, 397, 71, 23);
			Registro.add(btnNewButton_4);
			
			lblNewLabel_2 = new JLabel("Tipo Producto:");
			lblNewLabel_2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(314, 69, 116, 14);
			Registro.add(lblNewLabel_2);
			
			lblValorProducto = new JLabel("Valor Producto:");
			lblValorProducto.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblValorProducto.setBounds(52, 175, 107, 14);
			Registro.add(lblValorProducto);
			
			txtValorProducto = new JTextField();
			txtValorProducto.setBounds(163, 173, 86, 20);
			Registro.add(txtValorProducto);
			txtValorProducto.setColumns(10);
			
			comboBox = new JComboBox();
			comboBox.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Selecciona ", "Bebestibles", "Helados", "Art.Librer\u00EDa", "Abarrotes"}));
			comboBox.setBounds(420, 67, 101, 20);
			Registro.add(comboBox);
			
			lblSeRecomiendaUtilizar = new JLabel("Utilizar el Nombre de los productos para:\r\n");
			lblSeRecomiendaUtilizar.setFont(new Font("Stencil", Font.PLAIN, 14));
			lblSeRecomiendaUtilizar.setBounds(24, 361, 326, 31);
			Registro.add(lblSeRecomiendaUtilizar);
			
			lblPesos = new JLabel("(Pesos)");
			lblPesos.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblPesos.setBounds(251, 175, 59, 14);
			Registro.add(lblPesos);
			
			lblStock = new JLabel("Stock:");
			lblStock.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 15));
			lblStock.setBounds(117, 231, 46, 14);
			Registro.add(lblStock);
			
			txtStock = new JTextField();
			txtStock.setBounds(163, 229, 86, 20);
			Registro.add(txtStock);
			txtStock.setColumns(10);
			
			lblNewLabel_5 = new JLabel("\u00A1Atenci\u00F3n!");
			lblNewLabel_5.setFont(new Font("Ravie", Font.PLAIN, 11));
			lblNewLabel_5.setBounds(24, 349, 86, 14);
			Registro.add(lblNewLabel_5);
			
			lblNewLabel_6 = new JLabel("Modificar, Buscar y Borrar");
			lblNewLabel_6.setFont(new Font("Stencil", Font.PLAIN, 14));
			lblNewLabel_6.setBounds(24, 386, 304, 14);
			Registro.add(lblNewLabel_6);
			
			lblNewLabel_8 = new JLabel("Bebestibles  ->\r\n");
			lblNewLabel_8.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel_8.setBounds(497, 162, 101, 14);
			Registro.add(lblNewLabel_8);
			
			lblNewLabel_10 = new JLabel("Helados       ->\r\n");
			lblNewLabel_10.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel_10.setBounds(497, 187, 101, 14);
			Registro.add(lblNewLabel_10);
			
			lblNewLabel_11 = new JLabel("Art. Librer\u00EDa  ->\r\n");
			lblNewLabel_11.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel_11.setBounds(497, 212, 101, 14);
			Registro.add(lblNewLabel_11);
			
			lblNewLabel_12 = new JLabel("Abarrotes     ->");
			lblNewLabel_12.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			lblNewLabel_12.setBounds(497, 237, 101, 14);
			Registro.add(lblNewLabel_12);
			
			lblNewLabel_13 = new JLabel("101");
			lblNewLabel_13.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
			lblNewLabel_13.setBounds(604, 162, 32, 14);
			Registro.add(lblNewLabel_13);
			
			lblNewLabel_14 = new JLabel("102");
			lblNewLabel_14.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
			lblNewLabel_14.setBounds(604, 187, 32, 14);
			Registro.add(lblNewLabel_14);
			
			lblNewLabel_15 = new JLabel("103");
			lblNewLabel_15.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
			lblNewLabel_15.setBounds(604, 212, 32, 14);
			Registro.add(lblNewLabel_15);
			
			lblNewLabel_16 = new JLabel("104\r\n");
			lblNewLabel_16.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 11));
			lblNewLabel_16.setBounds(604, 235, 32, 14);
			Registro.add(lblNewLabel_16);
			
			panel2 = new JPanel();
			panel2.setBackground(Color.LIGHT_GRAY);
			tabbedPane.addTab("Productos", null, panel2, null);
			panel2.setLayout(null);
			
			ProductosInventario = new JPanel();
			ProductosInventario.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Productos en Inventario", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			ProductosInventario.setBackground(SystemColor.activeCaption);
			ProductosInventario.setBounds(0, 0, 664, 470);
			panel2.add(ProductosInventario);
			
			panel3 = new JPanel();
			panel3.setToolTipText("");
			panel3.setBackground(Color.LIGHT_GRAY);
			tabbedPane.addTab("Acerca de", null, panel3, null);
			panel3.setLayout(null);
			
			panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(SystemColor.activeCaption);
			panel.setBounds(10, 11, 646, 448);
			panel3.add(panel);
			panel.setLayout(null);
		
			
			lblNewLabel_9 = new JLabel("New label");
			lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Fernando\\Desktop\\logogogog.png"));
			lblNewLabel_9.setBounds(371, 195, 265, 253);
			panel.add(lblNewLabel_9);
			
			btnNewButton_5 = new JButton("Probar Conexi\u00F3n Base de Datos");
			btnNewButton_5.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Conexion exitosa");
					ConexionBaseDatos con = new ConexionBaseDatos();
					
				}
			});
			btnNewButton_5.setBounds(389, 139, 233, 23);
			panel.add(btnNewButton_5);
			
			panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(10, 229, 351, 194);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			dtrpnControlDeInventariominimarket = new JEditorPane();
			dtrpnControlDeInventariominimarket.setBounds(10, 11, 331, 175);
			panel_1.add(dtrpnControlDeInventariominimarket);
			dtrpnControlDeInventariominimarket.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
			dtrpnControlDeInventariominimarket.setText("Control de Inventario-Minimarket La Rojita\r\n.Creado por Fernando L\u00F3pez C.\r\n.Para Dise\u00F1o y An\u00E1lisis de Algoritmos\r\n.Fecha 24-04-19\r\n.Version 1.2\r\n.Librerias Utilizadas MySqlConnector-poi-4.1-jxl-2.6-JUnit\r\n.Software Necesario MySQL - Eclipse\r\n.jdbc:mysql://localhost:3306/inventario pass:-voodoo18");

			panel_4 = new JPanel();
			panel_4.setBackground(Color.LIGHT_GRAY);
			panel_4.setBounds(10, 52, 369, 143);
			panel.add(panel_4);
			panel_4.setLayout(null);
			
			dtrpnLaRojitaDe = new JEditorPane();
			dtrpnLaRojitaDe.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 11));
			dtrpnLaRojitaDe.setBounds(10, 11, 349, 120);
			dtrpnLaRojitaDe.setText("La Rojita de Ovalle:\r\nEmpresa ovallina con la misi\u00F3n de servir a nuestr@s clientes en las buenas y en las malas. A toda hora con botiller\u00EDa, comidas al paso y minimarket.\r\nhttps://www.facebook.com/larojitaovalle/\r\nhttps://www.instagram.com/larojitadeovalle/?hl=es-la");
			panel_4.add(dtrpnLaRojitaDe);
			
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {	
					JOptionPane.showMessageDialog(null,"¡Productos Guardados!", "¡Gracias por su visita!", JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);	
					}	
				}
			);
			
			Exportar = new JButton("Exportar Productos\r\n");
			Exportar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			Exportar.setBounds(420, 52, 171, 23);
			panel.add(Exportar);
			
			Importar = new JButton("Importar Productos\r\n");
			Importar.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 13));
			Importar.setBounds(420, 94, 171, 23);
			panel.add(Importar);
			
			

			


		}
	}

