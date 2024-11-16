package application;

public interface TaulerDisponibilitat {
	
	boolean[][] getMartrix(); //retorna la matriu completa
	int getLlargada();
	int getAmplada();
	void setLlargada(int ll);
	void setAmplada(int am);
	void posDescoberta(int i, int j);
	

}
