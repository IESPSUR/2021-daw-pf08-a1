package org.iespoligonosur.pf08.clases;

import org.iespoligonosur.pf08.clases.DadoBase;
import java.util.Random;

/**
 * Clase para definir el tipo de jugador Liebre.
 * @author Grupo A1.
 *
 */
public class Liebre {
	
	protected int dadoLiebre, pasosLiebre, resultadoDado;
	
	/**
	 * Constructor de la clase Liebre.
	 */
	public Liebre() {
		
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
	 * Método para calcular el número de pasos que da la Liebre en un turno.
	 * @return devuelve el número de pasos que avanza la Liebre en un turno.
	 */
	public int PasosLiebre() {
		
		int dadoLiebre = DadoBase(6);
		
		if (dadoLiebre == 3) {
			pasosLiebre = 3;
		} else {
			
		}
		
		return pasosLiebre;
	}
	
	

}
