package br.agrego.poker.domain;


/**
 * 3 cartas do mesmo valor e 2 cartas de mesmo valor. Quando as mãos forem iguais ganha quem tiver o trio mais alto.
 */
public class MaoFullHouse extends Mao {

	public MaoFullHouse(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		Integer qtValorDiferente=0;
		Carta cAnterior=null;
		for (Carta carta : getCartas()) {
			if (cAnterior==null) cAnterior = carta;
			if (cAnterior.getValor()!=carta.getValor()) {
				cAnterior = carta;
				qtValorDiferente++;
			}
		}
		
		if (qtValorDiferente==1)return this;

		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Full House";
	}

	@Override
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}



}
