package br.agrego.poker.domain;

/**
 * 2 das 5 cartas na mão têm o mesmo valor. Quando a mãos de ambos conter um par o maior par vence se estes valores for igual, ganha quem tiver a carta próxima carta mais alta.
 */
public class MaoPairs extends Mao {
	
	private Carta	carta;

	public MaoPairs(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		
		for (Carta carta1 : getCartas()) {
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()) {
					carta = carta1;
					return this;
				}
			}
		}

		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Pairs";
	}

	@Override
	public int desempate(Mao other) {
		for (Carta cartaOther : other.getCartas()) {
			for (Carta carta2 : other.getCartas()) {
				if (cartaOther!=carta2 && cartaOther.getValor()==carta2.getValor()) {
					if (carta.getValor()==cartaOther.getValor()) { 
						setCartaDesempate(carta);
						return 0;
					}
					if (carta.getValor().getValor()>cartaOther.getValor().getValor()) {
						setCartaDesempate(carta);
						return 1;
					}
					if (carta.getValor().getValor()<cartaOther.getValor().getValor()) {
						setCartaDesempate(cartaOther);
						return -1;
					}
				}
			}
		}
		setCartaDesempate(carta);
		return 0;
	}


}
