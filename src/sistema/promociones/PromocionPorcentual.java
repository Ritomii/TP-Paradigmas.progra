package sistema.promociones;

public class PromocionPorcentual extends Promocion{
	private double descuento;

	public PromocionPorcentual(String nombre, String nombre_atraccion1, String nombre_atraccion2, String tipo_promocion,
			double descuento) {
		super(nombre, nombre_atraccion1, nombre_atraccion2, tipo_promocion);
		this.descuento = descuento;
	}
	
}
