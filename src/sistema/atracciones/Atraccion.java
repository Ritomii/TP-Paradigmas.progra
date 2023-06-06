package sistema.atracciones;


public class Atraccion {
	
	private String nombre;
	private double costo;
	private double tiempoPromedio;
	private int cupoDiario;
	private String tipo;

	public Atraccion(String nombre, double costo, double tiempoPromedio, int cupoDiario, String tipo) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoPromedio = tiempoPromedio;
		this.cupoDiario = cupoDiario;
		this.tipo = tipo;
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

	public boolean tieneCupo() {
		return this.cupoDiario > 0;
	}
}
