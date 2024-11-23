package application;

public class BuscaminesTaulerDisp implements TaulerDisponibilitat {
	boolean matGen=false;
	boolean[][] mat;
	int Llargada=0;
	int Amplada=0;

	@Override
	public boolean[][] getMartrix() {
		assert(this.Llargada>0 && this.Amplada>0);
		
		if(!this.matGen) {
			this.matGen=true;
			 this.mat = new boolean[this.Amplada][this.Llargada];
			 for(int i=0;i<this.Amplada;i++) {
				 for(int j=0;j<this.Llargada;j++) {
					 this.mat[i][j]=false;
				 }
			 }
			
		}
	
		
		return this.mat;
	}

	@Override
	public int getLlargada() {
		// TODO Auto-generated method stub
		return this.Llargada;
	}

	@Override
	public int getAmplada() {
		// TODO Auto-generated method stub
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
	public void posDescoberta(int i, int j) {
		assert(i>=0 && j>=0 && i<this.Amplada && j<this.Llargada );
		
		this.mat[i][j]=true;
		// TODO Auto-generated method stub

	}

}
