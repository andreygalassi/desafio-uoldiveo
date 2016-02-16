package br.agrego.poker.domain;


public class MaoPairs extends Mao {
	
	public MaoPairs(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		
		for (Carta carta1 : getCartas()) {
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()) {
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
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}


}
