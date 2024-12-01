package application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class BuscaminesModelTest {

	@Test
	void testBuscaminesModel() {
		//es fara un DbC per denegar valors invalids
		TaulerDisponibilitat MockDips = new MockTaulerDisp();
		TaulerValors MockVals =  new MockTaulerVals();
		
		
		//Hi ha tres variables que poden afectar, llargada, amplada i numMines, les altres dos també poden afecatar, 
		//pero nomes han d'existir i tenir el metodes correctes, aixi que nomes tenen un Particio cada un.
		
		//Per la llargada (l'interval del valids (0,maxInt]) tenim dos particions equivalents 
		//(si no comptem el valors invalids superiosr a maxInt), la primer 0=>x invalids , la segona 0<x valids
		//valor limit -1 i 2, i els frontera 0 i 1
		
		//per la amplada igual que la llargada
		
		//per el nombre de mines tenim que ha de ser mes petit que (llargada*Amplada)
		//aixi que te tres patricions llargada*amplada=<x invalids, llargada*amplada>x valids, tenim en compte que x es un enter i te un limit
	    

		
		
		
		//test caixa negra valors limit i frontera per separat
		//llargada
		
		
		BuscaminesModel m = new BuscaminesModel(1,1,0,MockVals,MockDips); // no ha desaltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),1);
		assertEquals(MockVals.getLlargada(),1);
		assertEquals(MockDips.getAmplada(),1);
		assertEquals(MockVals.getAmplada(),1);
		assertEquals(m.getLlargada(),1);
		assertEquals(m.getLlargada(),1);
		assertEquals(m.getAmplada(),1);
		assertEquals(m.getAmplada(),1);
		assertEquals(m.getNumMines(),0);
		
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(0,1,0,MockVals,MockDips); //ha de saltar un error de Contracte
		   
		});
		 
		m = new BuscaminesModel(2,1,0,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),2);
		assertEquals(MockVals.getLlargada(),2);
		assertEquals(MockDips.getAmplada(),1);
		assertEquals(MockVals.getAmplada(),1);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getAmplada(),1);
		assertEquals(m.getAmplada(),1);
		assertEquals(m.getNumMines(),0);
		
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(-1,1,0,MockVals,MockDips);//ha de saltar un error de Contracte
		   
		});
		
		
		//amplada
		
		//m = new BuscaminesModel(1,1,0,MockVals,MockDips); // no ha de saltar cap error de Contracte //La mateixa que adalt

		
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(1,0,0,MockVals,MockDips); //ha de saltar un error de Contracte
		   
		});
		
		 
		m = new BuscaminesModel(1,2,0,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),1);
		assertEquals(MockVals.getLlargada(),1);
		assertEquals(MockDips.getAmplada(),2);
		assertEquals(MockVals.getAmplada(),2);
		assertEquals(m.getLlargada(),1);
		assertEquals(m.getLlargada(),1);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getNumMines(),0);
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(1,-1,0,MockVals,MockDips);//ha de saltar un error de Contracte
		   
		});
		

		//numMines en el cas de matriu 2x2 els frontera son 3 i 4, i els limit 2 i 5
		m = new BuscaminesModel(2,2,3,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),2);
		assertEquals(MockVals.getLlargada(),2);
		assertEquals(MockDips.getAmplada(),2);
		assertEquals(MockVals.getAmplada(),2);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getNumMines(),3);
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(2,2,4,MockVals,MockDips); //ha de saltar un error de Contracte
		   
		});
		

		 
		m = new BuscaminesModel(2,2,2,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),2);
		assertEquals(MockVals.getLlargada(),2);
		assertEquals(MockDips.getAmplada(),2);
		assertEquals(MockVals.getAmplada(),2);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getLlargada(),2);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getAmplada(),2);
		assertEquals(m.getNumMines(),2);
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(2,2,5,MockVals,MockDips);//ha de saltar un error de Contracte
		   
		});
		
		
		
	   //El pairwise no es pot fer totes les posiblitats, ja que el numMInes depen de que les altres dos estiguin bé 
	   // aixi que seria, també hem de tenir en compte que ja hem fet algus casos abans
		
		assertThrows(AssertionError.class, () -> {
			new BuscaminesModel(0,0,1,MockVals,MockDips); //ha de donar errorte
		   
		});

		//tots els altres casos ja estan fets.
		
		
		

	}

	@Test
	void testInicialitzaMatvalors() {
		TaulerDisponibilitat MockDips = new MockTaulerDisp();
		TaulerValors MockVals =  new MockTaulerVals();
		BuscaminesModel m = new BuscaminesModel(4,3,2,MockVals,MockDips);
		//no hi ha asserts ja que son de per contracte.
		// la i no pot ser mes gran que l'amplada ni inferior a 0, i la j no pot ser mes gran que la llargada ni inferior a 0
		// 3 particions equivalents per a la i: i<0 (invalids), 0<i<amplada (valids), i>amplada (invalids) 
		// 3 particions equivalents per a la j: j<0 (invalids), 0<j<llargada (valids), j>llargada (invalids) 
		//  i valor frontera -1,0 amplada-1 i amplada , valors limit -2, 1, amplada-2 i amplada+1
		// j valor frontera -1, 0, llargada-1 i llargada, valor limit -2,1, llargada-2 i llargada+1
		
		//limits
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(-1, 0);//falla
		});
		m.inicialitzaMatvalors(0, 0);//dona bé
		
		
		m.inicialitzaMatvalors(3, 0);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(4, 0);//falla
		});
		
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(0,-1);//falla
		});
		//m.inicialitzaMatvalors(0, 0);//igual que adalt
		m.inicialitzaMatvalors(0,2);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(0,3);//falla
		});
		
		//forntera
		
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(-2, 0);//falla
		});
		m.inicialitzaMatvalors(1, 0);//dona bé
		m.inicialitzaMatvalors(2, 0);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(5, 0);//falla
		});

		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(0,-2);//falla
		});
		m.inicialitzaMatvalors(0, 1);//dona bé
		//m.inicialitzaMatvalors(0,1);//igual que l'anterior
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(0,4);//falla
		});
		
		
		
		//pairwise
		
		//m.inicialitzaMatvalors(0,0);// valid valid, ja esta fet adalt
		//m.inicialitzaMatvalors(0, -1); valid invalid, ja esta fet adalt
		//m.inicialitzaMatvalors(-1, 0); invalid valid, ja esta fet adalt
		assertThrows(AssertionError.class, () -> {
			m.inicialitzaMatvalors(-1, -1);// invalid invalid
		});
		
		
		
		
		
		//fa falta fer el mock per els valor que son valids per comprovar si es pasa tot correctament
	}

	@Test
	void testGetValosr() {
		TaulerDisponibilitat MockDips = new MockTaulerDisp();
		TaulerValors MockVals =  new MockTaulerVals();
		final BuscaminesModel m = new BuscaminesModel(4,3,2,MockVals,MockDips);
		int[][] v ;
		//test per veure si el DoC va bé
		//ha de ser una pocisio no clicada(la matriu de disponibitat aquela pos fica 0)(retorna buit) i ha de estar en una pocisio correcta(si no s'executa un asset)
		//mirem el limits i frontera del parametre "i", i "j"
		// 3 particions equivalents per a la i: i<0 (invalids), 0<i<amplada (valids), i>amplada (invalids) 
		// 3 particions equivalents per a la j: j<0 (invalids), 0<j<llargada (valids), j>llargada (invalids) 
		// la i no pot ser mes gran que l'amplada ni inferior a 0, i la j no pot ser mes gran que la llargada ni inferior a 0
		//  i valor frontera -1,0 amplada-1 i amplada , valors limit -2, 1, amplada-2 i amplada+1
		// j valor frontera -1, 0, llargada-1 i llargada, valor limit -2,1, llargada-2 i llargada+1
		
		//limits
		assertThrows(AssertionError.class, () -> {
			m.getValosr(-1, 0);//falla
		});
		
		v =m.getValosr(0, 0);//dona bé
		
		v =m.getValosr(3, 0);//dona bé
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(4, 0);//falla
		});
		
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(0,-1);//falla
		});
		//m.getValosr(0, 0);//igual que adalt
		v =m.getValosr(0,2);//dona bé
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(0,3);//falla
		});
		
				
		//forntera
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(-2, 0);//falla
		});
		v =m.getValosr(1, 0);//dona bé
		v =m.getValosr(2, 0);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.getValosr(5, 0);//falla
		});
		
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(0,-2);//falla
		});
		v =m.getValosr(0, 1);//dona bé
		//m.getValosr(0,1);//igual que l'anterior
		assertThrows(AssertionError.class, () -> {
			m.getValosr(0,4);//falla
		});
		
		
		
		//ara probem el mecanisme

		BuscaminesModel m2 = new BuscaminesModel(4,4,2,MockVals,MockDips);
		//matriu valors
		//  0  0 1 -1
		//  1  1 2  1
		//  2 -1 1  1
		// -1  2 1 -1

		v = m2.getValosr(0,0);
		int[][] res1= {{0,0,0},{0,0,1},{1,1,0},{1,1,1},{1,0,2},{2,1,2}};
		

		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				//System.out.print(v[i][j]);
				assertEquals(v[i][j],res1[i][j]);
			}
		}
		
		
		v = m2.getValosr(0,1);
		res1= new int[][] {{}};//com agafa una poscio ja visitada ha de retornar un buit
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(v[i][j],res1[i][j]);
			}
		}


		v = m2.getValosr(2,3); //Afegit per fer decision coberage
		res1= new int[][] {{1,2,3}};//com agafa una poscio ja visitada ha de retornar un buit
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(v[i][j],res1[i][j]);
			}
		}
		
		BuscaminesModel m3 = new BuscaminesModel(4,4,2,MockVals,MockDips);// aixi tenim condition coberage
		//matriu valors
		//  0  0 2 -1
		//  1  1 3 -1
		//  2 -1 2  1
		// -1  2 1  0
		//System.out.println("sssssss");
		v = m2.getValosr(3,3);
		
		res1= new int[][] {{0,3,3},{2,2,2},{1,2,3},{1,3,2}};//com agafa una poscio ja visitada ha de retornar un buit
		for(int i=0;i<res1.length;i++) {
			for(int j=0;j<res1[i].length;j++) {
				assertEquals(v[i][j],res1[i][j]);
			}
		}
		

		//System.out.println("fsfdsdfsfsfsddddddddddddddddddddddddddddddddddddddddddddd: ");
	}

	@Test
	void testIsBomba() {
		TaulerDisponibilitat MockDips = new MockTaulerDisp();
		TaulerValors MockVals =  new MockTaulerVals();
		final BuscaminesModel m = new BuscaminesModel(4,3,2,MockVals,MockDips);
		boolean res ;
		//test per veure si el DoC va bé
		//ha de ser una pocisio no clicada(la matriu de disponibitat aquela pos fica 0)(retorna buit) i ha de estar en una pocisio correcta(si no s'executa un asset)
		//mirem el limits i frontera del parametre "i", i "j"
		// 3 particions equivalents per a la i: i<0 (invalids), 0<i<amplada (valids), i>amplada (invalids) 
		// 3 particions equivalents per a la j: j<0 (invalids), 0<j<llargada (valids), j>llargada (invalids) 
		// la i no pot ser mes gran que l'amplada ni inferior a 0, i la j no pot ser mes gran que la llargada ni inferior a 0
		//  i valor frontera -1,0 amplada-1 i amplada , valors limit -2, 1, amplada-2 i amplada+1
		// j valor frontera -1, 0, llargada-1 i llargada, valor limit -2,1, llargada-2 i llargada+1
		res = m.isBomba(0, 0);
		//limits

		assertThrows(AssertionError.class, () -> {
			
			m.isBomba(-1, 0);//falla
		});
		res =m.isBomba(0, 0);//dona bé
		res =m.isBomba(3, 0);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.isBomba(4, 0);//falla
		});
		
		
		assertThrows(AssertionError.class, () -> {
			m.isBomba(0,-1);//falla
		});
		//m.isBomba(0, 0);//igual que adalt
		res =m.isBomba(0,2);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.isBomba(0,3);//falla
		});
		
				
		//forntera
		
		assertThrows(AssertionError.class, () -> {
			m.getValosr(-2, 0);//falla
		});
		res =m.isBomba(1, 0);//dona bé
		res =m.isBomba(2, 0);//dona bé
		assertThrows(AssertionError.class, () -> {
			m.isBomba(5, 0);//falla
		});
		
		
		assertThrows(AssertionError.class, () -> {
			m.isBomba(0,-2);//falla
		});
		res =m.isBomba(0, 1);//dona bé
		//m.getValosr(0,1);//igual que l'anterior
		assertThrows(AssertionError.class, () -> {
			m.isBomba(0,4);//falla
		});
		
		
		
		

		BuscaminesModel m2 = new BuscaminesModel(4,4,2,MockVals,MockDips);
		//matriu valors
		//  0  0 1 -1
		//  1  1 2  1
		//  2 -1 1  1
		// -1  2 1 -1
		
		
		res = m2.isBomba(0,0);
		
		assertEquals(res,false);
		
		res = m2.isBomba(1,1);
		assertEquals(res,false);
		
		res = m2.isBomba(2,1);
		assertEquals(res,true);
		
		res = m2.isBomba(3,0);
		assertEquals(res,true);
		
		
	}
	
	@Test
	void TestgetMatVals() {
		TaulerDisponibilitat MockDips = mock(TaulerDisponibilitat.class);
		
		TaulerValors MockVals =  mock(TaulerValors.class);
		BuscaminesModel m = new BuscaminesModel(2,2,1,MockVals,MockDips);
		
		m.inicialitzaMatvalors(0, 0);
		when(MockVals.getMat()).thenReturn(new int[][] {{1,1},{1,-1}});
		int[][] res=new int[][] {{1,1},{1,-1}};
		int[][] mar=m.getMatVals();
		for(int i=0;i<mar.length;i++) {
			for(int j=0;j<mar[i].length;j++) {
				assertEquals(mar[i][j],res[i][j]);
			}
		}
	}

}
