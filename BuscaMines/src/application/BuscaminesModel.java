package application;

public class BuscaminesModel implements Model {
	private int llargada;
	private int amplitud;
	private int numMines;
	private TaulerValors TaulerV;
	private TaulerDisponibilitat TaulerD; 
	
	
	public BuscaminesModel(int llargada, int amplitud, int numMines, TaulerValors Tv,TaulerDisponibilitat Td ) {
		
	}
	
	
	public void inicialitzaMatvalors(int i, int j) {
		
	}
	
	public int[][] getValosr(int i, int j){
		int v[][] = {{0}};
		return v; //valor temporal
	}
	public boolean isBomba(int i, int j) {
		return true; //valor temporal
	}
	
	private int getLlargada() {
		return 0;
	}
	
	private int getAmplada() {
		return 0;
	}
	
	private int getNumMines() {
		return 0;
	}
	
	
	

}
