package application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class BuscaminesTaulerDispTest {

	@Test
	void testGetMartrix() {
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		
		
		
		//pariicions equivalensts: Com no te parametres d'entrada, utiltzarem els valors que utilitzara que sera l'amplada i la llargada, i els modificarem amb els setter
		// i creant noves instancies.
		// seria 0 i 1 com a fronteres, -1 i 2 com a frontera.
		// Com aquestes son les particion equivalent dels setters((-1,0)invalids i (1,2)valids), el -1 i 0 no es podem settejar, pero el 0 sera un valor per defecte aixi que aquest si es pot 
		// testjar. Com hem fet 
		
		
		
		//Provant amb l'amplada a 1 i la llargada a 0
		Td.setAmplada(1);
		assertThrows(AssertionError.class, () -> {
			Td.getMartrix();//si es truca a getMatrix amb els valors a 0 amb el setter, saltar un assert.
				   
		});
		
		// amplada a 1, i llargada a 1
		Td.setLlargada(1);
		boolean[][] res = Td.getMartrix();  
		
		boolean[][] res1= new boolean[][] {{false}};//Com es una matri 1x1
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(res[i][j],res1[i][j]);
			}
		}
		
		//Provant amb l'amplada a 1 i la llargada a 2
		TaulerDisponibilitat Td1 = new BuscaminesTaulerDisp();
		Td1.setAmplada(1);
		Td1.setLlargada(2);
		res = Td1.getMartrix();  
		
		res1= new boolean[][] {{false,false}};//Com es una matri 1x1
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(res[i][j],res1[i][j]);
			}
		}
		
		//Provant amb l'amplada a 0 i la llargada a 1
		TaulerDisponibilitat Td2 = new BuscaminesTaulerDisp();
		Td2.setLlargada(1);
		assertThrows(AssertionError.class, () -> {
			Td2.getMartrix();//si es truca a getMatrix amb els valors a 0 amb el setter, saltar un assert.				   
		});
		
		//Provant amb l'amplada a 2 i la llargada a 1
		TaulerDisponibilitat Td3 = new BuscaminesTaulerDisp();
		Td3.setAmplada(2);
		Td3.setLlargada(1);
		res = Td3.getMartrix();  
				
		res1= new boolean[][] {{false},{false}};//Com es una matri 1x1
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(res[i][j],res1[i][j]);
			}
		}
		
		
		//Si fem pariwis testings, i cada valor te dos estats valid (1), i invalid(0)
		// 0 0
		// 1 0 ja esta fet
		// 0 1 ja esta fet
		// 1 1 ja esta fet
		
		//cas 0 0 
		TaulerDisponibilitat Td4 = new BuscaminesTaulerDisp();
		assertThrows(AssertionError.class, () -> {
			Td4.getMartrix();			   
		});
		
		// loops aniuats testing linia 16-20 format (Amplada,Llargada)
		// (1,0)el cas no es posible, (1,1), (1,2), (1,5),(1, MAX_INT-1),(1,MAX_INT)
		//(0,5)el cas no es posible, (1,5), (2,5), (5,5),(MAX_INT-1,5),(MAX_INT,5)
		
		//(1,0)
		
		TaulerDisponibilitat TdloopDoble = new BuscaminesTaulerDisp();
		
		assertThrows(AssertionError.class, () -> {
			TdloopDoble.setAmplada(1);
			TdloopDoble.setLlargada(0);
			TdloopDoble.getMartrix();
		});
		
		//(1,1)
		TaulerDisponibilitat TdloopDoble2 = new BuscaminesTaulerDisp();
		TdloopDoble2.setAmplada(1);
		TdloopDoble2.setLlargada(1);
		TdloopDoble2.getMartrix();
	
		
		//(1,2)
		
		TaulerDisponibilitat TdloopDoble3 = new BuscaminesTaulerDisp();
		TdloopDoble3.setAmplada(1);
		TdloopDoble3.setLlargada(2);
		TdloopDoble3.getMartrix();

		
		//(1,5)
		TaulerDisponibilitat TdloopDoble4 = new BuscaminesTaulerDisp();
		TdloopDoble4.setAmplada(1);
		TdloopDoble4.setLlargada(5);
		TdloopDoble4.getMartrix();

		
		//(1,MAX_INT-1) Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//TaulerDisponibilitat TdloopDoble5 = new BuscaminesTaulerDisp();
		//TdloopDoble5.setAmplada(1);
		//TdloopDoble5.setLlargada(Integer.MAX_VALUE-1);
		//TdloopDoble5.getMartrix();

		
		//(1,MAX_INT)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//TaulerDisponibilitat TdloopDoble6 = new BuscaminesTaulerDisp();
		//TdloopDoble6.setAmplada(1);
		//TdloopDoble6.setLlargada(Integer.MAX_VALUE);

		//TdloopDoble6.getMartrix();

		
		
		//(0,5)
		TaulerDisponibilitat TdloopDoble7 = new BuscaminesTaulerDisp();

		assertThrows(AssertionError.class, () -> {
			TdloopDoble7.setAmplada(0);//no pot ser 0
			TdloopDoble7.setLlargada(5);
			TdloopDoble7.getMartrix();
		});
		
		//(1,5)
		TaulerDisponibilitat TdloopDoble8 = new BuscaminesTaulerDisp();
		TdloopDoble8.setAmplada(1);
		TdloopDoble8.setLlargada(5);
		TdloopDoble8.getMartrix();
		
		
		//(2,5)
		TaulerDisponibilitat TdloopDoble9 = new BuscaminesTaulerDisp();
		TdloopDoble9.setAmplada(1);
		TdloopDoble9.setLlargada(5);
		TdloopDoble9.getMartrix();

		
		//(5,5)

		TaulerDisponibilitat TdloopDoble10 = new BuscaminesTaulerDisp();
		TdloopDoble10.setAmplada(1);
		TdloopDoble10.setLlargada(5);
		TdloopDoble10.getMartrix();

		
		//(MAX_INT-1,5)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//TaulerDisponibilitat TdloopDoble11 = new BuscaminesTaulerDisp();
		//TdloopDoble11.setAmplada(Integer.MAX_VALUE-1);
		//TdloopDoble11.setLlargada(5);

		//TdloopDoble11.getMartrix();

		
		//(MAX_INT,5)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//TaulerDisponibilitat TdloopDoble12 = new BuscaminesTaulerDisp();
		//TdloopDoble12.setAmplada(Integer.MAX_VALUE);
		//TdloopDoble12.setLlargada(5);
		//TdloopDoble12.getMartrix();
	}

	@Test
	void testGetLlargada() {
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		
		assertEquals(Td.getLlargada(),0);
		
		Td.setLlargada(1);
		assertEquals(Td.getLlargada(),1);
		
		Td = new BuscaminesTaulerDisp();
		
		Td.setLlargada(2);
		assertEquals(Td.getLlargada(),2);
	}

	@Test
	void testGetAmplada() {
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		
		assertEquals(Td.getAmplada(),0);
		
		Td.setAmplada(1);
		assertEquals(Td.getAmplada(),1);
		
		Td = new BuscaminesTaulerDisp();
		
		Td.setAmplada(2);
		assertEquals(Td.getAmplada(),2);
	}

	@Test
	void testSetLlargada() {
		// Te dos particions equivalents, x=<0 de valor invalids, i x>0 valids
		//Els valors frontera, 0 i 1, i limits -1 i 2
		
		assertThrows(AssertionError.class, () -> {
			TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
			Td.setLlargada(0); //si es fica un valor invalid
		});
		
		assertThrows(AssertionError.class, () -> {
			TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
			Td.setLlargada(-1); //si es fica un valor invalid
		});
		
		
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		
		Td.setLlargada(1);
		assertEquals(Td.getLlargada(),1);
		
		Td.setLlargada(2);
		assertEquals(Td.getLlargada(),2);
	}

	@Test
	void testSetAmplada() {
		// Te dos particions equivalents, x=<0 de valor invalids, i x>0 valids
		//Els valors frontera, 0 i 1, i limits -1 i 2
		
		assertThrows(AssertionError.class, () -> {
			TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
			Td.setAmplada(0); //si es fica un valor invalid
		});
		
		assertThrows(AssertionError.class, () -> {
			TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
			Td.setAmplada(-1); //si es fica un valor invalid
		});
		
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		
		Td.setAmplada(1);
		assertEquals(Td.getAmplada(),1);
		
		Td.setAmplada(2);
		assertEquals(Td.getAmplada(),2);
	}


	
	@Test
	void testPosDescoberta() {
		//si hi ha un error amb les seguents particions equivalents salta un assert, que es un DbyC
		//Les particiones equeivale per la variable 'i', x<0 invalds, 0=<x<Amplada valids, x<=Amplada invalids
		// amb els valore limit -1,0,Amplada-1 i Amplada, i els frontera -2,1, Amplada-2, Amplada+1
		
		//Les particiones equeivale per la variable 'l', x<=0 invalds, 0<x<Llargada valids, x<=Llargada
		// amb els valore limit -1,0,Llargada-1 i Llargada, i els frontera -2,1, Llargada-2, Llargada+1
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();
		Td.setAmplada(4);
		Td.setLlargada(4);
		
		Td.posDescoberta(0, 0); //al ser un valor corecte, i encara no s'ha creat la matriu, es creara al cridarla
		
		boolean[][] matRes = Td.getMartrix();
		boolean[][] res = new boolean[][]{{true,false,false,false},{false,false,false,false},{false,false,false,false},{false,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res[i][j],matRes[i][j]);
			}
		}
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(-1,0);//invalid
		});
		
		
		Td.posDescoberta(3, 0); //Amplada-1
		
		matRes = Td.getMartrix();
		boolean[][] res2 = new boolean[][]{{true,false,false,false},{false,false,false,false},{false,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res2[i][j],matRes[i][j]);
			}
		}
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(4,0);//Amplada
		});
		
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(-2,0);//-2
		});
		
		
		Td.posDescoberta(1, 0); //Amplada-1
		
		matRes = Td.getMartrix();
		boolean[][] res3 = new boolean[][]{{true,false,false,false},{true,false,false,false},{false,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res3[i][j],matRes[i][j]);
			}
		}
			
		Td.posDescoberta(2, 0); //Amplada-2
			
		matRes = Td.getMartrix();
		boolean[][] res4 = new boolean[][]{{true,false,false,false},{true,false,false,false},{true,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res4[i][j],matRes[i][j]);
			}
		}
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(5,0);//Amplada+1
		});
		
		
		//////////////////////////////////////////////////////
		//Test parametre j ///////////////////////////////////
		//////////////////////////////////////////////////////

		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(0,-1);//invalid
		});
		
		
		Td.posDescoberta(0,3); //Llargada-1
		
		matRes = Td.getMartrix();
		boolean[][] res5 = new boolean[][]{{true,false,false,true},{true,false,false,false},{true,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res5[i][j],matRes[i][j]);
			}
		}
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(0,4);//Llargada
		});
		
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(0,-2);//-2
		});
		
		
		Td.posDescoberta(0,1); //Llargada-1
		
		matRes = Td.getMartrix();
		boolean[][] res6 = new boolean[][]{{true,true,false,true},{true,false,false,false},{true,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res6[i][j],matRes[i][j]);
			}
		}
			
		Td.posDescoberta(0,2); //Llargada-2
			
		matRes = Td.getMartrix();
		boolean[][] res7 = new boolean[][]{{true,true,true,true},{true,false,false,false},{true,false,false,false},{true,false,false,false}};
		for(int i=0;i<matRes.length;i++) {
			for(int j=0;j<matRes[0].length;j++) {
				assertEquals(res7[i][j],matRes[i][j]);
			}
		}
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(0,5);//Llargada+1
		});
		
		//////////////////////////////////////////
		//parwing testing
		///////////////////////////////////////
		
		// tenim dos paramtres, amb tres particions equivalents
		// 0 es la primer particio(representatn -1), 1 la segona(representant 0) i 2 la tercera(representatn el 4)
		
		// 0 0 
		// 0 1 esta feta
		// 1 0 esta feta
		// 1 1 esta feta
		// 0 2
		// 2 0
		// 1 2 esta feta
		// 2 1 esta feta
		// 2 2
		
		// 0 0
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(-1,-1);
		});
		
		// 0 2
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(-1,4);
		});
		
		//2 0
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(4,-1);
		});
		
		// 2 2
		
		assertThrows(AssertionError.class, () -> {
			Td.posDescoberta(4,4);
		});
		
		
	}

}
