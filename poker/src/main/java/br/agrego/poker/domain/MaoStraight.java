package br.agrego.poker.domain;


/**
 * Straight: Mão contém 5 cartas consecutiva de naipes diferentes. Quando as mãos forem iguais ganha quem tiver o quarteto mais alto.
 */
public class MaoStraight extends Mao {

	public MaoStraight(Integer ponto) {
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
		return "Straight";
	}

	@Override
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}

}
