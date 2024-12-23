package application;

import java.util.Arrays;

public class BuscaminesTaulerValors implements TaulerValors {
	Random Rand;
	boolean matGen=false;
	int[][] mat=null;
	int Llargada=0;
	int Amplada=0;
	int mines=0;

	BuscaminesTaulerValors(Random R){
		this.Rand=R;
	}
	private boolean isPosInArray(int[][] arr,int[] pos) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0]==pos[0] && arr[i][1]==pos[1]) {
				return true;
			}
		}
		return false;
	}
	@Override
	public void initMat(int i, int j) {

		assert(this.Llargada>0);
		assert(this.Amplada>0);
		assert(this.mines>0);
		assert(i>=0 && j>=0 && i<this.Amplada && j<this.Llargada );
		//Thread.dumpStack();
		if(!matGen) {
			this.matGen=true;
			
			this.mat=new int[this.Amplada][this.Llargada];
			for(int t=0;t<this.Amplada;t++) {
				for(int y=0;y<this.Llargada;y++) {
					this.mat[t][y]=0;
				}
			}
			
			int[][] posMins = new int[this.mines][2];
			int k=0;

			while(k<this.mines) {//distribuim les mines

				int[] pos=this.Rand.Random(this.Amplada, this.Llargada);

				if(!isPosInArray(posMins,pos) && ((pos[0]!=i) || (pos[1]!=j))) {
					posMins[k][0]=pos[0];
					posMins[k][1]=pos[1];
					this.mat[pos[0]][pos[1]]=-1;
					
					k++;
					
				}
				
			}
			
			for(int l=0;l<this.Amplada;l++) {
				for(int h=0;h<this.Llargada;h++) {
					if(this.mat[l][h]==-1) {//com aquest pocico es una mina, el seu voltant li sumen 1
						for(int t=(l-1);t<(l+2);t++) {
							for(int y=(h-1);y<(h+2);y++) {
								if(t>=0 && t<this.Amplada && y>=0 && y<this.Llargada) {
									if(this.mat[t][y]!=-1 ) {
										this.mat[t][y] += 1;
										
									}
									
								}
							}
						}
					}
				}
			}
			
		}


	}

	@Override
	public int getLlargada() {
	
		return this.Llargada;  
	}

	@Override
	public int getAmplada() {

		return this.Amplada;
	}

	@Override
	public void setLlargada(int ll) {
		assert(ll>0);
		this.Llargada=ll;
	}

	@Override
	public void setAmplada(int am) {
		assert(am>0);
		this.Amplada=am;

	}

	@Override
	public void setMines(int nm) {
		assert(this.Llargada>0);
		
		assert(this.Amplada>0);
		assert(nm>0);
		assert((this.Amplada*this.Llargada)>nm);
		
		this.mines=nm;

	}

	@Override
	public int[][] getMat() {
		assert(this.matGen==true);
		
		return this.mat;
	}

}
