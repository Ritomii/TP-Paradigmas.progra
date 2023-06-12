package sistema.inicio;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import sistema.atracciones.Atraccion;
import sistema.usuarios.Usuario;
import utiles.ArchivoSalida;
import utiles.Datos;
import utiles.Lector;
import sistema.promociones.*;

public class OfertadorTest {

//	Atraccion a1 = new Atraccion("Montania rusa",350.20,1.30,20,"Aventura");
//	Atraccion a2 = new Atraccion("Glaciar Perito Moreno",600.50,2.00,15,"Paisaje");
//	Atraccion a3 = new Atraccion("Sierras Cordobesas",400,1.00,30,"Paisaje");
//	Atraccion a4 = new Atraccion("Parrilla",245.10,3.00,40,"Degustacion");
//	Atraccion a5=  new Atraccion("Cerro Catedral",650.0,2.30,20,"Paisaje");
//	Atraccion a6 = new Atraccion("Escalada",500.0,3.00,20,"Aventura");
//	Atraccion a7 = new Atraccion("Fogon",200.0,3.00,10,"Aventura");
//	Atraccion a8 = new Atraccion("Fogon",200.0,3.00,10,"Aventura");
//	Atraccion a9 = new Atraccion("Fogon",200.0,5.00,10,"Degustacion");
//	Atraccion a10 = new Atraccion("Fogon",200.0,3.00,10,"Degustacion");
	
	@Test
	public void ofertador() {
		
		LinkedList<Usuario> users;
		Lector lectura = new Lector();
		Menu consola = new Menu();
		Datos cargados;
		
		cargados = lectura.leerDatos();
		
		users = cargados.getLista_usuarios();
		 System.out.println(users);
//		Usuario u1 = new Usuario("Lionel Messi", "Aventura", 3500, 24);
//		
//		Atraccion [] atracciones_aventura = new Atraccion[3];
//		atracciones_aventura[0] = a1;
//		atracciones_aventura[1] = a6;
//		atracciones_aventura[2] = a7;
//		
//		Atraccion [] atracciones_paisaje = new Atraccion [3];
//		atracciones_paisaje[0] = a2;
//		atracciones_paisaje[1] = a3;
//		atracciones_paisaje[2] = a5;
//		
//		Promocion promo1 = new PromocionAbsoluta("La gran aventura", atracciones_aventura,"Aventura",900);
//		Promocion promo2 = new PromocionPorcentual("La gran aventura", atracciones_aventura,"Aventura",900);
//		Promocion promo3 = new PromocionAbsoluta("La gran aventura", atracciones_aventura,"Aventura",900);

		
	}

}
