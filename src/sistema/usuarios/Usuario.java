package sistema.usuarios;

import sistema.atracciones.Atraccion;

public class Usuario {
	private String nombre;
	private String preferencia;
	private int dinero;
	private double tiempo;
	private Atraccion[] elegidas; 
	//Arraylist Atraccion
	//Arraylist Promocion
	//Mapa String-Atraccion
	public Usuario(String nombre, String preferencia, int dinero, double tiempo) {
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.dinero = dinero;
		this.tiempo = tiempo;
	}
	
}
