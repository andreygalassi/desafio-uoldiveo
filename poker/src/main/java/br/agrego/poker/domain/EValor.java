package br.agrego.poker.domain;

public enum EValor {
	DOIS("2",2),
	TRES("3",3),
	QUATRO("4",4),
	CINCO("5",5),
	SEIS("6",6),
	SETE("7",7),
	OUITO("8",8),
	NOVE("9",9),
	DEZ("10",10),
	VALETE("J",11),
	DAMA("Q",12),
	REI("K",13),
	AS("A",14);
	
	private String simbolo;
	private Integer valor;
	
	EValor(String simbolo,Integer valor) {
		this.simbolo = simbolo;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return simbolo;
	}

	public Integer getValor() {
		return valor;
	}
}