package enums;

public enum StatusRegistro {
	NAO_CAPTURADO(0), CAPTURADO(1);
	
	private int valor;
	StatusRegistro(int valor){
		this.valor = valor;
	}
	
	public int getValor() {
		return this.valor;
	}
}
