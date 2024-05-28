package modelo;

import java.util.ArrayList;

public class Mano extends Mazo {

	public Mano() {
		this.cartas = new ArrayList<Carta>();
	}

	public int valorMano() {
		int valor=0;
		for(Carta c : this.cartas) {
			valor = valor + c.getValor();
		}
		return valor;
	}
}
