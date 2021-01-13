package org.iespoligonosur.pf08.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.MILLIS;

import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.Tortuga;

public class ProgramaCarrera {

	// Array con los jugadores
	private static IJugador[] jugadores = new IJugador[2];
	private static int longitudPistaCarreras = 100;
	private static int turno;
	private static LocalDateTime inicioPartida;
	private static LocalDateTime finalPartida;
	private static int UltimaTirada;

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
		iniciaPartida();
		// System.out.println(Arrays.toString(jugadores));
		// Para ver que los jugadores se han creado, no aparece completo porque no esta
		// creado el to string

		// Ejecutamos un turno.
		// ejecutaTurno();

		// Pintamos la carrera.
		// pintaCarrera();
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
	 * usuario que introduce los datos a través de la consola.
	 */
	private static void creaJugadores() {
		int opcionElegida;
		try {
			Scanner teclado = new Scanner(System.in);

			for (int i = 0; i < jugadores.length; i++) {
				System.out.println("\nSeleccione el tipo de jugador a crear: ");
				System.out.println("1. Tortuga");
				System.out.println("2. Liebre");
				System.out.println("3. Correcaminos");

				opcionElegida = teclado.nextInt();
				teclado.nextLine();
				switch (opcionElegida) {
				case 1: {
					System.out.println("�Qu� nombre le quieres poner a la Tortuga?");

					String nombre = teclado.nextLine();
					Tortuga t = new Tortuga(nombre);
					jugadores[i] = t;
					break;
				}

				case 2: {
					System.out.println("�Qu� nombre le quieres poner a la Liebre?");
					String nombre = teclado.nextLine();
					Liebre l = new Liebre(nombre);
					jugadores[i] = l;
					break;
				}

				case 3: {
					System.out.println("�Qu� nombre le quieres poner al Correcaminos?");
					String nombre = teclado.nextLine();
					CorreCaminos c = new CorreCaminos(nombre);
					jugadores[i] = c;
					break;
				}
				default:
					throw new IllegalArgumentException("Opci�n inv�lida: " + opcionElegida);
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
	private static void iniciaPartida() {
		inicioPartida = LocalDateTime.now();
		int mayorRecorridoActual = 0;

		DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTimeInicio = inicioPartida.format(formatterInicio);

		System.out.println("|| LA CARRERA HA COMENZADO || " + formatDateTimeInicio + " ||");
		System.out.println("---------------|| PISTA DE CARRERA ||---------------");

		while (mayorRecorridoActual < longitudPistaCarreras) {
			for (int i = 0; i < jugadores.length; i++) {
				ejecutaTurno(i);
				int pasosTotalesJugador = jugadores[i].getPasosTotales();
				if (pasosTotalesJugador > mayorRecorridoActual) {
					mayorRecorridoActual = pasosTotalesJugador;
				}
				/*
				 * System.out.println(jugadores[i].getNombre() + " - " +
				 * jugadores[i].getPasosTotales() + " Ultima tirada: " +
				 * jugadores[i].getVelocidadUltimoTurno() + " Global: " + RecorridoGlobal);
				 */
				// System.out.print(jugadores[i].getNombre());
				pintaCarrera(i, pasosTotalesJugador);
			}
			System.out.println("");
			turno++;
		}
		System.out.println("La carrera ha durado " + turno + " turnos \n");

		imprimeEstadisticaCarrera();

	}

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */
	private static void pintaCarrera(int i, int UltimaTirada) {
		// Hacemos que los turnos se realicen en intervalos de 2 segundos.
		/*
		 * try { Thread.sleep(2000); } catch (Exception e) { System.out.println(e); }
		 */
		System.out.print(jugadores[i].getNombre());
		for (int j = 0; j < UltimaTirada; j++) {
			System.out.print("-");
		}
		System.out.println("");
	}

	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes de la
	 * carrea para ejecutar un turno de la carrera
	 * 
	 * @param
	 */
	private static void ejecutaTurno(int i) {
		jugadores[i].avanza();
	}

	/**
	 * Este m�todo debe imprimir la estad�stica de la carrera Fecha y Hora de la
	 * realizaci�n Duraci�n en minutos N�mero de participantes Ranking de
	 * participantes Velocidad Punta M�xima y Jugador que la alcanz� Velocidad Media
	 * m�s alta y jugador que la alcanzo
	 */
	private static void imprimeEstadisticaCarrera() {

		finalPartida = LocalDateTime.now();
		DateTimeFormatter formatterFinal = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateFinalPartida = finalPartida.format(formatterFinal);

		System.out.println("|| LA CARRERA A FINALIZADO || " + formatDateFinalPartida + " ||");
		System.out.println("---------------|| ESTADISTICAS ||---------------");
		System.out.println("Duraci�n en Milisegundos: " + MILLIS.between(inicioPartida, finalPartida));
		System.out.println("Participantes: " + jugadores.length);
		// ordenaRanking();
		System.out.println("---------------|| RANKING ||---------------");
		/*
		 * for (int i = 0; i < 2; i++) { System.out.println(i + ". " +
		 * jugadores[i].getNombre());; }
		 */

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
	 * Método que devuelve un array de Jugadores con los jugadores de la partida
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