package sistema.promociones;

public class PromocionCombo extends Promocion{
	private String nombre_atraccion_gratis;

	public PromocionCombo(String nombre, String nombre_atraccion1, String nombre_atraccion2, String tipo_promocion,
			String nombre_atraccion_gratis) {
		super(nombre, nombre_atraccion1, nombre_atraccion2, tipo_promocion);
		this.nombre_atraccion_gratis = nombre_atraccion_gratis;
		this.precio_mostrar = this.precioOriginal;
	}
	
	public String getAtraccionGratis() {
		return this.nombre_atraccion_gratis;
	}
	
}
