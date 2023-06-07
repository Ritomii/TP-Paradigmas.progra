package utiles;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

import sistema.atracciones.Atraccion;
import sistema.promociones.Promocion;
import sistema.promociones.PromocionAbsoluta;
import sistema.promociones.PromocionCombo;
import sistema.promociones.PromocionPorcentual;

public class ArchivoPromociones extends Archivo{

	@Override
	protected void cargarFormato(int cant, Datos carga, Scanner scanner) {
		HashMap<String, TreeSet<Promocion>> mapa_promos_tipos = new HashMap<String, TreeSet<Promocion>>(); // mapa de tipos de promocion
		
		int cant_atracciones;
		String nombre_promocion;
		String atraccion_actual;
		Atraccion atraccion_obj;
		String preferencia;
//		String nombre_atraccion2;
		String tipo_promocion;
		String descuento;
		//traernos las atracciones desde el mapa de atracciones y las cargamos
		//String tipo; //tipoAtraccion
		Promocion cargada;
		for (int i = 0; i < cant; i++) {
			nombre_promocion = scanner.nextLine();
			preferencia = scanner.nextLine();
			cant_atracciones = scanner.nextInt();
			scanner.nextLine();
			Atraccion atracciones [] = new Atraccion [cant_atracciones];
			for(int j = 0; j < cant_atracciones; j++) {
				atraccion_actual = scanner.nextLine();
				atraccion_obj = carga.obtenerAtraccion(atraccion_actual);
				atracciones[j] = atraccion_obj;
			}
			tipo_promocion = scanner.nextLine();
			descuento = scanner.nextLine();
			cargada = generarPromocion(nombre_promocion,preferencia,cant_atracciones,tipo_promocion,atracciones,descuento);
//			nombre_atraccion1 = scanner.nextLine();
//			nombre_atraccion2 = scanner.nextLine();			
			//tipo = carga.obtenerTipoAtraccion(nombre_atraccion1); 
//			a1 = carga.obtenerAtraccion(nombre_atraccion1);
//			a2 = carga.obtenerAtraccion(nombre_atraccion2);
//			cargada = obtenerPromocionDerivada(nombre_promocion, nombre_atraccion1, nombre_atraccion2, tipo_promocion, descuento); //conjunto de datos --> promoDerivada
//			cargada = generarPromocion(nombre_promocion,a1,a2,descuento);
			this.cargarMapaTipos(mapa_promos_tipos, cargada, preferencia, tipo_promocion);
		}
		System.out.println(mapa_promos_tipos.get("Aventura").size());
		carga.setMapa_promos_tipos(mapa_promos_tipos);
		System.out.println("llego hasta promocion");
	}

	
	private void cargarMapaTipos(HashMap<String, TreeSet<Promocion>> mapa, Promocion cargada, String tipo, String tipo_promocion) {
		if(!mapa.containsKey(tipo))
			mapa.put(tipo, new TreeSet<Promocion>());
		
		mapa.get(tipo).add(cargada);
	}
	
//	private Promocion generarPromocion(String nombre_promocion, Atraccion a1, Atraccion a2, String descuento) {
//		Promocion retorno = null;
//		String tipo_promocion = a1.getTipo();
//		switch(tipo_promocion) {
//		case "Porcentual":
//			retorno = new PromocionPorcentual(nombre_promocion, a1.getNombre(), a2.getNombre(), tipo_promocion, Double.parseDouble(descuento));
//			break;
//		case "Absoluta":
//			retorno = new PromocionAbsoluta(nombre_promocion, a1.getNombre(), a2.getNombre(), tipo_promocion, Integer.parseInt(descuento));
//			break;
//		case "Gratis":
//			retorno = new PromocionCombo(nombre_promocion, a1.getNombre(), a2.getNombre(), tipo_promocion, descuento);
//			break;
//		}
//		return retorno;
//	}
//}
	
	private Promocion generarPromocion(String nombre_promocion, String preferencia, int cant_atracciones, String tipo, Atraccion[] atracciones, String descuento) {
		Promocion retorno = null;
		switch(tipo) {
		case "Porcentual":
			retorno = new PromocionPorcentual(nombre_promocion, cant_atracciones, atracciones, tipo, Double.parseDouble(descuento));
			break;
		case "Absoluta":
			retorno = new PromocionAbsoluta(nombre_promocion, cant_atracciones, atracciones, tipo, Integer.parseInt(descuento));
			break;
		case "Gratis":
			retorno = new PromocionCombo(nombre_promocion, cant_atracciones, atracciones, tipo, descuento);
			break;
		}
		return retorno;
	}
}
	
	
//	private Promocion obtenerPromocionDerivada(String nombre_promocion, String nombre_atraccion1, String nombre_atraccion2,
//			String tipo_promocion, String descuento) {
//		Promocion retorno = null;
//		switch (tipo_promocion) {
//		case "Porcentual": 
//			retorno = new PromocionPorcentual(nombre_promocion, nombre_atraccion1, nombre_atraccion2, tipo_promocion, Double.parseDouble(descuento));
//			break;
//		case "Absoluta":
//			retorno = new PromocionAbsoluta(nombre_promocion, nombre_atraccion1, nombre_atraccion2, tipo_promocion, Integer.parseInt(descuento));
//			break;
//		case "Gratis":
//			retorno = new PromocionCombo(nombre_promocion, nombre_atraccion1, nombre_atraccion2, tipo_promocion, descuento);
//		}
//		return retorno;
//	}
//}
