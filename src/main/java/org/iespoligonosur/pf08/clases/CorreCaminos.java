package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador CorreCaminos.
 * 
 * @author Grupo A1.
 *
 */
public class CorreCaminos {

	protected static int dadoCorreCaminos;
	protected static int pasosCorreCaminos;
	protected static int resultadoDado;

	/**
	 * Constructor de la clase CorreCaminos.
	 */
	public CorreCaminos() {

	}

	/**
	 * Método para lanzar un dado.
	 * 
	 * @param numeroCaras número de caras que tiene el dado.
	 * @return devuelve el número resultado de lanzar el dado.
	 */
	public static int DadoBase(int numeroCaras) {
		Random ran = new Random();
		resultadoDado = ran.nextInt(numeroCaras) + 1;

		return resultadoDado;
	}

	/**
	 * Método para calcular el número de pasos que da el CorreCaminos en un turno,
	 * solo avanza si es número par, en caso contrario avanzará 0 pasos.
	 * 
	 * @return devuelve el número de pasos que avanza el CorreCaminos en un turno.
	 */
	public static int PasosCorrecaminos() {

		dadoCorreCaminos = DadoBase(10);

		pasosCorreCaminos = dadoCorreCaminos;

		if (dadoCorreCaminos % 2 == 0) {
			return pasosCorreCaminos;
		} else {
			return 0;
		}
	}

}
