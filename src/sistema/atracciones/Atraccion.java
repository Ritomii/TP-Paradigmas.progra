package sistema.atracciones;

public class Atraccion implements Comparable<Atraccion> {

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
	
	public void comprar() {
		this.cupoDiario--;
	}
	
	@Override
	public String toString() {
		return "Atraccion:" + nombre + "|Precio: $" + costo + "|Duracion: " + tiempoPromedio + "hrs." + "\n";
	}

	@Override
	public int compareTo(Atraccion otra) {// Necesito que se ordene de mayor a menor
		int retorno;
		if((retorno = Double.compare(otra.costo, this.costo)) == 0)
			return Double.compare(otra.tiempoPromedio,this.tiempoPromedio);
		return retorno;
	}

}
