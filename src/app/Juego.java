package app;

import java.util.Scanner;

import modelo.HayBlackjackException;
import modelo.Mano;
import modelo.Masde21Exception;
import modelo.Mazo;
import modelo.NoHayMasCartasException;

public class Juego {

	public static void main(String[] args) {
		// Creamos una baraja con todas las cartas
		Mazo baraja = new Mazo();
		
		// Barajamos
		baraja.barajar();
		
		// Creamos la mano de cartas para el jugador
		Mano jugador = new Mano();
		
		//Creamos la mano de cartas para la banca
		Mano banca = new Mano();
		
		System.out.println("Comenzando el juego. Repartiendo una carta...");
		try {
			banca.pedirCarta(baraja);
			jugador.pedirCarta(baraja);
			
		System.out.println("Repartiendo otra carta...");

		try {
			banca.pedirCarta(baraja);
		} catch (HayBlackjackException e) {
			
		}
		
			jugador.pedirCarta(baraja);
			
			System.out.println("Jugador, tu mano es: "+jugador);
			
			
		} catch (HayBlackjackException e) {
			
			System.out.println("¡Has conseguido Blackjack!");
			System.out.println(jugador);
			
		} catch (Exception e) {
			
		} 
		
		Scanner teclado = new Scanner(System.in);
		String opcion;
		try {
			if (!jugador.finDeJuego()) {
				do {
				System.out.println("¿Quieres otra carta? S/N");
				opcion = teclado.nextLine();

				if (opcion.equalsIgnoreCase("S")) {
					jugador.pedirCarta(baraja);
					
					System.out.println("Jugador, tu mano es: "+jugador);
	
				}
			} while (opcion.equalsIgnoreCase("S"));
				System.out.println("Te has plantado");
			}
			
			} catch (NoHayMasCartasException e) {
				
					} catch (Masde21Exception e) { 
						System.out.println("Te has pasado... "+jugador);
						return;
					} catch (HayBlackjackException e) {
						System.out.println("¡Has conseguido Blackjack!"+jugador);
					}
	
		// Juega la banca, la banca debe pedir carta hasta conseguir al meos 16 pts.
		
				try {
					while (banca.valorMano()<=16) {
						banca.pedirCarta(baraja);
					}
				} catch (NoHayMasCartasException e) {
				} catch (Masde21Exception e) {
					System.out.println("Banca: "+banca);
					System.out.println("La banca se ha pasado");
					
					if (jugador.valorMano()<=21) {
						System.out.println("Gana el jugador");
					} else {
						System.out.println("No hay ganadores");
					}
					return;
				} catch (HayBlackjackException e) {
					System.out.println("Banca: "+banca);
					if(jugador.valorMano()==21) {
						System.out.println("Empate");
					} else {
						System.out.println("Gana la banca");
					}
					return;
				}
		
			// Comprobar quien gana
				System.out.println("Banca: "+banca);
				if(jugador.valorMano()<banca.valorMano()) {
					System.out.println("Gana la banca");
				} else {
					System.out.println("El jugador gana");
				}
		
	}
}
