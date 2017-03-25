/**
 * Clase para contener el main del programa
 * Pablo Pastor Martín
 * alu0100890839@ull.edu.es
 * 24/03/2017
 */
package ull.daa.menus;

import java.io.*;
import java.util.*;
/**
 * Clase para el main del programa
 * @author Pablo Pastor Martín
 */
public class Main {
	public static void main(String args[]) throws IOException{
		Clock reloj = new Clock();
		Scanner input = new Scanner(System.in);
		System.out.print("Elija: \n1. BottomUp\n2. TopDown\n3. Recursivo\nOpcion: ");
		int opcion = input.nextInt();
		input.close();
		long time = 0;
		
		switch(opcion){
			case 1:
			{
				MenuProgDin menu = new MenuProgDin(args[0]);
				reloj.start();
				menu.runBottomUp();
				time = reloj.stop();
				System.out.println(menu.solucion());
				break;
			}
			case 2:
			{
				MenuProgDin menu = new MenuProgDin(args[0]);
				reloj.start();
				menu.initTopDown();
				time = reloj.stop();
				System.out.println(menu.solucion());
				break;
			}
			case 3:
			{
				Menu menu = new Menu(args[0]);
				reloj.start();
				menu.initRecursive();
				time = reloj.stop();
				break;
			}
		}
		System.out.println("Se tardó en ejecutar " + time + " milisegundos");
	}
	
}
