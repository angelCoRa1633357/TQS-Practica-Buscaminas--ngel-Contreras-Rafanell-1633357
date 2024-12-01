package application;
//Comentari per provar testse
public class MockTaulerDisp implements TaulerDisponibilitat {
	private int numAcces = 0;
	private int count =0;
	private int countGets=0;
	public MockTaulerDisp() {
		
	}
	
	void Init() {
		
	}
	
	
	
	public boolean[][] getMartrix(){
		
		boolean [][] res;
		this.count++;
		if(this.count>6) {
			
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
			
		}else {
			res = new boolean[][]{{true,true,true},
				{true,true,true},
				{true,true,true},
				{true,true,true}};
			
		}
		
		
		return res;
	}
	public int getLlargada() {
		int val=0;
		switch(this.countGets) {
		case 0:
			val= 1;
			break;
		case 1:
			val=2;
			break;
		case 2:
			val=1;
			break;
		case 3:
			val=2;
			break;
		case 4:
			val=2;
			break;
		}
		return val;
	}
	public int getAmplada() {
		int val=0;
		switch(this.countGets) {
		case 0:
			val= 1;
			break;
		case 1:
			val=1;
			break;
		case 2:
			val=2;
			break;
		case 3:
			val=2;
			break;
		case 4:
			val=2;
			break;
		}
		this.countGets++;
		return val;
	}
	
	public void posDescoberta(int i, int j) {
		
	}
	
	public void setLlargada(int ll) {
		
	}
	public void setAmplada(int am) {
		
	}

}
