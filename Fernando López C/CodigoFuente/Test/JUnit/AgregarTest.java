package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class AgregarTest {

		Productos productos = new Productos("AgregarTest","Tipo Producto",10,10,10);
	@Test
	public void testAgregar() {
		
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		assertEquals(1,prueba.Agregar(productos) );
	}

}
