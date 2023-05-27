package sources;

public class Atraccion {
	
	private String nombre;
	private String tipo;
	private double costo;
	private double tiempoPromedio;
	private int cupoDiario;
	
	Atraccion(String nombre, String tipo, double costo, double tiempoPromedio, int cupo){
		this.nombre = nombre;
		this.tipo = tipo;
		this.costo = costo;
		this.tiempoPromedio = tiempoPromedio;
		this.cupoDiario = cupo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public String getTipo() {
		return this.tipo;
	}

	public double getCosto() {
		return this.costo;
	}

	public double getTiempoPromedio() {
		return this.tiempoPromedio;
	}

	public int getCupoDiario() {
		return this.cupoDiario;
	}

}
