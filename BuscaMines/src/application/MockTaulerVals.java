package application;

public class MockTaulerVals implements TaulerValors {
	private int count=0;
	
	public MockTaulerVals() {
		
	}
	
	public int getLlargada() {
		return 0;
	}
	public int getAmplada() {
		return 0;
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
		if(this.count<8) {
			
			return new int[4][3];
		}else {
			return new int[][]{{0,0,1,-1},{1,1,2,1},{2,-1,1,1},{-1,2,1,-1}};
		}
		
	
		
		
	}

}