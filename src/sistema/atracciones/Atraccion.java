package sistema.atracciones;

import java.util.Objects;

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
		return cupoDiario;
	}

	public boolean tieneCupo() {
		return this.cupoDiario > 0;
	}

	public void comprar() {
		this.cupoDiario--;
	}

	@Override
	public String toString() {
		return "Atraccion: " + nombre + " | Precio: $" + costo + " | Duracion: " + tiempoPromedio + " horas." + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(costo, cupoDiario, nombre, tiempoPromedio, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo) && cupoDiario == other.cupoDiario
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoPromedio) == Double.doubleToLongBits(other.tiempoPromedio)
				&& Objects.equals(tipo, other.tipo);
	}

	@Override
	public int compareTo(Atraccion otra) {
		int retorno;
		if ((retorno = Double.compare(otra.costo, this.costo)) == 0)
			if ((retorno = Double.compare(otra.tiempoPromedio, this.tiempoPromedio)) == 0) {
				if ((retorno = this.nombre.compareTo(otra.nombre)) == 0) {
					retorno = this.tipo.compareTo(otra.tipo);
				}
			}
		return retorno;
	}

}
