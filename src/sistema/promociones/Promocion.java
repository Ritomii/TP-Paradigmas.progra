package sistema.promociones;

import sistema.atracciones.Atraccion;

public class Promocion {
	protected Atraccion [] atraccionesIncluidas;
	protected double duracion;
	protected double precioOriginal;
	
	Promocion(Atraccion[] atracciones, double duracion, double precioOriginal){
		for(Atraccion actual : atracciones) {
			this.duracion =  this.duracion + actual.getTiempoPromedio();
			this.precioOriginal = this.precioOriginal + actual.getCosto();
		}
	}
}
