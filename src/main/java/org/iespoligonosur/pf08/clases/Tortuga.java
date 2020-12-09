package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador Tortuga.
 * 
 * @author Grupo A1.
 *
 */
public class Tortuga extends JugadorBasico {

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

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoJugador getTipo() {
		return TipoJugador.TORTUGA;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void resetea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanza() {
		PasosTortuga();
	}


}
