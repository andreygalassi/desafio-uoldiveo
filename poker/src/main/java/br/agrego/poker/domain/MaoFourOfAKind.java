package br.agrego.poker.domain;


/**
 * Four of a kind: 4 cartas com o mesmo valor. Quando as mãos forem iguais ganha quem tiver as 4 cartas maiores.
 */
public class MaoFourOfAKind extends Mao {

	public MaoFourOfAKind(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		Integer quadra;
		for (Carta cAnterior : getCartas()) {
			quadra = 0;
			for (Carta cAtual : getCartas()) {
				if (cAnterior.getValor()==cAtual.getValor()) {
					quadra++;
				}
			}
			if (quadra==4)return this;
		}
		return proximo().avalia(getCartas());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}


}
