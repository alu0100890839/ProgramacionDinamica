/**
 * Implementación de las soluciones con programación dinámica del problema 1.1
 * Pablo Pastor Martín
 * alu01008908392@ull.edu.es
 * 24/03/2017
 */

package ull.daa.menus;

import java.io.*;

/**
 * Implementación de las soluciones con programación dinámica del problema 1.1
 * @author Pablo Pastor Martín
 * @version 1.0.0
 */
public class MenuProgDin extends Menu {
	private int[][] matrizSolucion;
	
	/**
	 * Constructor a partir del nombre de un fichero
	 * @param fileName nombre del fichero con la descripción del problema
	 */
	public MenuProgDin(String fileName) throws IOException{
		super(fileName);
		matrizSolucion = new int[getNumPlatos()+1][getMaxInsanos()+1];
		for(int i = 0; i <= getNumPlatos(); i++) {
			for(int j = 0; j <= getMaxInsanos(); j++) {
				getMatrizSolucion()[i][j] = -1;
			}
		}
	}

	
	/**
	 * @return the matrizSolucion
	 */
	public int[][] getMatrizSolucion() {
		return matrizSolucion;
	}

	/**
	 * @param matrizSolucion the matrizSolucion to set
	 */
	public void setMatrizSolucion(int[][] matrizSolucion) {
		this.matrizSolucion = matrizSolucion;
	}
	
	/**
	 * Método que realiza la ejecución del algoritmo bottom up
	 */
	public void runBottomUp() {
		for(int i = 0; i < getMaxInsanos(); i++) {
			getMatrizSolucion()[0][i] = 0;
		}
		for(int i = 1; i <= getNumPlatos(); i++) {
			for(int j = 0; j <= getMaxInsanos(); j++) {
				Alimento alimento = getAlimentos().get(i - 1);
				if(alimento.getNutrientesInsanos() <= j) {
					getMatrizSolucion()[i][j] = Math.max(getMatrizSolucion()[i - 1][j],
							getMatrizSolucion()[i - 1][j - alimento.getNutrientesInsanos()] + alimento.getValorNutricional());
				}
				else {
					getMatrizSolucion()[i][j] = (getMatrizSolucion()[i - 1][j]);
				}
			}
		}
	}
	
	/**
	 * Método que realiza la ejecución del algoritmo top-down
	 */
	public int runTopDown(int n, int insanos) {
		if(n == 0 && insanos >= 0) {
			return 0;
		}
		if(insanos < 0) {
			return Integer.MIN_VALUE;
		}
		if(getMatrizSolucion()[n][insanos] != -1) {
			return getMatrizSolucion()[n][insanos];
		}
		int aux1 = runTopDown(n - 1, insanos);
		int aux2 = runTopDown(n - 1, insanos - getAlimentos().get(n - 1).getNutrientesInsanos()) + getAlimentos().get(n - 1).getValorNutricional();
		getMatrizSolucion()[n][insanos] = Math.max(aux1, aux2);
		return getMatrizSolucion()[n][insanos];
	}
	
	/**
	 * Método que arranca la ejecución del top-down
	 */
	public void initTopDown() {
		runTopDown(getNumPlatos(), getMaxInsanos());
	}
	
	/**
	 * Método que devuelve una String con la solución al problema
	 * @return String con la solución del problema
	 */
	public String solucion() {
		String solucion = "La solución aporta un valor de: " + getMatrizSolucion()[getNumPlatos()][getMaxInsanos()] + "\nSolución:\n";
		
		int j = getMaxInsanos();
		
		for(int i = getNumPlatos(); i > 1; i--) {
			Alimento alimento = getAlimentos().get(i - 1);
			if((alimento.getNutrientesInsanos() <= j) && 
					getMatrizSolucion()[i - 1][j - alimento.getNutrientesInsanos()] + alimento.getValorNutricional() == getMatrizSolucion()[i][j]) {
				solucion += alimento.getNombre() + " está en la solución\n";
				j = j - alimento.getNutrientesInsanos();
			}
		}
		return solucion;
	}
}
