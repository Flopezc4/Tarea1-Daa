package Modelo;

import java.sql.Date;

public class Productos {

	public Productos(String nom_Producto, String tipo_Producto, int codigo_Producto, int valor_Producto, int stock) {
		
		Nom_Producto = nom_Producto;
		Tipo_Producto = tipo_Producto;
		Codigo_Producto = codigo_Producto;
		Valor_Producto = valor_Producto;
		Stock = stock;
	}
	
	public Productos() {
		super();
	}
	
	private String Nom_Producto, Tipo_Producto;
	private int Codigo_Producto, Valor_Producto, Stock;
	
	
	public String getNom_Producto() {
		return Nom_Producto;
	}
	public void setNom_Producto(String nom_Producto) {
		Nom_Producto = nom_Producto;
	}
	public String getTipo_Producto() {
		return Tipo_Producto;
	}
	public void setTipo_Producto(String tipo_Producto) {
		Tipo_Producto = tipo_Producto;
	}
	public int getCodigo_Producto() {
		return Codigo_Producto;
	}
	public void setCodigo_Producto(int codigo_Producto) {
		Codigo_Producto = codigo_Producto;
	}
	public int getValor_Producto() {
		return Valor_Producto;
	}
	public void setValor_Producto(int valor_Producto) {
		Valor_Producto = valor_Producto;
	}
	@Override
	public String toString() {
		return "Productos [Nom_Producto=" + Nom_Producto + ", Tipo_Producto=" + Tipo_Producto + ", Codigo_Producto="
				+ Codigo_Producto + ", Valor_Producto=" + Valor_Producto + ", Stock=" + Stock + "]";
	}

	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}

}
