package sources;

public class PromocionPorcentual extends Promocion {
	//aca entre en duda en si crear una variable para guardarnos el porcentaje. aunque solo tendria sentido si lo vamos a mostrar por pantalla. sino ni me molestaria en crearla
	private double precioFinal;
	
	public PromocionPorcentual(Atraccion[] atracciones, double duracion, double precioOriginal,double porcentaje) {
		super(atracciones, duracion, precioOriginal);
		this.precioFinal = ((this.precioOriginal*porcentaje)/100);
	}
	
	public double getPrecioFinal() {
		return this.precioFinal;
	}
}
