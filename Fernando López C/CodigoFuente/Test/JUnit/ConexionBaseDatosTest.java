package JUnit;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import Modelo.ConexionBaseDatos;

public class ConexionBaseDatosTest {

	@Test
	public void test() {
		
		ConexionBaseDatos con = new ConexionBaseDatos();
		
		Connection conexion=con.conectar();	
		
		assertNotNull(conexion);
		
		
	}

}
