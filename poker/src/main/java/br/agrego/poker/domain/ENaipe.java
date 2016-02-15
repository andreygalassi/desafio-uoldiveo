package br.agrego.poker.domain;

public enum ENaipe {
	PAUS("P"),
	COPAS("C"),
	OUROS("O"),
	ESPADA("E");
	
	private String simbolo;
	
	ENaipe(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public String toString() {
		return simbolo;
	}
}
