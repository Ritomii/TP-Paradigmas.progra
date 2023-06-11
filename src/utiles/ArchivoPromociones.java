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

public class ArchivoPromociones extends Archivo {
    @Override
    protected void cargarFormato(int cant, Datos carga, Scanner scanner) {
        HashMap<String, TreeSet<Promocion>> mapa_promos_tipos = new HashMap<String, TreeSet<Promocion>>();
        // mapa de tipos de promocion
        int cant_atracciones;
        String nombre_promocion;
        String atraccion_actual;// nombre_atraccion
        Atraccion atraccion_obj;
        String preferencia;
        String tipo_promocion;
        String random;
        // traernos las atracciones desde el mapa de atracciones y las cargamos
        Promocion cargada;
        
        for (int i = 0; i < cant; i++) {
            nombre_promocion = scanner.nextLine();
            preferencia = scanner.nextLine();// NO hace falta
            cant_atracciones = scanner.nextInt();
            scanner.nextLine();
            Atraccion[] atracciones = new Atraccion[cant_atracciones];
            for (int j = 0; j < cant_atracciones; j++) {
                atraccion_actual = scanner.nextLine();
                atraccion_obj = carga.obtenerAtraccion(atraccion_actual);
                atracciones[j] = atraccion_obj;
            }
            tipo_promocion = scanner.nextLine();
            random = scanner.nextLine();// Aca llega el descuento, el precio_absoluto o el nombre_atraccion_gratuita
            cargada = generarPromocion(nombre_promocion, preferencia, tipo_promocion, atracciones, random, carga);
            this.cargarMapaTipos(mapa_promos_tipos, cargada, preferencia, tipo_promocion);
            // Para la preferencia : atracciones[0].getTipo()
        }
        carga.setMapa_promos_tipos(mapa_promos_tipos);
    }
    
    private void cargarMapaTipos(HashMap<String, TreeSet<Promocion>> mapa, Promocion cargada, String tipo,
            String tipo_promocion) {
        if (!mapa.containsKey(tipo))// Si no contiene ese tipo_atraccion
            mapa.put(tipo, new TreeSet<Promocion>());
        mapa.get(tipo).add(cargada);// Obtener el TreeSet de ese tipo_atraccion
        // y cargar la promocion a dicho TreeSet
    }// SIN CAMBIOS
    
    private Promocion generarPromocion(String nombre_promocion, String preferencia, String tipo,
            Atraccion[] atracciones, String random, Datos carga) {
        Promocion retorno = null;
        switch (tipo) {
        case "Porcentual":
            retorno = new PromocionPorcentual(nombre_promocion, atracciones, tipo, Double.parseDouble(random));
            break;// En random esta el porcentaje de descuento
        case "Absoluta":
            retorno = new PromocionAbsoluta(nombre_promocion, atracciones, tipo, Double.parseDouble(random));
            break;// En random esta el precio absoluto
        case "Gratis":
            retorno = new PromocionCombo(nombre_promocion, atracciones, tipo, carga.getMapa_atracciones().get(random));
            break;// En random esta el nombre de la atraccion gratuita
        }
        return retorno;
    }
}
	
