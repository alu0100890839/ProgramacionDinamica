/**
 * Main para el problema 1.2
 * Pablo Pastor Martín
 * alu0100890839@ull.edu.es
 * 25/03/2017
 */

package ull.daa.camino;

import java.io.*;

/**
 * Clase para el main del problema 1.2
 * @author Pablo Pastor Martín
 * @version 1.0.0
 */
public class Main {
	public static void main(String args[]) throws IOException{
		if(args.length == 1) {
			ProgDin problema = new ProgDin(args[0]);
			problema.run();
			System.out.println(problema.solucion());
		}
		else {
			System.out.println("Argumentos erroneos");
		}
	}
}
