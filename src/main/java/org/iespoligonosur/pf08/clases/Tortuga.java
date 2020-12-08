package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador Tortuga.
 * @author Grupo A1.
 *
 */
public class Tortuga {
	
	int dadoTortuga;
	
	/**
	 * Constructor de la clase Tortuga.
	 */
	public Tortuga() {
		
	}
	
	/**
	 * Método para calcular el número de pasos que da la tortuga en un turno.
	 * @return devuelve el número de pasos que avanza la tortuga en un turno.
	 */
	
	public int PasosTortuga() {
		Random ran = new Random();
		dadoTortuga = ran.nextInt(3)+1;
		
		return dadoTortuga;
	}

}
