package application;

public class MockTaulerDisp implements TaulerDisponibilitat {
	int numAcces = 0;
	
	public MockTaulerDisp() {
		
	}
	
	void Init() {
		
	}
	
	public boolean[][] getMartrix(){
		boolean [][] res = {{true,false},{true,false}};
		return res;
	}
	public int getLlargada() {
		return 0;
	}
	public int getAmplada() {
		return 0;
	}

}
