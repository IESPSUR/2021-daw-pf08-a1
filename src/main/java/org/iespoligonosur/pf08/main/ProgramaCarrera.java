package org.iespoligonosur.pf08.main;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
<<<<<<< HEAD
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;
=======
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c

import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.IJugador;
<<<<<<< HEAD
import org.iespoligonosur.pf08.clases.JugadorBasico;
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.DadoBase;
import org.iespoligonosur.pf08.clases.CorreCaminos;
import org.iespoligonosur.pf08.clases.TipoJugador;
import org.iespoligonosur.pf08.clases.Tortuga;
import org.iespoligonosur.pf08.clases.IDado;

public class ProgramaCarrera {

	
=======
import org.iespoligonosur.pf08.clases.Liebre;
import org.iespoligonosur.pf08.clases.Tortuga;

public class ProgramaCarrera {

>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
	// Array con los jugadores
	private static IJugador[] jugadores = new IJugador[6];
	private int longitudPistaCarreras = 100;
	private int turno;
	private static LocalDateTime inicioPartida;
	private LocalDateTime finalPartida;
<<<<<<< HEAD
	
	
=======

>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
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
<<<<<<< HEAD
		iniciaPartida();
		System.out.println(Arrays.toString(jugadores));
		imprimeEstadisticaCarrera();
		ejecutaTurno();
		
		int resNumCarrera;
		String nombre = "";
		int velocidadPunta = 0;
		int ultimaTirada = 0;
		int recorrido = 0;
		
			
			
		
=======
		System.out.println(Arrays.toString(jugadores));
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
		// Para ver que los jugadores se han creado, no aparece completo porque no esta creado el to string
	}

	/**
	 * Este metodo se encarga de crear uno a uno hasta 6 jugadores con la ayuda del
<<<<<<< HEAD
	 * usuario que introduce los datos a través de la consola.
=======
	 * usuario que introduce los datos a travÃ©s de la consola.
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
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
<<<<<<< HEAD
	
=======
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c

				opcionElegida = teclado.nextInt();
				teclado.nextLine();
				switch (opcionElegida) {
				case 1: {
<<<<<<< HEAD
					System.out.println("�Qu� nombre le quieres poner a la Tortuga?");
=======
					System.out.println("¿Qué nombre le quieres poner a la Tortuga?");
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
					
					String nombre = teclado.nextLine();
					Tortuga t = new Tortuga(nombre);
					jugadores[i] = t;
					break;
				}

				case 2: {
<<<<<<< HEAD
					System.out.println("�Qu� nombre le quieres poner a la Liebre?");
=======
					System.out.println("¿Qué nombre le quieres poner a la Liebre?");
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
					String nombre = teclado.nextLine();
					Liebre l = new Liebre(nombre);
					jugadores[i] = l;
					break;
				}

				case 3: {
<<<<<<< HEAD
					System.out.println("�Qu� nombre le quieres poner al Correcaminos?");
=======
					System.out.println("¿Qué nombre le quieres poner al Correcaminos?");
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
					String nombre = teclado.nextLine();
					CorreCaminos c = new CorreCaminos(nombre);
					jugadores[i] = c;
					break;
				}
<<<<<<< HEAD
				
				default:
					throw new IllegalArgumentException("Opci�n inv�lida: " + opcionElegida);
				}
				System.out.println("Creado jugador");
=======
				default:
					throw new IllegalArgumentException("Opción inválida: " + opcionElegida);
				}

>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
			}
			teclado.close();
		} catch (InputMismatchException e) {
			throw new IllegalArgumentException("Valor inesperado");
<<<<<<< HEAD
			
		
		}
		System.out.println("La carrera va a comenzar");
	}

	
=======
		}
	}

>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
	/**
	 * Este metodo inicia la partida con los jugadores ya previamente creados por el
	 * usuario La partida termina cuando cualquiera de los jugadores recorre toda la
	 * longitud determinada para la pista alcanzando la meta.
	 */
<<<<<<< HEAD
	private static void iniciaPartida() {
		inicioPartida = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = inicioPartida.format(formatter);
		
		System.out.println("|| LA CARRERA HA COMENZADO ||" + formatDateTime + " ||");
		
		for (int i = 0; i < 2; i++) {
			
			
		}
		
		
				
			}
		

	
=======
	private void iniciaPartida() {

	}
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c

	/**
	 * Este metodo realiza una representacion grafica en consola de la pista y la
	 * posicion de los jugadores en la misma
	 */
<<<<<<< HEAD
	private static void pintaCarrera() {
	
		
		
	}
=======
	private void pintaCarrera() {

	}

>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
	/**
	 * Este metodo llama al metodo avanza para cada uno de los participantes de la
	 * carrea para ejecutar un turno de la carrera
	 */
<<<<<<< HEAD
	private static void ejecutaTurno() {
		for (int i=0;i<6;i++)
			jugadores[i].avanza();
	}

	/**
	 * Este método debe imprimir la estadística de la carrera Fecha y Hora de la
	 * realización Duración en minutos Número de participantes Ranking de
	 * participantes Velocidad Punta Máxima y Jugador que la alcanzó Velocidad
	 * Media más alta y jugador que la alcanzo
	 */
	private static void imprimeEstadisticaCarrera() {
		Date objDate = new Date(); // Sistema actual La fecha y la hora se asignan a objDate 
		 
        System.out.println(objDate); 
        String strDateFormat = "hh: mm: ss a dd/MMM/YYYY"; // El formato de fecha est� especificado  
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); // La cadena de formato de fecha se pasa como un argumento al objeto 
          System.out.println("La carrera se celebra en "+objSDF.format(objDate));
		
		
		
	
=======
	private void ejecutaTurno() {

	}

	/**
	 * Este mÃ©todo debe imprimir la estadÃ­stica de la carrera Fecha y Hora de la
	 * realizaciÃ³n DuraciÃ³n en minutos NÃºmero de participantes Ranking de
	 * participantes Velocidad Punta MÃ¡xima y Jugador que la alcanzÃ³ Velocidad
	 * Media mÃ¡s alta y jugador que la alcanzo
	 */
	private void imprimeEstadisticaCarrera() {
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c

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
<<<<<<< HEAD
	 * Método que devuelve un array de Jugadores con los jugadores de la partida
=======
	 * MÃ©todo que devuelve un array de Jugadores con los jugadores de la partida
>>>>>>> ecef5bfdf75ea0ab8baab4610063fa5c6847f55c
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