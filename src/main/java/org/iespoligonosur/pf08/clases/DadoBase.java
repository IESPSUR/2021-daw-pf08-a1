package org.iespoligonosur.pf08.clases;

/**
 * Definicion de una clase base para la implementacion de dados de N caras
 * @author eserrano
 *
 */
public abstract class DadoBase implements IDado{

	protected int numeroCaras;

	public DadoBase(int numeroCaras) {
		this.numeroCaras=numeroCaras;
	}
	
	public int getDadoBase () {
		return numeroCaras;
	}

	

}
