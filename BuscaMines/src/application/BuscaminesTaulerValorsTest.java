package application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;


class BuscaminesTaulerValorsTest {

	@Test
	void testInitMat() {
		//Amplada i Llargada han de ser mer grans a 0
		
		//Les particiones equeivale per la variable 'i', x<0 invalds, 0=<x<Amplada valids, x<=Amplada invalids
		// amb els valore limit -1,0,Amplada-1 i Amplada, i els frontera -2,1, Amplada-2, Amplada+1
				
		//Les particiones equeivale per la variable 'l', x<=0 invalds, 0<x<Llargada valids, x<=Llargada
		// amb els valore limit -1,0,Llargada-1 i Llargada, i els frontera -2,1, Llargada-2, Llargada+1
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		
		assertThrows(AssertionError.class, () -> {
			Tv.initMat(0, 0);//dona error, amplada, llaragada i mines no setejades.
		});
		
		Tv.setAmplada(1);
		assertThrows(AssertionError.class, () -> {
			Tv.initMat(0, 0);//dona error, llaragada i mines no setejades.
		});
		
		TaulerValors Tv2 = new BuscaminesTaulerValors(Rmock);
		
		Tv2.setLlargada(1);
		assertThrows(AssertionError.class, () -> {
			Tv2.initMat(0, 0);//dona error, amplada i mines no setejades.
		});
		
		Tv2.setLlargada(1);
		Tv2.setAmplada(1);
		assertThrows(AssertionError.class, () -> {
			Tv2.initMat(0, 0);//dona error, amplada i mines no setejades.
		});
		TaulerValors Tv21 = new BuscaminesTaulerValors(Rmock);
		
		//assertThrows(AssertionError.class, () -> {El cas de setejar mines i no amplada ni llargada,
		//no es pot fer, ja que per setejar les mines fa falta setjar l'amplada i la largada abans
		//	Tv21.setMines(1);
		//	Tv21.initMat(0, 0);//dona error, amplada i llaragada no setejades.
		//});
		
		///TEST parametres 
		
		Rmock = mock(Random.class);
		
		// i=0 
		TaulerValors Tv3 = new BuscaminesTaulerValors(Rmock);
		Tv3.setAmplada(2);
		Tv3.setLlargada(2);
		Tv3.setMines(1);
		when(Rmock.Random(2, 2)).thenReturn(new int[]{1,1});
		Tv3.initMat(0, 0);
		
		int[][] Resmat = Tv3.getMat();
		int[][] mat = new int[][] {{1,1},{1,-1}};
		// 1 1
		// 1 -1
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		Tv3.initMat(0, 0);
		
		
		//i=1
		Rmock = mock(Random.class);
		TaulerValors Tv4 = new BuscaminesTaulerValors(Rmock);
		Tv4.setAmplada(2);
		Tv4.setLlargada(2);
		Tv4.setMines(1);
		when(Rmock.Random(2, 2)).thenReturn(new int[]{1,1});
		Tv4.initMat(1, 0);
		
		Resmat = Tv3.getMat();
		mat = new int[][] {{1,1},{1,-1}};
		// 1 1
		// 1 -1
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		//i=-1
		Rmock = mock(Random.class);
		TaulerValors Tv5 = new BuscaminesTaulerValors(Rmock);
		Tv5.setAmplada(2);
		Tv5.setLlargada(2);
		Tv5.setMines(1);
		assertThrows(AssertionError.class, () -> {
			Tv5.initMat(-1, 0);//dona error, amplada no setejades.
		});
		
		//i=-2
		assertThrows(AssertionError.class, () -> {
			Tv5.initMat(-2, 0);//dona error, amplada no setejades.
		});

		//i=amplada-1
		Tv5.setAmplada(4);
		Tv5.setLlargada(2);
		Tv5.setMines(2);
		when(Rmock.Random(4, 2)).thenReturn(new int[]{1,1}).thenReturn(new int[]{1,1}).thenReturn(new int[]{3,1});//si el random dona dos comps el mateixa pos, ha de seguir buscant mines.
		//1 1
		//1 -1
		//2 2
		//1 -1
		Tv5.initMat(3, 0);
		Resmat = Tv5.getMat();
		mat = new int[][] {{1,1},{1,-1},{2,2},{1,-1}};
		// 1 1
		// 1 -1


		
		
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {

				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}

		//i=amplada-2
		Rmock = mock(Random.class);
		TaulerValors Tv6 = new BuscaminesTaulerValors(Rmock);
		Tv6.setAmplada(4);
		Tv6.setLlargada(2);
		Tv6.setMines(2);
		when(Rmock.Random(4, 2)).thenReturn(new int[]{2,0}).thenReturn(new int[]{1,1}).thenReturn(new int[]{3,1});//si el random dona la mateixa pocisio ha de buscar una altra
		//1 1
		//1 -1
		//2 2
		//1 -1
		Tv6.initMat(2, 0);
		Resmat = Tv6.getMat();
		mat = new int[][] {{1,1},{1,-1},{2,2},{1,-1}};

		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		
		//i=amplada
		Rmock = mock(Random.class);
		TaulerValors Tv7 = new BuscaminesTaulerValors(Rmock);
		Tv7.setAmplada(4);
		Tv7.setLlargada(2);
		Tv7.setMines(2);
		assertThrows(AssertionError.class, () -> {
			Tv7.initMat(4, 0);//dona error, amplada no setejades.
		});
		
		//i=amplada+1
		assertThrows(AssertionError.class, () -> {
			Tv7.initMat(5, 0);//dona error, amplada no setejades.
		});
		
		
		
		//////////////////////
		////TEST del parametre j
		//////////////////////
		
		Rmock = mock(Random.class);
		
		// j=0 ja esta fet adalt
		
		
		//j=1
		TaulerValors Tv9 = new BuscaminesTaulerValors(Rmock);
		Tv9.setAmplada(2);
		Tv9.setLlargada(2);
		Tv9.setMines(1);
		when(Rmock.Random(2, 2)).thenReturn(new int[]{1,1});
		Tv9.initMat(0,1);
		
		Resmat = Tv9.getMat();
		mat = new int[][] {{1,1},{1,-1}};
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		
		//j=-1
		Rmock = mock(Random.class);
		TaulerValors Tv10 = new BuscaminesTaulerValors(Rmock);
		Tv10.setAmplada(2);
		Tv10.setLlargada(2);
		Tv10.setMines(1);
		assertThrows(AssertionError.class, () -> {
			Tv10.initMat(0,-1);//dona error, amplada no setejades.
		});
		
		//j= -2
		assertThrows(AssertionError.class, () -> {
			Tv10.initMat(0,-2);//dona error, amplada no setejades.
		});
	
		//j=Llargada-1
		Tv10.setAmplada(2);
		Tv10.setLlargada(4);
		Tv10.setMines(2);
		when(Rmock.Random(2, 4)).thenReturn(new int[]{1,1}).thenReturn(new int[]{1,1}).thenReturn(new int[]{0,2});//si el random dona dos comps el mateixa pos, ha de seguir buscant mines.
		//1 2 -1 1
		//1-1 2 1
		
		Tv10.initMat(0,3);
		Resmat = Tv10.getMat();
		mat = new int[][] {{1,2,-1,1},{1,-1,2,1}};

		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		
		//j=Llargada-2
		Rmock = mock(Random.class);
		TaulerValors Tv11 = new BuscaminesTaulerValors(Rmock);
		Tv11.setAmplada(2);
		Tv11.setLlargada(4);
		Tv11.setMines(2);
		when(Rmock.Random(2, 4)).thenReturn(new int[]{1,1}).thenReturn(new int[]{1,1}).thenReturn(new int[]{0,3});//si el random dona dos comps el mateixa pos, ha de seguir buscant mines.
		//1 1 2 -1
		//1-1 2 1
		Tv11.initMat(0, 2);
		Resmat = Tv11.getMat();
		mat = new int[][] {{1,1,2,-1},{1,-1,2,1}};
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
		
		//j=Llargada
		Rmock = mock(Random.class);
		TaulerValors Tv12 = new BuscaminesTaulerValors(Rmock);
		Tv12.setAmplada(4);
		Tv12.setLlargada(4);
		Tv12.setMines(2);
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(0, 4);//dona error, amplada no setejades.
		});
		
		//j=Llargada+1
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(0, 5);//dona error, amplada no setejades.
		});
		
		
		
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
		
		//0 0
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(-1, -1);//dona error, amplada no setejades.
		});
		
		//0 2
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(-1, 4);//dona error, amplada no setejades.
		});
		
		//2 0
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(4, -1);//dona error, amplada no setejades.
		});
		
		//2 2
		assertThrows(AssertionError.class, () -> {
			Tv12.initMat(4, 4);//dona error, amplada no setejades.
		});
		
		//loop testing 1 linia 44-56 (mines) tindrem una mat 3x3 max 8 mines min 1
		//(0) no pot ser 0 les mines, (1), (2),(5) valor entre mig,(7)max-1,(8) max
		
		//0
		TaulerValors  TvloopSimple = new BuscaminesTaulerValors(Rmock);
		
		assertThrows(AssertionError.class, () -> {
			TvloopSimple.setAmplada(3);
			TvloopSimple.setLlargada(3);
			TvloopSimple.setMines(0); 
			TvloopSimple.initMat(0, 0);
		});
		
		//1
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1});
		TaulerValors  TvloopSimple2 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple2.setAmplada(3);
		TvloopSimple2.setLlargada(3);
		TvloopSimple2.setMines(1); 
		TvloopSimple2.initMat(0, 0);

		//2
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0});
		TaulerValors  TvloopSimple3 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple3.setAmplada(3);
		TvloopSimple3.setLlargada(3);
		TvloopSimple3.setMines(2); 
		TvloopSimple3.initMat(0, 0);

		//4
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {0,2});
		TvloopSimple3 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple3.setAmplada(3);
		TvloopSimple3.setLlargada(3);
		TvloopSimple3.setMines(4); 
		TvloopSimple3.initMat(0, 0);

		//7
		Rmock = mock(Random.class);
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {2,0}).thenReturn(new int[] {2,1})
		.thenReturn(new int[] {0,2}).thenReturn(new int[] {1,2});;
		TvloopSimple3 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple3.setAmplada(3);
		TvloopSimple3.setLlargada(3);
		TvloopSimple3.setMines(4); 
		TvloopSimple3.initMat(0, 0);

		//5
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {2,0}).thenReturn(new int[] {2,1})
		.thenReturn(new int[] {0,2}).thenReturn(new int[] {1,2}).thenReturn(new int[] {2,2});
		TvloopSimple3 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple3.setAmplada(3);
		TvloopSimple3.setLlargada(3);
		TvloopSimple3.setMines(8); 
		TvloopSimple3.initMat(0, 0);

		
		
		
		//loop testing 2 linia 17-21, (mines) tindrem una mat 3x3 max 8 mines min 1
		//(0) no pot ser 0 les mines, (1), (2),(5) valor entre mig,(7)max-1,(8) max
		
		//0
		TaulerValors  TvloopSimple20 = new BuscaminesTaulerValors(Rmock);
		
		assertThrows(AssertionError.class, () -> {
			TvloopSimple20.setAmplada(3);
			TvloopSimple20.setLlargada(3);
			TvloopSimple20.setMines(0); 
			TvloopSimple20.initMat(0, 0);
		});
		
		//1
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1});
		TaulerValors  TvloopSimple22 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple22.setAmplada(3);
		TvloopSimple22.setLlargada(3);
		TvloopSimple22.setMines(1); 
		TvloopSimple22.initMat(0, 0);

		//2
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0});
		TaulerValors  TvloopSimple23 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple23.setAmplada(3);
		TvloopSimple23.setLlargada(3);
		TvloopSimple23.setMines(2); 
		TvloopSimple23.initMat(0, 0);

		//4
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {0,2});
		TvloopSimple23 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple23.setAmplada(3);
		TvloopSimple23.setLlargada(3);
		TvloopSimple23.setMines(4); 
		TvloopSimple23.initMat(0, 0);

		//7
		Rmock = mock(Random.class);
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {2,0}).thenReturn(new int[] {2,1})
		.thenReturn(new int[] {0,2}).thenReturn(new int[] {1,2});;
		TvloopSimple23 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple23.setAmplada(3);
		TvloopSimple23.setLlargada(3);
		TvloopSimple23.setMines(4); 
		TvloopSimple23.initMat(0, 0);

		//5
		when(Rmock.Random(3, 3)).thenReturn(new int[] {0,1}).thenReturn(new int[] {1,0})
		.thenReturn(new int[] {1,1}).thenReturn(new int[] {2,0}).thenReturn(new int[] {2,1})
		.thenReturn(new int[] {0,2}).thenReturn(new int[] {1,2}).thenReturn(new int[] {2,2});
		TvloopSimple23 = new BuscaminesTaulerValors(Rmock);	
		
		TvloopSimple23.setAmplada(3);
		TvloopSimple23.setLlargada(3);
		TvloopSimple23.setMines(8); 
		TvloopSimple23.initMat(0, 0);

		
		
		

		
		
		
		
		// loops aniuats testing linia 34-49 format (Amplada,Llargada)
		// (1,0)el cas no es posible, (1,1)no es posible(no caben mines), (1,2), (1,5),(1, MAX_INT-1),(1,MAX_INT)
		//(0,5)el cas no es posible, (1,5), (2,5), (5,5),(MAX_INT-1,5),(MAX_INT,5)
		
		//(1,0)
		
		TaulerValors  TvlootDoble = new BuscaminesTaulerValors(Rmock);
		
		assertThrows(AssertionError.class, () -> {
			TvlootDoble.setAmplada(1);
			TvlootDoble.setLlargada(0);
			TvlootDoble.setMines(1); 
			TvlootDoble.initMat(0, 0);
		});
		
		//(1,1)
		TaulerValors  TvlootDoble2 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble2.setAmplada(1);
		TvlootDoble2.setLlargada(1);
		 
		assertThrows(AssertionError.class, () -> {
			TvlootDoble2.setMines(1);
			TvlootDoble2.initMat(0, 0);
		});
		
		//(1,2)
		when(Rmock.Random(1, 2)).thenReturn(new int[] {0,1});
		TaulerValors  TvlootDoble3 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble3.setAmplada(1);
		TvlootDoble3.setLlargada(2);
		TvlootDoble3.setMines(1); 
		TvlootDoble3.initMat(0, 0);

		
		//(1,5)
		when(Rmock.Random(1,5)).thenReturn(new int[] {0,1});
		TaulerValors  TvlootDoble4 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble4.setAmplada(1);
		TvlootDoble4.setLlargada(5);
		TvlootDoble4.setMines(1); 

		TvlootDoble4.initMat(0, 0);

		
		//(1,MAX_INT-1) Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//when(Rmock.Random(1, Integer.MAX_VALUE-1)).thenReturn(new int[] {0,1});
		//TaulerValors  TvlootDoble5 = new BuscaminesTaulerValors(Rmock);
		//TvlootDoble5.setAmplada(1);
		//TvlootDoble5.setLlargada(Integer.MAX_VALUE-1);
		//TvlootDoble5.setMines(1); 

		//TvlootDoble5.initMat(0, 0);

		
		//(1,MAX_INT)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//when(Rmock.Random(1,Integer.MAX_VALUE)).thenReturn(new int[] {0,1});
		//TaulerValors  TvlootDoble6 = new BuscaminesTaulerValors(Rmock);
		//TvlootDoble6.setAmplada(1);
		//TvlootDoble6.setLlargada(Integer.MAX_VALUE);
		//TvlootDoble6.setMines(1); 

		//TvlootDoble6.initMat(0, 0);

		
		
		//(0,5)
		TaulerValors  TvlootDoble7 = new BuscaminesTaulerValors(Rmock);

		assertThrows(AssertionError.class, () -> {
			TvlootDoble7.setAmplada(0);//no pot ser 0
			TvlootDoble7.setLlargada(5);
			TvlootDoble7.setMines(1); 
			TvlootDoble7.initMat(0, 0);
		});
		
		//(1,5)
		when(Rmock.Random(1, 5)).thenReturn(new int[] {0,1});
		TaulerValors  TvlootDoble8 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble8.setAmplada(1);
		TvlootDoble8.setLlargada(5);
		TvlootDoble8.setMines(1); 
		TvlootDoble8.initMat(0, 0);
		
		
		//(2,5)
		when(Rmock.Random(2, 5)).thenReturn(new int[] {0,1});
		TaulerValors  TvlootDoble9 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble9.setAmplada(1);
		TvlootDoble9.setLlargada(5);
		TvlootDoble9.setMines(1); 
		TvlootDoble9.initMat(0, 0);

		
		//(5,5)
		when(Rmock.Random(5, 5)).thenReturn(new int[] {0,1});
		TaulerValors  TvlootDoble10 = new BuscaminesTaulerValors(Rmock);
		TvlootDoble10.setAmplada(1);
		TvlootDoble10.setLlargada(5);
		TvlootDoble10.setMines(1); 
		TvlootDoble10.initMat(0, 0);

		
		//(MAX_INT-1,5)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//when(Rmock.Random(Integer.MAX_VALUE-1, 5)).thenReturn(new int[] {0,1});
		//TaulerValors  TvlootDoble11 = new BuscaminesTaulerValors(Rmock);
		//TvlootDoble11.setAmplada(Integer.MAX_VALUE-1);
		//TvlootDoble11.setLlargada(5);
		//TvlootDoble11.setMines(1); 
		//TvlootDoble11.initMat(0, 0);

		
		//(MAX_INT,5)Dona una exepccio de VM Limit, al crear la matriu a la linia 34
		//when(Rmock.Random(Integer.MAX_VALUE, 5)).thenReturn(new int[] {0,1});
		//TaulerValors  TvlootDoble12 = new BuscaminesTaulerValors(Rmock);
		//TvlootDoble12.setAmplada(Integer.MAX_VALUE);
		//TvlootDoble12.setLlargada(5);
		//TvlootDoble12.setMines(1); 
		//TvlootDoble12.initMat(0, 0);

		
		
		
	}

	@Test
	void testGetLlargada()   {
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		
		assertEquals(Tv.getLlargada(),0);
		
		Tv.setLlargada(1);
		assertEquals(Tv.getLlargada(),1);
		
		Rmock = mock(Random.class);
		Tv = new BuscaminesTaulerValors(Rmock);
		
		Tv.setLlargada(2);
		assertEquals(Tv.getLlargada(),2);
	}

	@Test
	void testGetAmplada()   {
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		
		assertEquals(Tv.getAmplada(),0);
		
		Tv.setAmplada(1);
		assertEquals(Tv.getAmplada(),1);
		
		Rmock = mock(Random.class);
		Tv = new BuscaminesTaulerValors(Rmock);
		
		Tv.setAmplada(2);
		assertEquals(Tv.getAmplada(),2);
	}

	@Test
	void testSetLlargada() {
		// Te dos particions equivalents, x=<0 de valor invalids, i x>0 valids
		//Els valors frontera, 0 i 1, i limits -1 i 2
				
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setLlargada(0); //si es fica un valor invalid
		});
				
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setLlargada(-1); //si es fica un valor invalid
		});
				
				
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
				
		Tv.setLlargada(1);
		assertEquals(Tv.getLlargada(),1);
				
		Tv.setLlargada(2);
		assertEquals(Tv.getLlargada(),2);
	}

	@Test
	void testSetAmplada()   {
		// Te dos particions equivalents, x=<0 de valor invalids, i x>0 valids
		//Els valors frontera, 0 i 1, i limits -1 i 2
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(0); //si es fica un valor invalid
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(-1); //si es fica un valor invalid
		});
		
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		
		Tv.setAmplada(1);
		assertEquals(Tv.getAmplada(),1);
		
		Tv.setAmplada(2);
		assertEquals(Tv.getAmplada(),2);
	}

	@Test
	void testSetMines()   {
		//ha de ser mer gran que 0, i no pot ser ni igual ni mes gran que Amplada*llargadar, o s'ha d'inicialtzar les ampladis i llargades abans

		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setMines(1); //no estan les amplaes ni llargdes
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setLlargada(2);
			Tv.setMines(1); //no estan les amplaes 
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(2);
			Tv.setMines(1); //no estan les llargdes
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(2);
			Tv.setLlargada(2);
			Tv.setMines(0); //no pot ser 0
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(2);
			Tv.setLlargada(2);
			Tv.setMines(-1); //si es fica un valor invalid
		});
		
		assertThrows(AssertionError.class, () -> {
			Random Rmock = mock(Random.class);
			TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
			Tv.setAmplada(2);
			Tv.setLlargada(2);
			Tv.setMines(4); //no pot ser ni igual ni mes gra a Amplada*Llargada
		});
		
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		Tv.setAmplada(4);
		Tv.setLlargada(4);
		Tv.setMines(2);
		when(Rmock.Random(4, 4)).thenReturn(new int[]{1,1}).thenReturn(new int[]{1,1}).thenReturn(new int[]{0,3});//si el random dona dos comps el mateixa pos, ha de seguir buscant mines.
		//1 1 2 -1
		//1-1 2 1
		Tv.initMat(0, 2);
		int[][] Resmat = Tv.getMat();
		int numMine=0;
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {

				numMine += (Resmat[i][j]==-1)?1:0;
			}

		}
		
		assertEquals(numMine,2);
		
		
		
		
		Rmock = mock(Random.class);
		Tv = new BuscaminesTaulerValors(Rmock);
		Tv.setAmplada(4);
		Tv.setLlargada(4);
		Tv.setMines(1);
		when(Rmock.Random(4, 4)).thenReturn(new int[]{1,1});
		//1 1 1 0
		//1-1 1 0
		Tv.initMat(0, 2);
		Resmat = Tv.getMat();
		numMine=0;
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				numMine += (Resmat[i][j]==-1)?1:0;
			}
		}
		
		assertEquals(numMine,1);

		
	}

	@Test
	void testGetMat() {
		//si encara no s'ha dit la primera pocisio saltara error.
		
		Random Rmock = mock(Random.class);
		TaulerValors Tv = new BuscaminesTaulerValors(Rmock);
		
		assertThrows(AssertionError.class, () -> {
			Tv.getMat();
		});
		
		Tv.setAmplada(2);
		Tv.setLlargada(2);
		Tv.setMines(1);
		when(Rmock.Random(2, 2)).thenReturn(new int[]{1,1});
		Tv.initMat(0, 0);
		
		int[][] Resmat = Tv.getMat();
		int[][] mat = new int[][] {{1,1},{1,-1}};
		// 1 1
		// 1 -1
		for(int i=0;i<Resmat.length;i++) {
			for(int j=0;j<Resmat[0].length;j++) {
				assertEquals(Resmat[i][j],mat[i][j]);
			}
		}
	}

}
