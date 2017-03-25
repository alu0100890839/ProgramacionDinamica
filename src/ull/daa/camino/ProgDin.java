/**
 * Clase que implementa el algoritmo que soluciona el problema 1.2
 * Pablo Pastor Martín
 * alu0100890839@ull.edu.es
 * 25/03/2017
 */

package ull.daa.camino;

import java.io.*;
import java.util.*;

/**
 * Clase que implementa el algoritmo que soluciona el problema 1.2
 * @author Pablo Pastor Martín
 * @version 1.0.0
 */
public class ProgDin {
	private Universo universo;
	private int matrizSoluciones[][];
	
	/**
	 * Constructor a partir del nombre de un fichero 
	 * @param fileName Fichero con la descripcion del problema
	 * @throws IOException
	 */
	public ProgDin(String fileName) throws IOException{
		universo = new Universo(fileName);
		matrizSoluciones = new int[universo.getSizeH() + 1][universo.getSizeV() + 1];
		for(int i = 0; i <= universo.getSizeH(); i++) {
			matrizSoluciones[i][0] = 0;
		}
		for(int i = 0; i <= universo.getSizeV(); i++) {
			matrizSoluciones[0][i] = 0;
		}
	}
	
	/**
	 * Método para la ejecución del algoritmo bottom-up que resuelve el problema
	 */
	public void run() {
		for(int i = 1; i <= universo.getSizeH(); i++) {
			for(int j = 1; j <= universo.getSizeV(); j++) {
				int max = Math.max(getMatrizSoluciones()[i - 1][j], getMatrizSoluciones()[i][j - 1]);
				getMatrizSoluciones()[i][j] = max + universo.getItem(i, j);
			}
		}
	}
	
	/**
	 * Metodo para generar la solucion
	 * @return Cadena que representa la solución
	 */
	public String solucion() {
		String toReturn = "Solución: " + getMatrizSoluciones()[universo.getSizeH()][universo.getSizeV()] + "\n Camino: (1, 1) ";
		ArrayList<Integer[]> coordenadas = new ArrayList<Integer[]>();
		int i = universo.getSizeH(), j = universo.getSizeV();
		coordenadas.add(0, new Integer[] {i, j});
		while(i != 1 || j!= 1) {
			System.out.println(i + " " + j + "    " + getMatrizSoluciones()[i][j] + "\n");
			if(universo.getItem(i, j) + getMatrizSoluciones()[i - 1][j] == getMatrizSoluciones()[i][j]) {
				i--;
			}
			else {
				j--;
			}
			coordenadas.add(0, new Integer[] {i, j});
		}
		for(i = 1; i < coordenadas.size(); i++) {
			toReturn += "-> (" + coordenadas.get(i)[0] + ", " + coordenadas.get(i)[1] + ") ";
		}
		return toReturn;
	}

	/**
	 * @return the universo
	 */
	public Universo getUniverso() {
		return universo;
	}

	/**
	 * @param universo the universo to set
	 */
	public void setUniverso(Universo universo) {
		this.universo = universo;
	}

	/**
	 * @return the matrizSoluciones
	 */
	public int[][] getMatrizSoluciones() {
		return matrizSoluciones;
	}

	/**
	 * @param matrizSoluciones the matrizSoluciones to set
	 */
	public void setMatrizSoluciones(int[][] matrizSoluciones) {
		this.matrizSoluciones = matrizSoluciones;
	}
}
