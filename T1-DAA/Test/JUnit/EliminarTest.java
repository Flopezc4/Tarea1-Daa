package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class EliminarTest {

		Productos productos = new Productos("EliminarTest","Tipo Producto",10,10,10);

	@Test
	public void testEliminar() {

		CRUDOperaciones prueba = new CRUDOperaciones();
		
		
		assertEquals(1,prueba.Agregar(productos) );
		assertEquals(1, prueba.Eliminar(productos));
		
	}
}
