package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class BuscarTest {

		Productos productos = new Productos("BuscarTest","Tipo Producto",10,10,10);
	@Test
	public void testBuscar() {
		
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		//assertEquals(1,prueba.Agregar(productos) );
		assertEquals(1, prueba.Buscar(productos));
	}

}
