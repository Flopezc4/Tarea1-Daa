package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class ModificarTest {

	Productos productos = new Productos("ModificarTest","Tipo Producto",10,10,10);
	@Test
	public void testModificar() {
		
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		assertEquals(1,prueba.Agregar(productos) );
		assertEquals(1, prueba.Modificar(productos));
	}

}
