package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador Tortuga.
 * 
 * @author Grupo A1.
 *
 */
public class Tortuga {

	static int dadoTortuga;
	static int resultadoDado;

	/**
	 * Constructor de la clase Tortuga.
	 */
	public Tortuga() {

	}

	/**
	 * Método para lanzar un dado.
	 * 
	 * @param numeroCaras número de caras que tiene el dado.
	 * @return devuelve el número resultado de lanzar el dado.
	 */
	public static int DadoBase(int numeroCaras) {
		Random ran = new Random();
		dadoTortuga = ran.nextInt(numeroCaras) + 1;

		return dadoTortuga;
	}

	/**
	 * Método para calcular el número de pasos que da la tortuga en un turno.
	 * 
	 * @return devuelve el número de pasos que avanza la tortuga en un turno.
	 */
	public static int PasosTortuga() {
		dadoTortuga = DadoBase(3);

		return dadoTortuga;
	}


}
