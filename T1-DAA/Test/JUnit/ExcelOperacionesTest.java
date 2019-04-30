package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class ExcelOperacionesTest {

		Productos productos = new Productos("EliminarTest","Tipo Producto",10,10,10);
	@Test
	public void testExportarExcel() {
		
		ExcelOperacionesTest prueba = new ExcelOperacionesTest();
		
		
		//assertEquals(true,prueba.excelOperaciones(productos) );
		//assertTrue(true,prueba.testExportarExcel(productos);
	}

}
