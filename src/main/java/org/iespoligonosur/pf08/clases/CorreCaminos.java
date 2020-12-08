package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador CorreCaminos.
 * @author Grupo A1.
 *
 */
public class CorreCaminos {
	
	protected int dadoCorreCaminos, pasosCorreCaminos ;
	
	/**
	 * Constructor de la clase CorreCaminos.
	 */
	public CorreCaminos() {
		
	}
	
	/**
	 * Método para obtener el valor del dado lanzado por el jugador CorreCaminos.
	 * @return devuelve el resultado de lanzar un dado de 10 caras.
	 */
	public int DadoCorreCaminos() {
		
		Random ran = new Random();
		dadoCorreCaminos = ran.nextInt(10)+1;
		
		return dadoCorreCaminos;
	}
	
	/**
	 * Método para calcular el número de pasos que da el CorreCaminos en un turno, solo avanza si es número par, en caso contrario avanzará 0 pasos.
	 * @return devuelve el número de pasos que avanza el CorreCaminos en un turno.
	 */
	public int PasosCorrecaminos() {
		
		pasosCorreCaminos = dadoCorreCaminos;
		
        if(dadoCorreCaminos % 2 == 0) {
            return pasosCorreCaminos;
        } else {
            return 0;
        }
	}

}
