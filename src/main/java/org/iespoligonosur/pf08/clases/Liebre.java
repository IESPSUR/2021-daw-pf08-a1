package org.iespoligonosur.pf08.clases;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase para definir el tipo de jugador Liebre.
 * 
 * @author Grupo A1.
 *
 */
public class Liebre extends JugadorBasico {

	static int dadoLiebre, PasosLiebre, VelocidadMaximaLiebre = 0, resultadoDado, RecorridoLiebre = 0;
	static Scanner teclado;
	static String name;

	/**
	 * Constructor de la clase Liebre.
	 */
	public Liebre(String nombre) {
		this.nombre = nombre;
		name = nombre;
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
	 * Método para calcular el número de pasos que da la Liebre en un turno.
	 * 
	 * @return devuelve el número de pasos que avanza la Liebre en un turno.
	 */
	public static int PasosLiebre() {
		String resultado="" ;
		int dadoLiebre = DadoBase(6);
		teclado = new Scanner(System.in);

		if (dadoLiebre == 3) {
			PasosLiebre = 3;
		} else {
			System.out.println(name + " adivina si el número es mayor o menor a 3 (Mayor/Menor)");
			if (teclado.hasNext()){
				 resultado = teclado.nextLine();
			}
			if (resultado.equals("Mayor") && dadoLiebre > 3) {
				PasosLiebre = dadoLiebre;
			} else if (resultado.equals("Menor") && dadoLiebre < 3) {
				PasosLiebre = dadoLiebre;
			} else {
				PasosLiebre = 0;
			}
		}

		return PasosLiebre;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public TipoJugador getTipo() {
		return TipoJugador.LIEBRE;
	}

	@Override
	public int getVelocidadUltimoTurno() {
		return PasosLiebre;
	}

	@Override
	public int getVelocidadAlcanzadaMaxima() {

		if (PasosLiebre > VelocidadMaximaLiebre) {
			VelocidadMaximaLiebre = PasosLiebre;
		}

		return VelocidadMaximaLiebre;
	}

	@Override
	public void resetea() {
		RecorridoLiebre = 0;
		VelocidadMaximaLiebre = 0;
		PasosLiebre = 0;	
	}

	@Override
	public void avanza() {
		RecorridoLiebre = RecorridoLiebre + PasosLiebre();
	}

	@Override
	public int getPasosTotales() {
		return RecorridoLiebre;
	}

}