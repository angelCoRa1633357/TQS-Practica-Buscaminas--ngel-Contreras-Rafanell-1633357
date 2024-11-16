package application;
import java.util.ArrayList;

public class BuscaminesModel implements Model {
	private int llargada;
	private int amplitud;
	private int numMines;
	private TaulerValors TaulerV;
	private TaulerDisponibilitat TaulerD; 
	
	private void invariants() {
		assert(llargada>0);
		assert(amplitud>0);
		assert(numMines<(llargada*amplitud));
		
	}
	
	
	public BuscaminesModel(int ll, int am, int nM, TaulerValors Tv,TaulerDisponibilitat Td ) {
		assert(ll>0);
		assert(am>0);
		assert(nM<(ll*am));
		this.llargada = ll;
		this.amplitud = am;
		this.numMines = nM;
		TaulerV = Tv;
		TaulerD = Td;
		
		this.TaulerV.setLlargada(ll);
		this.TaulerV.setAmplada(am);
		this.TaulerV.setMines(nM);
		
		this.TaulerD.setLlargada(ll);
		this.TaulerD.setAmplada(am);
		
		
	}
	
	
	public void inicialitzaMatvalors(int i, int j) {
		invariants();
		assert(i>=0 && this.llargada>i);
		assert(j>=0 && this.amplitud>j);
		TaulerV.initMat(i,j);
		TaulerD.posDescoberta(i,j);
	}
	
	public int[][] getValosr(int i, int j){
		int v[][] = {{0}};
		return v; //valor temporal
	}
	public boolean isBomba(int i, int j) {
		return true; //valor temporal
	}
	
	public int getLlargada() {
		return this.llargada;
	}
	
	public int getAmplada() {
		return this.amplitud;
	}
	
	public int getNumMines() {
		return this.numMines;
	}
	
	
	

}
