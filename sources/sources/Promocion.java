package sources;

public abstract class Promocion{
	
	protected Atraccion [] atraccionesIncluidas;
	protected double duracion;
	protected double precioOriginal;
	
	Promocion(Atraccion[] atracciones, double duracion, double precioOriginal){
		for(Atraccion actual : atracciones) {
			this.duracion =  this.duracion + actual.getTiempoPromedio();
			this.precioOriginal = this.precioOriginal + actual.getCosto();
		}
	}
	
	//por el momento, pense el problema de esta forma, haciendo una clase Promocion de la que se derivan los tres tipos.
	//pero tambien se me ocurrio hacerlo de otra forma. como vimos en la clase del lunes, usando un patron de diseño de estados. 
	//donde el estado sea el tipo de promocion y en base a ello el calculo del descuento o la atraccion gratis. lo charlamos. 
}
