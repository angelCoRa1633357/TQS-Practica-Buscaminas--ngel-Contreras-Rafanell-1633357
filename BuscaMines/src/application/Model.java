package application;

public interface Model {
	
	void inicialitzaMatvalors(int i, int j); //inicialitza la matriu de valors 
	int[][] getValosr(int i, int j);//Dona un array d'arrays amb tres pocision [[valor, posX,posY],...], ja que cuan clici una posciocio buida s'expandeixi els clics. Nomes retornara les pocicions que encara no han estat seleccionades
	boolean isBomba(int i, int j); //si es el primer clic retorna false, si no haura de mirar la taula
	
	
	

}
