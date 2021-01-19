package org.iespoligonosur.pf08.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.time.temporal.ChronoUnit.MINUTES;

import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.IJugador;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.Tortuga;

public class ProgramaCarrera {

	// Array con los jugadores
	private static IJugador[] jugadores = new IJugador[6];
	private static int longitudPistaCarreras = 100;
	private static int turno;
	private static int numjugadores;
	private static LocalDateTime inicioPartida;
	private static LocalDateTime finalPartida;
	private static IJugador[] MediaVeloz = new IJugador[6];
	private static IJugador[] MasVeloz = new IJugador[6];
	private static int[] RankingJugadores = new int[6];
	private static Scanner teclado;

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
		teclado = new Scanner(System.in);
		creaJugadores();
		iniciaPartida();
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
	 * usuario que introduce los datos a través de la consola.
	 */
	private static void creaJugadores() {
		System.out.println("¿Cuantos jugadores habrá? (2-6): ");
		numjugadores = teclado.nextInt();

		int opcionElegida;
		try {

			for (int i = 0; i < numjugadores; i++) {
				System.out.println("Seleccione el tipo de jugador a crear: ");
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
	private static void iniciaPartida() {
		inicioPartida = LocalDateTime.now();
		int RecorridoGlobal = 0;

		DateTimeFormatter formatterInicio = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTimeInicio = inicioPartida.format(formatterInicio);

		System.out.println("|| LA CARRERA A COMENZADO || " + formatDateTimeInicio + " ||");
		System.out.println("---------------|| PISTA DE CARRERA ||---------------");

		while (RecorridoGlobal < longitudPistaCarreras) {
			// Hacemos que los turnos se realicen en intervalos de 1 segundos.
			System.out.println("**Lanzando dados**");
			/*try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println(e);
			}*/
			for (int i = 0; i < numjugadores; i++) {
				ejecutaTurno(i);
				int pasosTotalesJugador = jugadores[i].getPasosTotales();
				if (pasosTotalesJugador > RecorridoGlobal) {
					RecorridoGlobal = jugadores[i].getPasosTotales();
				}
				pintaCarrera(i, jugadores[i].getPasosTotales());
			}
			System.out.println("");
			++turno;
		}
		System.out.println("La carrera ha durado " + turno + " turnos");

		imprimeEstadisticaCarrera();

	}

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */
	private static void pintaCarrera(int i, int UltimaTirada) {

		System.out
				.println("Jugador: " + jugadores[i].getNombre() + " Pasos totales: " + jugadores[i].getPasosTotales());
		for (int j = 0; j < UltimaTirada; j++) {
			System.out.print("-");
		}
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
	 * Este método debe imprimir la estadística de la carrera Fecha y Hora de la
	 * realización Duración en minutos Número de participantes Ranking de
	 * participantes Velocidad Punta Máxima y Jugador que la alcanzó Velocidad Media
	 * más alta y jugador que la alcanzo
	 */
	private static void imprimeEstadisticaCarrera() {

		finalPartida = LocalDateTime.now();
		DateTimeFormatter formatterFinal = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateFinalPartida = finalPartida.format(formatterFinal);

		System.out.println("|| LA CARRERA A FINALIZADO || " + formatDateFinalPartida + " ||");
		System.out.println("---------------|| ESTADISTICAS ||---------------");
		System.out.println("Duración en Minutos: " + MINUTES.between(inicioPartida, finalPartida));
		System.out.println("Número de participantes: " + numjugadores);
		masVeloz();
		System.out.println("Velocidad Punta Máxima: " + MasVeloz[0].getVelocidadAlcanzadaMaxima() + " Jugador: "
				+ MasVeloz[0].getNombre());
		mayorMedia();
		System.out.println("Velocidad Media más alta: " + MediaVeloz[0].getNombre());

		System.out.println("---------------|| RANKING ||---------------");
		ordenaRanking();

		for (int i = 0; i < numjugadores; i++) {
			int puesto = i + 1;
			System.out.print(puesto + ". " + jugadores[i].getNombre());

			if (i < numjugadores - 1) {
				System.out.print(" || ");
			}
		}

	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * punta
	 * 
	 * @return
	 */
	private static IJugador[] masVeloz() {

		int[] VelozMax = new int[numjugadores];

		for (int i = 0; i < numjugadores; i++) {
			VelozMax[i] = jugadores[i].getVelocidadAlcanzadaMaxima();
			MasVeloz[i] = jugadores[i];
		}

		for (int a = 0; a < VelozMax.length; a++) {
			for (int b = a + 1; b < VelozMax.length; b++) {

				if (VelozMax[a] < VelozMax[b]) {

					int vel = VelozMax[a];
					IJugador JugVel = jugadores[a];

					VelozMax[a] = VelozMax[b];
					VelozMax[b] = vel;

					MasVeloz[a] = MasVeloz[b];
					MasVeloz[b] = JugVel;
				}
			}
		}

		return MasVeloz;
	}

	/**
	 * Devuelve del array de participantes el jugador que alcanzo la mayor velocidad
	 * media
	 * 
	 * @return
	 */
	private static IJugador[] mayorMedia() {

		int[] MaxMedia = new int[numjugadores];

		for (int i = 0; i < MaxMedia.length; i++) {
			MaxMedia[i] = jugadores[i].getPasosTotales() / turno;
			MediaVeloz[i] = jugadores[i];
		}

		for (int a = 0; a < MaxMedia.length; a++) {
			for (int b = a + 1; b < MaxMedia.length; b++) {

				if (MaxMedia[a] < MaxMedia[b]) {

					int vel = MaxMedia[a];
					IJugador JugVel = jugadores[a];

					MaxMedia[a] = MaxMedia[b];
					MaxMedia[b] = vel;

					MediaVeloz[a] = MediaVeloz[b];
					MediaVeloz[b] = JugVel;
				}
			}
		}

		return MediaVeloz;
	}

	/**
	 * Método que devuelve un array de Jugadores con los jugadores de la partida
	 * ordenados por puesto de carrera. En caso de que dos jugadores lleguen a meta
	 * en el mismo turno, o sin llegar a meta empaten en el numero de pasos
	 * recorridos, gana aquel que su velocidad en el ultimo turno fuera mas alta
	 * 
	 * @return
	 */
	private static IJugador[] ordenaRanking() {

		for (int a = 0; a < numjugadores; a++) {
			for (int b = a + 1; b < numjugadores; b++) {

				if (RankingJugadores[a] < RankingJugadores[b]) {
					int ran = RankingJugadores[a];
					IJugador ranking = jugadores[a];
					RankingJugadores[a] = RankingJugadores[b];
					RankingJugadores[b] = ran;
					jugadores[a] = jugadores[b];
					jugadores[b] = ranking;
				}

			}

		}
		return jugadores;
	}

}
