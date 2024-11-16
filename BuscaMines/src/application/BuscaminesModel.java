package application;
import java.util.ArrayList;
import java.util.Arrays;

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
		invariants();
		
		
	}
	
	
	public void inicialitzaMatvalors(int i, int j) {
		invariants();
		
		assert(i>=0 && this.llargada>i);
		assert(j>=0 && this.amplitud>j);
		TaulerV.initMat(i,j);
		TaulerD.posDescoberta(i,j);
		
		invariants();
	}
	
	public int[][] getValosr(int i, int j){
		invariants();
		assert(i>=0 && this.llargada>i);
		assert(j>=0 && this.amplitud>j);
		
		int[][] matV=TaulerV.getMat();
		boolean[][] matDisp = TaulerD.getMartrix();
		int[][] v = {{}};
		if(matDisp[i][j] == false) {
			
			TaulerD.posDescoberta(i, j);
			ArrayList<int[]> arrayBusca = new ArrayList<>();//es guarda tots el zeros, ja que es on es fara la cerca.
			ArrayList<int[]> arrayValors = new ArrayList<>();

			arrayValors.add(new int[] {matV[i][j],i,j});
			
			if(matV[i][j]==0) {//nomes farem la busqueda d'altres pocisions, si la inicial es 0
				
				arrayBusca.add(new int[] {i,j});
			}
			
			while(arrayBusca.size()>0 ) {
				
				int posi = arrayBusca.get(0)[0];
				int posj = arrayBusca.get(0)[1];
				
				arrayBusca.remove(0);
				
				for(int k=-1;i<2;i++) {
					for(int l=-1;l<2;l++) {
						int auxPosi = posi + k;
						int auxPosj = posj + l;
						if((auxPosi>=0 && this.llargada>auxPosi) || (auxPosj>=0 && this.amplitud>auxPosj)) {
 
							int val = matV[auxPosi][auxPosj];
							int[] objectiu = new int[] {val,auxPosi,auxPosj};
							
							boolean trobat = false;
						    for (int[] fila : arrayValors) {
						    	if (Arrays.equals(fila, objectiu)) {
						    	trobat = true;
						        break;
						    	}
						    }
						    if(!trobat) {
						    	TaulerD.posDescoberta(auxPosi,auxPosj);
						    	arrayBusca.add(objectiu);
						    	if(val==0) {
						    		arrayBusca.add(new int[] {auxPosi,auxPosj});
						    	}
						    	 
						    }
						     
						     
						}
						
					}
				}
			}
			
			v = new int[arrayValors.size()][3];
			for(int k=0;k<arrayValors.size();k++) {
				for(int l=0;l<3;l++) {
					v[k][l] = arrayValors.get(k)[l];
				}
			}
		}
		
		invariants();
		for(int k=0;k<v.length;k++) {
			assert(v[k][0]>-1 && v[k][0]<9 );
			assert(v[k][1]>=0 && this.llargada>v[k][1]);
			assert(v[k][2]>=0 && this.amplitud>v[k][2]);
			
			
		}
		return v; //valor temporal
	}
	public boolean isBomba(int i, int j) {
		invariants();
		assert(i>=0 && this.llargada>i);
		assert(j>=0 && this.amplitud>j);
		
		int[][] matV=TaulerV.getMat();
		
		boolean res = (matV[i][j]==-1);
		
		invariants();
		return res; //valor temporal
	}
	
	public int getLlargada() {
		invariants();
		return this.llargada;
	}
	
	public int getAmplada() {
		invariants();
		return this.amplitud;
	}
	
	public int getNumMines() {
		invariants();
		return this.numMines;
	}
	
	
	

}
