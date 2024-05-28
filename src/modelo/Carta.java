package modelo;

public class Carta {
	
	public enum Palo {
		TREBOLES, DIAMANTES, CORAZONES, PICAS
	};
	
	// ATRIBUTOS
	private int numero;
	private Palo palo;
	
	public Carta(int numero, Palo palo) {
		if (numero>0 && numero<=13) {
			this.numero = numero;
			this.palo = palo;
		}
	}

	// GETTERS
	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}
	
	public int getValor() {
		if (this.numero==1) {
			return 11;
		} else if (this.numero>=10) {
			return 10;
		} else {
			return this.numero;
		}
	}
	
	public String mostrarNumero() {
		switch (this.numero) {
		case 1: return "AS";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		default: return ""+this.numero;
		}
	}

	@Override
	public String toString() {
		return "[" + mostrarNumero() + "-" + palo + "]";
	}
	
}