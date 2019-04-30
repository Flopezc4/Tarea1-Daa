package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import Modelo.CRUDOperaciones;
import Modelo.Productos;

public class CRUDOperacionesTest {

		Productos productos = new Productos("Nombre","Tipo Producto",10,10,10);
		Productos productoseliminado = new Productos("Nombre1","Tipo Producto",10,10,10);
		
		
	@Test
	public void testBuscar() {
		
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		assertEquals(1,prueba.Buscar(productos) );
	}

	@Test
	public void testModificar() {
		
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		assertEquals(1,prueba.Modificar(productos) );
		
	}

	@Test
	public void testAgregar() {
	
		CRUDOperaciones prueba = new CRUDOperaciones();
		
		assertEquals(1,prueba.Agregar(productos) );
	}
	
	@Test
	public void testEliminar() {

		CRUDOperaciones prueba = new CRUDOperaciones();
		
		
		assertEquals(1,prueba.Agregar(productoseliminado) );
		assertEquals(1, prueba.Eliminar(productos));
		
	}
	
}

