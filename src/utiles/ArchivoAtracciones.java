package utiles;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;

public class ArchivoAtracciones extends Archivo{

	@Override
	protected void cargarFormato(int cant, Datos carga, Scanner scanner) {
		HashMap<String, Atraccion> mapa_atracciones = new HashMap<String, Atraccion>();
		HashMap<String, TreeSet<Atraccion>> mapa_atracciones_tipos = new HashMap<String, TreeSet<Atraccion>>();
		
		String nombre;
		int costo;
		double tiempo;
		int cupo;
		String tipo;
		
		Atraccion cargada;
		for (int i = 0; i < cant; i++) {
			nombre = scanner.nextLine();
			costo = scanner.nextInt();
			scanner.nextLine();
			tiempo = scanner.nextDouble();
			scanner.nextLine();
			cupo = scanner.nextInt();
			scanner.nextLine();
			tipo = scanner.nextLine();
			
			cargada = new Atraccion(nombre, costo, tiempo, cupo, tipo);
			
			mapa_atracciones.put(nombre, cargada);
			cargarMapaTipos(mapa_atracciones_tipos, cargada, tipo);
		}
		carga.setMapa_atracciones(mapa_atracciones);
		carga.setMapa_atracciones_tipos(mapa_atracciones_tipos);
		System.out.println("llego hasta atraccion");
	}
	
	private void cargarMapaTipos(HashMap<String, TreeSet<Atraccion>> mapa, Atraccion cargada, String tipo) {
		if(!mapa.containsKey(tipo))// Si no contiene el tipo_atraccion 
			mapa.put(tipo, new TreeSet<Atraccion>());
		
		mapa.get(tipo).add(cargada);// Obtener el TreeSet de ese tipo_atraccion
		// y cargar la atraccion a dicho TreeSet
	}
	
}
