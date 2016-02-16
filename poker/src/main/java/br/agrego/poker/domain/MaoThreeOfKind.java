package br.agrego.poker.domain;


public class MaoThreeOfKind extends Mao {

	public MaoThreeOfKind(Integer ponto) {
		super(ponto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mao executa() {
		boolean trio = false;
		for (Carta carta1 : getCartas()) {
			trio = false;
			for (Carta carta2 : getCartas()) {
				if (carta1!=carta2 && carta1.getValor()==carta2.getValor()&&!trio) {
					trio = true;
				}else if(carta1!=carta2 && carta1.getValor()==carta2.getValor()&&trio) {
					return this;
				}
			}
		}
		return proximo().avalia(getCartas());
	}
	
	@Override
	public String toString() {
		return "Three of Kind";
	}

	@Override
	public int desempate(Mao mao) {
		// TODO Auto-generated method stub
		return 0;
	}



}
