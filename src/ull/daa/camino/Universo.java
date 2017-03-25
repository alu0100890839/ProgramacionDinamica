/**
 * Clase para el universo donde se ejecuta el algoritmo
 * Pablo Pastor Martín
 * alu0100890839@ull.edu.es
 * 25/03/2017
 */

package ull.daa.camino;

import java.io.*;

/**
 * Clase para el universo donde se ejecuta el algoritmo
 * @author Pablo Pastor Martín
 * @version 1.0.0
 */
public class Universo {
	private int[][] celdas;
	private int sizeH;
	private int sizeV;
	
	/**
	 * Constructor a partir del nombre del fichero con la descripcion del problema
	 * @param fileName Fichero con la descripcion del problema
	 * @throws IOException
	 */
	public Universo(String fileName) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		if(reader.ready()) {
			sizeH = Integer.parseInt(reader.readLine());
		}
		if(reader.ready()) {
			sizeV = Integer.parseInt(reader.readLine());
		}
		celdas = new int[getSizeH()][getSizeV()];
		for(int i = 0; i < getSizeH(); i++) {
			String line = reader.readLine();
			String tokens[] = line.split("\\s+");
			for(int j = 0; j < getSizeV(); j++) {
				celdas[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		reader.close();
	}

	/**
	 * @return the celdas
	 */
	public int[][] getCeldas() {
		return celdas;
	}

	/**
	 * @param celdas the celdas to set
	 */
	public void setCeldas(int[][] celdas) {
		this.celdas = celdas;
	}

	/**
	 * @return the sizeH
	 */
	public int getSizeH() {
		return sizeH;
	}

	/**
	 * @param sizeH the sizeH to set
	 */
	public void setSizeH(int sizeH) {
		this.sizeH = sizeH;
	}

	/**
	 * @return the sizeV
	 */
	public int getSizeV() {
		return sizeV;
	}

	/**
	 * @param sizeV the sizeV to set
	 */
	public void setSizeV(int sizeV) {
		this.sizeV = sizeV;
	}
	
	/**
	 * Metodo para obtener una celda en concreto
	 * @param i Fila
	 * @param j Columna
	 * @return Elemento de la celda
	 */
	public int getItem(int i, int j) {
		return getCeldas()[i - 1][j - 1];
	}
	
	/**
	 * Metodo para imprimir a una cadena con el universo
	 * @return Impresion del universo
	 */
	public String toString() {
		String toReturn = "";
		for(int i = 0; i < getSizeH(); i++) {
			for(int j = 0; j < getSizeV(); j++) {
				toReturn += getItem(i,j) + " ";
			}
			toReturn += "\n";
		}
		return toReturn;
	}
}
