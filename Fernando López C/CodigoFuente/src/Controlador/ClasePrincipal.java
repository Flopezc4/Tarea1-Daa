package Controlador;

import Modelo.CRUDOperaciones;
import Modelo.ExcelOperaciones;
import Modelo.Productos;
import Vista.MarcoPrincipal;

public class ClasePrincipal {

	public static void main(String[] args) {
		
		Productos p = new Productos();
		CRUDOperaciones crud = new CRUDOperaciones();
		ExcelOperaciones excel = new ExcelOperaciones();
		MarcoPrincipal vista = new MarcoPrincipal();
		vista.frmComercialLaRojita.setVisible(true);
		ControladorProductos con = new ControladorProductos(p, crud, vista,excel);
		

	}

}
