package sistema.promociones;

public class Promocion {
	protected String nombre;
	protected String nombre_atraccion1;
	protected String nombre_atraccion2;
	protected String tipo_promocion;
	
	protected double duracion;
	protected int precioOriginal;
	protected int precio_mostrar;
	public Promocion(String nombre, String nombre_atraccion1, String nombre_atraccion2, String tipo_promocion) {
		this.nombre = nombre;
		this.nombre_atraccion1 = nombre_atraccion1;
		this.nombre_atraccion2 = nombre_atraccion2;
		this.tipo_promocion = tipo_promocion;
	}
	
	
}
