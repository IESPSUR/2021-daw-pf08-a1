package org.iespoligonosur.pf08.clases;

import org.iespoligonosur.pf08.clases.DadoBase;
import java.util.Random;

/**
 * Clase para definir el tipo de jugador Tortuga.
 * @author Grupo A1.
 *
 */
public class Tortuga {
	
	int dadoTortuga, resultadoDado;
	
	/**
	 * Constructor de la clase Tortuga.
	 */
	public Tortuga() {
		
	}
	
	/**
	 * Método para lanzar un dado.
	 * @param numeroCaras número de caras que tiene el dado.
	 * @return devuelve el número resultado de lanzar el dado.
	 */
	public int DadoBase(int numeroCaras) {
		Random ran = new Random();
		resultadoDado = ran.nextInt(numeroCaras)+1;
		
		return resultadoDado;
	}
	
	/**
	 * Método para calcular el número de pasos que da la tortuga en un turno.
	 * @return devuelve el número de pasos que avanza la tortuga en un turno.
	 */
	public int PasosTortuga() {
		dadoTortuga = DadoBase(3);
		
		return dadoTortuga;
	}

}
