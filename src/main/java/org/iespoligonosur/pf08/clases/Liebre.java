package org.iespoligonosur.pf08.clases;

/**
 * Clase para definir el tipo de jugador Liebre.
 * @author Grupo A1.
 *
 */
public class Liebre {
	
	protected int dadoLiebre, pasosLiebre;
	
	/**
	 * Constructor de la clase Liebre.
	 */
	public Liebre() {
		
	}
	
	/**
	 * Método para obtener el valor del dado lanzado por el jugador Liebre.
	 * @return devuelve el resultado de lanzar un dado de 6 caras.
	 */
	public int DadoLiebre() {
		
		Random ran = new Random();
		dadoLiebre = ran.nextInt(6)+1;
		
		return dadoLiebre;
	}
	
	/**
	 * Método para calcular el número de pasos que da la Liebre en un turno.
	 * @return devuelve el número de pasos que avanza la Liebre en un turno.
	 */
	public int PasosLiebre() {
		
		if (dadoLiebre == 3) {
			pasosLiebre = 3;
		} else {
			
		}
		
		return pasosLiebre;
	}
	
	

}