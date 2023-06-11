package sistema.promociones;

import sistema.atracciones.Atraccion;

public class Promocion implements Comparable<Promocion> {
	protected String nombre;
	protected String tipo_promocion;
	protected int cant_atracciones;
	protected double duracion;
	protected double precio_original;
	protected double precio_mostrar;// final

	protected Atraccion[] vector_atracciones; // Este podria ser un Arraylist pero no hay porque agregar y sacar

//	public Promocion(String nombre, int cant_atracciones, Atraccion[] atracciones, String tipo_promocion) {
//		this.nombre = nombre;
//		this.tipo_promocion = tipo_promocion;
//
//		vector_atracciones = new Atraccion[cant_atracciones]; // inicializo vector_atracciones y lo cargo
//		for (int i = 0; i < cant_atracciones; i++) {
//			this.vector_atracciones[i] = atracciones[i];
//			this.precio_original += atracciones[i].getCosto(); // voy tambien cargandole el precio y la duracion
//			this.duracion += atracciones[i].getTiempoPromedio();
//		}
//	} //Esto lo hizo Clivio pero mejor usemos el de Abigail porfavor Dios de la JVM apiadate de mi alma
	
	public Promocion(String nombre, Atraccion[] atracciones, String tipo_promocion) {
//      System.out.println("Promocion, Constructor en la super clase");
//      System.out.println("Atracciones: " + Arrays.toString(atracciones));
        this.nombre = nombre;
        this.tipo_promocion = tipo_promocion;
        this.vector_atracciones = atracciones;// No hace falta inicializar a vector_atracciones, solo lo asigno
//      System.out.println("vector_atracciones: " + Arrays.toString(vector_atracciones));
        for (int i = 0; i < atracciones.length; i++) {
            this.precio_original += atracciones[i].getCosto(); // voy tambien cargandole el precio y la duracion
            this.duracion += atracciones[i].getTiempoPromedio();
        }
    }

//	protected String obtenerAtraccionesIncluidas() {
//		String atracciones = "[";
//		int i;
//		for (i = 0; i < this.vector_atracciones.length -1; i++) {
//			atracciones += this.vector_atracciones[i].getNombre() + ", ";
//		}
//		atracciones += this.vector_atracciones[i].getNombre() + "]";
//		return atracciones;
//	} //Necesitamos esto? -Lucas Ariel Clivio 21 Años, Nacido en Buenos Aires, Argentina. Saludos terricolas.
	
	public double getDuracion() {
		return duracion;
	}

	public double getPrecio_mostrar() {
		return precio_mostrar;
	}

	@Override
	public int compareTo(Promocion otra) { // Ascendente por precio, despues horas.
		int retorno;
		if ((retorno = Double.compare(otra.precio_mostrar, this.precio_mostrar)) == 0)
			return Double.compare(otra.duracion, this.duracion);
		return retorno;
	}

	public boolean tieneCupo() {
		boolean hay_cupo = true;
		for (int i = 0; i < this.vector_atracciones.length && hay_cupo; i++) {
			if (!vector_atracciones[i].tieneCupo())
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
	
	public void comprar() {
		for (int i = 0; i < vector_atracciones.length; i++) {
			vector_atracciones[i].comprar();
		}
	}
	
	@Override
	public String toString() {
		String texto_atracciones = "";
		for(int i=0;i<this.vector_atracciones.length;i++)
			texto_atracciones += this.vector_atracciones[i].toString() + "\n";
		
		return "Promocion:\n" + nombre + "\nTipo de promocion: " + tipo_promocion + "\nDuracion:" + duracion + "hrs."
				+ "\nPrecio: $" + precio_mostrar + "\n---------------\nAtracciones incluidas:\n" + texto_atracciones;
	}
}