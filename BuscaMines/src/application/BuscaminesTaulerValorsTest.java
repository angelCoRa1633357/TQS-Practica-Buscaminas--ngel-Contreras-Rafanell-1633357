package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuscaminesTaulerValorsTest {

	@Test
	void testInitMat() {
		//Amplada i Llargada han de ser mer grans a 0
		
		//Les particiones equeivale per la variable 'i', x<0 invalds, 0=<x<Amplada valids, x<=Amplada invalids
		// amb els valore limit -1,0,Amplada-1 i Amplada, i els frontera -2,1, Amplada-2, Amplada+1
				
		//Les particiones equeivale per la variable 'l', x<=0 invalds, 0<x<Llargada valids, x<=Llargada
		// amb els valore limit -1,0,Llargada-1 i Llargada, i els frontera -2,1, Llargada-2, Llargada+1
		
		TaulerValors Tv = new BuscaminesTaulerValors();
		
		assertThrows(AssertionError.class, () -> {
			Tv.initMat(0, 0);//dona error, amplada i llaragada no setejades.
		});
		
		Tv.setAmplada(1);
		assertThrows(AssertionError.class, () -> {
			Tv.initMat(0, 0);//dona error, llaragada no setejades.
		});
		
		TaulerValors Tv2 = new BuscaminesTaulerValors();
		
		Tv.setLlargada(1);
		assertThrows(AssertionError.class, () -> {
			Tv2.initMat(0, 0);//dona error, amplada no setejades.
		});
		
		///TEST parametres 
		
	}

	@Test
	void testGetLlargada() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAmplada() {
		fail("Not yet implemented");
	}

	@Test
	void testSetLlargada() {
		fail("Not yet implemented");
	}

	@Test
	void testSetAmplada() {
		fail("Not yet implemented");
	}

	@Test
	void testSetMines() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMat() {
		fail("Not yet implemented");
	}

}
