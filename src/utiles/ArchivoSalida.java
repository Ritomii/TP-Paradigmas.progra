package utiles;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import sistema.usuarios.Usuario;


public class ArchivoSalida {
	private static final String RUTA_SALIDA = "./salida/salida.out";
	
	public void escribirSalida(Datos cargados) {		
		FileWriter file = null;
		PrintWriter escritor = null;

		
		
		try {
			file = new FileWriter(RUTA_SALIDA);
			escritor = new PrintWriter(file);

			this.informeUsuarios(cargados.getLista_usuarios(), escritor);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
	}
	
	private void informeUsuarios(LinkedList<Usuario> lista_usuarios, PrintWriter escritor) {
		escritor.println("Informe de Usuarios:");
		for (Usuario usuario : lista_usuarios) {
			escritor.println(usuario.salidaUsuario());
		}
	}
}
