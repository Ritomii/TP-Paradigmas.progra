package sistema.promociones;

import sistema.atracciones.Atraccion;

public class Promocion implements Comparable<Promocion>{
	protected String nombre;
	protected String nombre_atraccion1;
	protected String nombre_atraccion2;
	protected String tipo_promocion;
	protected double duracion;
	protected double precioOriginal;
	protected double precio_mostrar;//final
	
	protected Atraccion[] vector_atracciones; //Este podria ser un Arraylist pero no hay porque agregar y sacar

	public Promocion(String nombre, String nombre_atraccion1, String nombre_atraccion2, String tipo_promocion) {
		this.nombre = nombre;
		this.nombre_atraccion1 = nombre_atraccion1;
		this.nombre_atraccion2 = nombre_atraccion2;
		this.tipo_promocion = tipo_promocion;
		
	}
	
	public double getDuracion() {
		return duracion;
	}
	public double getPrecio_mostrar() {
		return precio_mostrar;
	}

	@Override
	public int compareTo(Promocion otra) { //precio, despues horas.
		int retorno;
		if((retorno = Double.compare(this.precio_mostrar, otra.precio_mostrar)) == 0)
			return Double.compare(this.duracion, otra.duracion);
		return retorno;
	}
	
	public boolean tieneCupo() {
		boolean hay_cupo = true;
		for (int i = 0; i < this.vector_atracciones.length && hay_cupo; i++) {
			if(!vector_atracciones[i].tieneCupo())
				hay_cupo = false;
		}
		return hay_cupo;
	}
	
	public String[] obtenerNombresAtracciones() {
		String[] nombres_atracciones = new String[vector_atracciones.length];
		for (int i = 0; i < this.vector_atracciones.length; i++) {
			nombres_atracciones[i] = this.vector_atracciones[i].getNombre();
		}
		return nombres_atracciones;
	}
}