package application;

public interface TaulerDisponibilitat {
	
	boolean[][] getMartrix(); //retorna la matriu completa
	int getLlargada();
	int getAmplada();
	void posDescoberta(int i, int j);

}
