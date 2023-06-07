package sistema.atracciones;


public class Atraccion implements Comparable<Atraccion>{
	
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

	@Override
	public int compareTo(Atraccion otra) {
		int retorno;
		if((retorno = Double.compare(this.getCosto(), otra.getCosto())) == 0) {
			return Double.compare(this.getTiempoPromedio(), otra.getTiempoPromedio());
		}
		return retorno;
	}
}
