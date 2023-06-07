package utiles;

import java.util.LinkedList;
import java.util.Scanner;

import sistema.usuarios.Usuario;

public class ArchivoUsuarios extends Archivo{
	
	@Override
	protected void cargarFormato(int cant, Datos carga, Scanner scanner) {
		LinkedList<Usuario> lista_usuarios = new LinkedList<Usuario>();
		String nombre;
		String preferencia;
		int dinero;
		double tiempo;
		for (int i = 0; i < cant; i++) {
			nombre = scanner.nextLine();
			preferencia = scanner.nextLine();
			dinero = scanner.nextInt();
			scanner.nextLine();
			tiempo = scanner.nextDouble();
			scanner.nextLine();
			lista_usuarios.add(new Usuario(nombre, preferencia, dinero, tiempo));
		}
		System.out.println(lista_usuarios.getLast().getNombre());
		carga.setLista_usuarios(lista_usuarios);
	}
}
