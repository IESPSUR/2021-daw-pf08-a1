package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Definicion de una clase base para la implementacion de dados de N caras
 * @author eserrano
 *
 */
public abstract class DadoBase implements IDado{

	private int numeroCaras, resultadoDado;
	
	public DadoBase(int numeroCaras) {
		Random ran = new Random();
		resultadoDado = ran.nextInt(numeroCaras)+1;
		
		return resultadoDado;
	}

}
