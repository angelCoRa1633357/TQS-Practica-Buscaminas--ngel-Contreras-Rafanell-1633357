package application;

public interface Model {
	
	void inicialitzaMatvalors(int i, int j); //inicialitza la matriu de valors 
	boolean isPrimerClic();//mira la matriu de disponibilitat
	int[][] getValosr(int i, int j);//Dona un array d'arrays amb tres pocision [[valor, posX,posY],...], ja que cuan clici una posciocio buida s'expandeixi els clics. Nomes retornara les pocicions que encara no han estat seleccionades.
	
	
	

}
