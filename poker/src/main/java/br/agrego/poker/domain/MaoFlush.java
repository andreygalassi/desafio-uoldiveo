package br.agrego.poker.domain;


/**
 * Flush: Mão contém 5 cartas do mesmo naipe. Quando as mãos forem iguais ganha quem tiver a carta mais alta.
 */
public class MaoFlush extends Mao {

	public MaoFlush(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		Carta cAnterior=null;
		for (Carta cAtual : getCartas()) {
			if (cAnterior==null) {
				cAnterior = cAtual;
				continue;
			}
			if (cAnterior.getNaipe()!=cAtual.getNaipe()) return proximo().avalia(getCartas());
		}
		return this;
	}
	
	@Override
	public String toString() {
		return "Flush";
	}

	@Override
	public int desempate(Mao other) {
		Carta cartaThis = getCartas().iterator().next();
		Carta cartaOther = other.getCartas().iterator().next();

		if (cartaThis.getValor().getValor()>cartaOther.getValor().getValor()) {
			setCartaDesempate(cartaThis);
			return 1;
		}
		if (cartaThis.getValor().getValor()<cartaOther.getValor().getValor()) {
			setCartaDesempate(cartaOther);
			return -1;
		}
		setCartaDesempate(cartaThis);
		return 0;
	}


}
