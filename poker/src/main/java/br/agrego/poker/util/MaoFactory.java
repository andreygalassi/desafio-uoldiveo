package br.agrego.poker.util;

import br.agrego.poker.domain.Mao;
import br.agrego.poker.domain.MaoFlush;
import br.agrego.poker.domain.MaoFourOfAKind;
import br.agrego.poker.domain.MaoFullHouse;
import br.agrego.poker.domain.MaoHighCard;
import br.agrego.poker.domain.MaoPairs;
import br.agrego.poker.domain.MaoStraight;
import br.agrego.poker.domain.MaoStraightFlush;
import br.agrego.poker.domain.MaoThreeOfKind;
import br.agrego.poker.domain.MaoTwoPairs;

public class MaoFactory {

	public static Mao controiMao() {
		Mao mao = new MaoStraightFlush(8);
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
		return mao;
	}
	
}
