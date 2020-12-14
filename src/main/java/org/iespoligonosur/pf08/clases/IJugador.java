package org.iespoligonosur.pf08.clases;

public interface IJugador {

	/**
	 * Devuelve el nombre del Jugador
	 * @return Nombre del jugador
	 */
	public String getNombre();
	
	/**
	 * Devuelve la tipolog�a del Jugador
	 * @return
	 */
	public TipoJugador getTipo();
	
	/**
	 * Devuelve la velocidad que alcanzo el jugador en el ultimo avance
	 * @return Velocidad del ultimo turno
	 */
	public int getVelocidadUltimoTurno();
	
	/**
	 * Almacena la velocidad m�xima que ha alcanzado el jugador durante alg�n
	 * avance
	 * @return velocidad maxima alcanzada
	 */
	public int getVelocidadAlcanzadaMaxima();
	
	/**
	 * Almacena la cantidad de pasos que ha alcanzado el jugador durante todo
	 * el juego
	 * @return pasos totales del jugador
	 */
	public int getPasosTotales();
	
	/**
	 * Resetea todos los valores internos del objeto para
	 * ponerse en disposicion de empezar una nueva partida
	 */
	public void resetea();
	
	/**
	 * Este m�todo lanza el dado del jugador que se comportara segun su tipo.
	 * El avance modifica el estado interno del objeto
	 */
	public void avanza();
}
