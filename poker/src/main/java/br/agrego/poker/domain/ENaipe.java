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
	
	public static ENaipe get(String simbolo) throws MyException {
		for (ENaipe naipe : ENaipe.values()) {
			if (naipe.simbolo.equals(simbolo)) {
				return naipe;
			}
		}
		throw new MyException("Não é um Nipe Válido");
	}
}
