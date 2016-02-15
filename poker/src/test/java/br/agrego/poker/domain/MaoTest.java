package br.agrego.poker.domain;

import static org.junit.Assert.assertEquals;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class MaoTest {
	
	private Mao	mao;
	
	@Before
	public void init() {
		mao = new MaoStraightFlush();
		Mao m7 = new MaoFourOfAKind();
		Mao m6 = new MaoFullHouseh();
		Mao m5 = new MaoFlush();
		Mao m4 = new MaoThreeOfKind();
		Mao m3 = new MaoTwoPairs();
		Mao m2 = new MaoPairs();
		Mao m1 = new MaoHighCard();
		
		mao.setProximo(m7);
		m7.setProximo(m6);
		m6.setProximo(m5);
		m5.setProximo(m4);
		m4.setProximo(m3);
		m3.setProximo(m2);
		m2.setProximo(m1);
	}
	
	@Test
	public void testaMaoHighCard() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.AS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas.add(new Carta(ENaipe.OUROS, EValor.DAMA));
		assertEquals(MaoHighCard.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaMaoPairs() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.AS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.DEZ));
		assertEquals(MaoPairs.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaMaoTwoPairs() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.AS));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.AS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas.add(new Carta(ENaipe.OUROS, EValor.DEZ));
		assertEquals(MaoTwoPairs.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaMaoThreeOfKind() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.AS));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.DEZ));
		cartas.add(new Carta(ENaipe.COPAS, EValor.DEZ));
		cartas.add(new Carta(ENaipe.OUROS, EValor.DEZ));
		assertEquals(MaoThreeOfKind.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaMaoStraight() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.DOIS));
		cartas.add(new Carta(ENaipe.COPAS, EValor.QUATRO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.TRES));
		cartas.add(new Carta(ENaipe.COPAS, EValor.SEIS));
		cartas.add(new Carta(ENaipe.OUROS, EValor.CINCO));
		assertEquals(MaoStraight.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaMaoFlush() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.OUROS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.QUATRO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.SEIS));
		cartas.add(new Carta(ENaipe.OUROS, EValor.OUITO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.AS));
		assertEquals(MaoFlush.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaFullHouseh() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.OUROS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.QUATRO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.SEIS));
		cartas.add(new Carta(ENaipe.OUROS, EValor.OUITO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.SETE));
		assertEquals(MaoFullHouseh.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaFourOfAKind() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.CINCO));
		cartas.add(new Carta(ENaipe.COPAS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.ESPADA, EValor.QUATRO));
		assertEquals(MaoFourOfAKind.class, mao.avalia(cartas).getClass()); 
	}
	
	@Test
	public void testaStraightFlush() {
		Set<Carta> cartas = new TreeSet<Carta>();
		cartas.add(new Carta(ENaipe.OUROS, EValor.CINCO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.QUATRO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.SEIS));
		cartas.add(new Carta(ENaipe.OUROS, EValor.OUITO));
		cartas.add(new Carta(ENaipe.OUROS, EValor.SETE));
		assertEquals(MaoStraightFlush.class, mao.avalia(cartas).getClass()); 
	}
}
