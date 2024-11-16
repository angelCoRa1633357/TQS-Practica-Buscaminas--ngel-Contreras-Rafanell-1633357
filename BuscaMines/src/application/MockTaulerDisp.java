package application;

public class MockTaulerDisp implements TaulerDisponibilitat {
	private int numAcces = 0;
	
	public MockTaulerDisp() {
		
	}
	
	void Init() {
		
	}
	
	
	
	public boolean[][] getMartrix(){
		
		boolean [][] res = new boolean[4][4];
		if(numAcces==0) {
			res = new boolean[][]{{false,false,false,false},
					{false,false,false,false},
					{false,false,false,false},
					{false,false,false,false}};
			
			
		}else {
			res = new boolean[][]{{true,true,true,false},
					{true,true,true,false},
					{false,false,false,false},
					{false,false,false,false}};
		
		}
		this.numAcces = (this.numAcces + 1)%2;
		return res;
	}
	public int getLlargada() {
		return 4;
	}
	public int getAmplada() {
		return 4;
	}
	
	public void posDescoberta(int i, int j) {
		
	}
	
	public void setLlargada(int ll) {
		
	}
	public void setAmplada(int am) {
		
	}

}
