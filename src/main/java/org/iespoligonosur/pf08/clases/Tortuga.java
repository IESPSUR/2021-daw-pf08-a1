package org.iespoligonosur.pf08.clases;

import java.util.Random;

/**
 * Clase para definir el tipo de jugador Tortuga.
 * 
 * @author Grupo A1.
 *
 */
public class Tortuga extends JugadorBasico {

	static int dadoTortuga, PasosTortuga, resultadoDado, RecorridoTortuga = 0, VelocidadMaximaTortuga = 0;

	/**
	 * Constructor de la clase Tortuga.
	 */
	public Tortuga(String nombre) {
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
		dadoTortuga = ran.nextInt(numeroCaras) + 1;

		return dadoTortuga;
	}

	/**
	 * Método para calcular el número de pasos que da la tortuga en un turno.
	 * 
	 * @return devuelve el número de pasos que avanza la tortuga en un turno.
	 */
	public static int PasosTortuga() {
		PasosTortuga = DadoBase(3);

		return PasosTortuga;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public TipoJugador getTipo() {
		return TipoJugador.TORTUGA;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		return PasosTortuga;
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {

		if (PasosTortuga > VelocidadMaximaTortuga) {
			VelocidadMaximaTortuga = PasosTortuga;
		}

		return VelocidadMaximaTortuga;
	}

	@Override
	public void resetea() {
		RecorridoTortuga = 0;
		VelocidadMaximaTortuga = 0;
		PasosTortuga = 0;
	}

	@Override
	public void avanza() {
		RecorridoTortuga = RecorridoTortuga + PasosTortuga();
	}

	@Override
	public int getPasosTotales() {
		return RecorridoTortuga;
	}

}