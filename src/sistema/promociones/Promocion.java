package sistema.promociones;

import sistema.atracciones.Atraccion;

public class Promocion implements Comparable<Promocion> {
	protected String nombre;
	protected String tipo_promocion;
	protected double duracion;
	protected double precio_original;
	protected double precio_mostrar;// precio final

	protected Atraccion[] vector_atracciones; // Este podria ser un Arraylist
												// pero no hay porque agregar y
												// sacar

	public Promocion(String nombre, Atraccion[] atracciones, String tipo_promocion) {
		this.nombre = nombre;
		this.tipo_promocion = tipo_promocion;
		this.vector_atracciones = atracciones;
		for (int i = 0; i < atracciones.length; i++) {
			this.precio_original += atracciones[i].getCosto(); // voy tambien
																// cargandole el
																// precio y la
																// duracion
			this.duracion += atracciones[i].getTiempoPromedio();
		}
	}

	public double getDuracion() {
		return duracion;
	}

	public double getPrecio_mostrar() {
		return precio_mostrar;
	}

	public Atraccion[] getVector_atracciones() {
		return vector_atracciones;
	}

	public String getTipo_promocion() {
		return tipo_promocion;
	}

	@Override
	public int compareTo(Promocion otra) {
		int retorno;
		// Se cambia el orden de los parametros para que el ordenamiento en
		// arbol sea de
		// mayor a menor.
		if ((retorno = Double.compare(otra.precio_mostrar, this.precio_mostrar)) == 0) {
			if ((retorno = Double.compare(otra.duracion, this.duracion)) == 0) {
				if ((retorno = otra.nombre.compareTo(this.nombre)) == 0) {
					retorno = otra.tipo_promocion.compareTo(this.tipo_promocion);
				}
			}
		}
		return retorno;
	}

	public boolean tieneCupo(int cantUsuarios) {
		boolean hay_cupo = true;
		for (int i = 0; i < this.vector_atracciones.length && hay_cupo; i++) {
			if (!vector_atracciones[i].tieneCupo(cantUsuarios)) // enviamos
																// cantUsuarios
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

	public void comprar(int cantUsuarios) {
		for (int i = 0; i < vector_atracciones.length; i++) {
			vector_atracciones[i].comprar(cantUsuarios);
		}
	}

	@Override
	public String toString() {
		String texto_atracciones = "";
		for (int i = 0; i < this.vector_atracciones.length; i++)
			texto_atracciones += this.vector_atracciones[i].toString() + "\n";

		return "\n--------------------\nPromocion: " + nombre + "\nTipo de promocion: " + tipo_promocion
				+ "\nDuracion: " + String.format("%,.2f", duracion) + " horas" + "\nPrecio original: $"
				+ precio_original + "\nAtracciones incluidas:\n\n" + texto_atracciones;
	}
}