package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador CorreCaminos.
 * 
 * @author Grupo A1.
 *
 */
public class CorreCaminos extends JugadorBasico {

	protected static int dadoCorreCaminos, VelocidadMaximaCorreCaminos = 0, PasosCorreCaminos = 0, resultadoDado, RecorridoCorreCaminos = 0;

	/**
	 * Constructor de la clase CorreCaminos.
	 */
	public CorreCaminos(String nombre) {
		this.nombre = nombre;
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
		return nombre;
	}

	@Override
	public TipoJugador getTipo() {
		return TipoJugador.CORRECAMINOS;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		return PasosCorrecaminos();
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
		RecorridoCorreCaminos = 0;
		VelocidadMaximaCorreCaminos = 0;
		PasosCorreCaminos = 0;			
	}

	@Override
	public void avanza() {
		RecorridoCorreCaminos = RecorridoCorreCaminos + PasosCorrecaminos();
	}

	@Override
	public int getPasosTotales() {
		return RecorridoCorreCaminos;
	}

}
