package application;

public class MockTaulerVals implements TaulerValors {
	private int count=0;
	private int countGets=0;
	
	public MockTaulerVals() {
		
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
	
	public void setLlargada(int ll) {
		
	}
	public void setAmplada(int am) {
		
	}
	
	public void setMines(int nm) {
		
	}
	
	public void initMat(int i, int j) {
		
	}
	
	public int[][] getMat() {
		this.count++;
		if(this.count<7) {
			
			return new int[][] {{0,1,-1},{0,1,1},{1,-1,1},{0,1,0}};
		}else if(this.count<10){
			System.out.println("Count: " + this.count);
			return new int[][]{{0,0,1,-1},{1,1,2,1},{2,-1,1,1},{-1,2,1,-1}};
			
		}else {
			return new int[][]{{0,0,2,-1},{1,1,3,-1},{2,-1,2,1},{-1,2,1,0}};
		}
		
	
		
		
	}

}