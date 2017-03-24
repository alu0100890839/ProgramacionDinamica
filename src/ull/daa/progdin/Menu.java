/**
 * Clase genérica para las soluciones al problema 1.1
 * Pablo Pastor Martín
 * alu0100890839@ull.edu.es
 * 24/03/2017
 */

package ull.daa.progdin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Clase generica para las soluciones al problema 1.1
 * @author Pablo Pastor Martín
 *
 */
public class Menu {
	private int numPlatos;
	private int maxInsanos;
	private ArrayList<Alimento> alimentos;
	
	/**
	 * Constructor a partir del nombre de un fichero
	 * @param fileName nombre del fichero con la descripción del problema
	 */
	public Menu(String fileName) throws IOException{
		alimentos = new ArrayList<Alimento>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		if(reader.ready()) {
			this.numPlatos = Integer.parseInt(reader.readLine());
		}
		if(reader.ready()) {
			this.maxInsanos = Integer.parseInt(reader.readLine());
		}
		for(int i = 0; i < getNumPlatos(); i++) {
			alimentos.add(new Alimento(reader.readLine()));
		}
		reader.close();
	}
	
	/**
	 * Método que realiza la ejecución del algoritmo recursivo
	 */
	public int runRecursive(int n, int insanos, HashSet<String> set) {
		if(n == 0 && insanos >= 0) {
			return 0;
		}
		if(insanos < 0) {
			return Integer.MIN_VALUE;
		}
		int aux1 = runRecursive(n - 1, insanos, set);
		int aux2 = runRecursive(n - 1, insanos - getAlimentos().get(n - 1).getNutrientesInsanos(), set) + getAlimentos().get(n - 1).getValorNutricional();
		if(aux2 >= aux1) {
			set.add((getAlimentos().get(n - 1).getNombre()));
		}
		else {
			set.remove((getAlimentos().get(n - 1).getNombre()));
		}
		return Math.max(aux1, aux2);
	}
	
	
	/**
	 * Método que arranca la ejecución del recursivo
	 */
	public void initRecursive() {
		HashSet<String> set = new HashSet<String>();
		System.out.println("Solucion: " + runRecursive(getNumPlatos(), getMaxInsanos(), set) + "\n");
		for(String s: set) {
			System.out.println(s + " Está en la solución\n");
		}
	}

	/**
	 * @return the numPlatos
	 */
	public int getNumPlatos() {
		return numPlatos;
	}

	/**
	 * @param numPlatos the numPlatos to set
	 */
	public void setNumPlatos(int numPlatos) {
		this.numPlatos = numPlatos;
	}

	/**
	 * @return the maxInsanos
	 */
	public int getMaxInsanos() {
		return maxInsanos;
	}

	/**
	 * @param maxInsanos the maxInsanos to set
	 */
	public void setMaxInsanos(int maxInsanos) {
		this.maxInsanos = maxInsanos;
	}

	/**
	 * @return the alimentos
	 */
	public ArrayList<Alimento> getAlimentos() {
		return alimentos;
	}

	/**
	 * @param alimentos the alimentos to set
	 */
	public void setAlimentos(ArrayList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
}

