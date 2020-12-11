package org.iespoligonosur.pf08.main;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.Tortuga;

public class ProgramaCarrera {

	// Array con los jugadores
	private static IJugador[] jugadores = new IJugador[6];
	private int longitudPistaCarreras = 100;
	private int turno;
	private LocalDateTime inicioPartida;
	private LocalDateTime finalPartida;

	public ProgramaCarrera() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Este metodo ejecutara el programa de Carreras El usuario debe poder realizar
	 * tantas carreras como quiera Se pueden repetir carreras con los usuarios
	 * creados Se pueden repetir carreras creando nuevos usuarios
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		creaJugadores();
		System.out.println(Arrays.toString(jugadores));
		// Para ver que los jugadores se han creado, no aparece completo porque no esta creado el to string
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
	 * usuario que introduce los datos a travÃ©s de la consola.
	 */
	private static void creaJugadores() {
		int opcionElegida;
		try {
			Scanner teclado = new Scanner(System.in);
			
			for (int i = 0; i < 6; i++) {
				System.out.println("\nSeleccione el tipo de jugador a crear: ");
				System.out.println("1. Tortuga");
				System.out.println("2. Liebre");
				System.out.println("3. Correcaminos");

				opcionElegida = teclado.nextInt();
				teclado.nextLine();
				switch (opcionElegida) {
				case 1: {
					System.out.println("¿Qué nombre le quieres poner a la Tortuga?");
					
					String nombre = teclado.nextLine();
					Tortuga t = new Tortuga(nombre);
					jugadores[i] = t;
					break;
				}

				case 2: {
					System.out.println("¿Qué nombre le quieres poner a la Liebre?");
					String nombre = teclado.nextLine();
					Liebre l = new Liebre(nombre);
					jugadores[i] = l;
					break;
				}

				case 3: {
					System.out.println("¿Qué nombre le quieres poner al Correcaminos?");
					String nombre = teclado.nextLine();
					CorreCaminos c = new CorreCaminos(nombre);
					jugadores[i] = c;
					break;
				}
				default:
					throw new IllegalArgumentException("Opción inválida: " + opcionElegida);
				}

			}
			teclado.close();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("Valor inesperado");
		}
	}

	/**
	 * Este metodo inicia la partida con los jugadores ya previamente creados por el
	 * usuario La partida termina cuando cualquiera de los jugadores recorre toda la
	 * longitud determinada para la pista alcanzando la meta.
	 */
	private void iniciaPartida() {

	}

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */
	private void pintaCarrera() {

	}

	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes de la
	 * carrea para ejecutar un turno de la carrera
	 */
	private void ejecutaTurno() {

	}

	/**
	 * Este mÃ©todo debe imprimir la estadÃ­stica de la carrera Fecha y Hora de la
	 * realizaciÃ³n DuraciÃ³n en minutos NÃºmero de participantes Ranking de
	 * participantes Velocidad Punta MÃ¡xima y Jugador que la alcanzÃ³ Velocidad
	 * Media mÃ¡s alta y jugador que la alcanzo
	 */
	private void imprimeEstadisticaCarrera() {

	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * punta
	 * 
	 * @return
	 */
	private IJugador masVeloz() {
		return null;
	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * media
	 * 
	 * @return
	 */
	private IJugador mayorMedia() {
		return null;
	}

	/**
	 * MÃ©todo que devuelve un array de Jugadores con los jugadores de la partida
	 * ordenados por puesto de carrera. En caso de que dos jugadores lleguen a meta
	 * en el mismo turno, o sin llegar a meta empaten en el numero de pasos
	 * recorridos, gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * 
	 * @return
	 */
	private IJugador[] ordenaRanking() {
		return null;
	}

}