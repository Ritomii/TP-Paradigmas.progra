package sistema.promociones;

public class PromocionAbsoluta extends Promocion{
	private int descuento;

	public PromocionAbsoluta(String nombre, String nombre_atraccion1, String nombre_atraccion2, String tipo_promocion,
			int descuento) {
		super(nombre, nombre_atraccion1, nombre_atraccion2, tipo_promocion);
		this.descuento = descuento;
	}
	
	
}
