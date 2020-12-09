package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador CorreCaminos.
 * 
 * @author Grupo A1.
 *
 */
public class CorreCaminos extends JugadorBasico {

	protected static int dadoCorreCaminos, VelocidadMaximaCorreCaminos = 0, PasosCorreCaminos, resultadoDado;

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
		dadoCorreCaminos = ran.nextInt(numeroCaras) + 1;

		return dadoCorreCaminos;
	}

	/**
	 * Método para calcular el número de pasos que da el CorreCaminos en un turno,
	 * solo avanza si es número par, en caso contrario avanzará 0 pasos.
	 * 
	 * @return devuelve el número de pasos que avanza el CorreCaminos en un turno.
	 */
	public static int PasosCorrecaminos() {

		PasosCorreCaminos = DadoBase(10);

		if (PasosCorreCaminos % 2 == 0) {
			return PasosCorreCaminos;
		} else {
			return 0;
		}
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoJugador getTipo() {
		return TipoJugador.CORRECAMINOS;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {

		if (PasosCorreCaminos > VelocidadMaximaCorreCaminos) {
			VelocidadMaximaCorreCaminos = PasosCorreCaminos;
		}

		return VelocidadMaximaCorreCaminos;
	}

	@Override
	public void resetea() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanza() {
		PasosCorrecaminos();
	}

}
