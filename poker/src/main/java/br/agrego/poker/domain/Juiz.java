package br.agrego.poker.domain;

public class Juiz {

	private final Jogador	jogador1;
	private final Jogador	jogador2;
	private final Mao	mao;

	public Juiz(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.mao = new MaoStraightFlush(8);
		Mao m8 = new MaoFourOfAKind(7);
		Mao m7 = new MaoFullHouse(6);
		Mao m6 = new MaoStraight(5);
		Mao m5 = new MaoFlush(4);
		Mao m4 = new MaoThreeOfKind(3);
		Mao m3 = new MaoTwoPairs(2);
		Mao m2 = new MaoPairs(1);
		Mao m1 = new MaoHighCard(0);
		
		mao.setProximo(m8);
		m8.setProximo(m7);
		m7.setProximo(m6);
		m6.setProximo(m5);
		m5.setProximo(m4);
		m4.setProximo(m3);
		m3.setProximo(m2);
		m2.setProximo(m1);
	}
	
	public String avalia() {
		Mao maoJogador1 = mao.avalia(jogador1.getCartas());
		Mao maoJogador2 = mao.avalia(jogador2.getCartas());
		
		if (maoJogador1.getPonto() > maoJogador2.getPonto()) {
			return jogador1.getNome() + " wins " + maoJogador1;
		}else if (maoJogador1.getPonto() < maoJogador2.getPonto()) {
			return jogador2.getNome() + " wins " + maoJogador2;
		}else {
			if (maoJogador1.desempate(jogador1.getCartas(), jogador2.getCartas())==-1) return jogador2.getNome() + " wins " + maoJogador2;
			if (maoJogador1.desempate(jogador1.getCartas(), jogador2.getCartas())==0) return " tie " + maoJogador1;
			if (maoJogador1.desempate(jogador1.getCartas(), jogador2.getCartas())==1) return jogador1.getNome() + " wins " + maoJogador1;
		}
		return "";
		
	}
}
