/**
 * Clase para los alimentos del problema 1.1
 * Pablo Pastor Martín
 * alu01008908392@ull.edu.es
 * 24/03/2017
 */

package ull.daa.progdin;

/**
 * Clase para representar los alimentos del problema 1.1
 * @author Pablo Pastor Martín
 * @version 1.0.0
 */
public class Alimento {
	private int valorNutricional;
	private int nutrientesInsanos;
	private String nombre;
	
	/**
	 * Constructor que obtiene los datos de un argumento a partir de su línea descriptiva
	 * @param line Linea descriptiva del alimento
	 */
	public Alimento(String line) {
		String[] tokens = line.split("\\s+");
		if(tokens.length != 3) {
			throw new IllegalArgumentException("Alimento invalido: " + tokens[0]==null? "":tokens[0] );
		}
		else {
			this.nombre = tokens[0];
			this.valorNutricional = Integer.parseInt(tokens[1]);
			this.nutrientesInsanos = Integer.parseInt(tokens[2]);
		}
	}

	/**
	 * @return the valorNutricional
	 */
	public int getValorNutricional() {
		return valorNutricional;
	}

	/**
	 * @param valorNutricional the valorNutricional to set
	 */
	public void setValorNutricional(int valorNutricional) {
		this.valorNutricional = valorNutricional;
	}

	/**
	 * @return the nutrientesInsanos
	 */
	public int getNutrientesInsanos() {
		return nutrientesInsanos;
	}

	/**
	 * @param nutrientesInsanos the nutrientesInsanos to set
	 */
	public void setNutrientesInsanos(int nutrientesInsanos) {
		this.nutrientesInsanos = nutrientesInsanos;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método para representar como una cadena a un alimento
	 * @return represeentación en forma de cadena de texto el alimento
	 */
	public String toString() {
		return getNombre() + "("+ getValorNutricional() + "," + getNutrientesInsanos() + ")";
	}
	
}
