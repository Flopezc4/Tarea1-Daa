package Vista;

import java.awt.EventQueue;

/**
 * Declaraci�n de la clase Main
 * Clase principal del sistema
 * @author Fernando L�pez
 *
 */

public class Main  {

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MarcoPrincipal window = new MarcoPrincipal();
					window.frmComercialLaRojita.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
