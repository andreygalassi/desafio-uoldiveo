package br.agrego.poker.domain;


/**
 * Straight Flush: 5 cartas do mesmo naipe com consecutiva de naipes iguais. Quando as mãos forem iguais ganha quem tiver a sequencia mais alta.
 */
public class MaoStraightFlush extends Mao {
	
	public MaoStraightFlush(Integer ponto) {
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
			if (cAtual.getValor().getValor()==cAnterior.getValor().getValor()-1) {
				cAnterior = cAtual;
				continue;
			}else {
				return proximo().avalia(getCartas());
			}
		}
		return this;
	}

	@Override
	public String toString() {
		return "Straight Flush";
	}

	@Override
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}


}
