package application;

import static org.junit.jupiter.api.Assertions.*;

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
		
		m = new BuscaminesModel(0,1,0,MockVals,MockDips); //ha de saltar un error de Contracte
		 
		m = new BuscaminesModel(2,1,0,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getLlargada(),2);
		assertEquals(MockVals.getLlargada(),2);
		m = new BuscaminesModel(-1,1,0,MockVals,MockDips);//ha de saltar un error de Contracte
		
		//amplada
		m = new BuscaminesModel(1,1,0,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getAmplada(),1);
		assertEquals(MockVals.getAmplada(),1);
		m = new BuscaminesModel(1,0,0,MockVals,MockDips); //ha de saltar un error de Contracte
		 
		m = new BuscaminesModel(1,2,0,MockVals,MockDips); // no ha de saltar cap error de Contracte
		assertEquals(MockDips.getAmplada(),1);
		assertEquals(MockVals.getAmplada(),1);
		m = new BuscaminesModel(1,-1,0,MockVals,MockDips);//ha de saltar un error de Contracte

		//numMines en el cas de matriu 2x2 els frontera son 3 i 4, i els limit 2 i 5
		m = new BuscaminesModel(2,2,3,MockVals,MockDips); // no ha de saltar cap error de Contracte
		m = new BuscaminesModel(2,2,4,MockVals,MockDips); //ha de saltar un error de Contracte

		 
		m = new BuscaminesModel(2,2,2,MockVals,MockDips); // no ha de saltar cap error de Contracte
		m = new BuscaminesModel(2,2,5,MockVals,MockDips);//ha de saltar un error de Contracte
		
		
	   //El pairwise no es pot fer totes les posiblitats, ja que el numMInes depen de que les altres dos estiguin bé 
	   // aixi que seria, també hem de tenir en compte que ja hem fet algus casos abans
		
		m = new BuscaminesModel(0,0,1,MockVals,MockDips); //ha de donar error
		//tots els altres casos ja estan fets.
		
		
		

	}

	@Test
	void testInicialitzaMatvalors() {
		TaulerDisponibilitat MockDips = new MockTaulerDisp();
		TaulerValors MockVals =  new MockTaulerVals();
		BuscaminesModel m = new BuscaminesModel(4,3,2,MockVals,MockDips);
		//no hi ha asserts ja que son de per contracte.
		// la i no pot ser mes gran que l'amplada ni inferior a 0, i la j no pot ser mes gran que la llargada ni inferior a 0
		//  i valor frontera -1,0 amplada-1 i amplada , valors limit -2, 1, amplada-2 i amplada+1
		// j valor frontera -1, 0, llargada-1 i llargada, valor limit -2,1, llargada-2 i llargada+1
		
		//limits
		m.inicialitzaMatvalors(-1, 0);//falla
		m.inicialitzaMatvalors(0, 0);//dona bé
		m.inicialitzaMatvalors(3, 0);//dona bé
		m.inicialitzaMatvalors(4, 0);//falla
		
		m.inicialitzaMatvalors(0,-1);//falla
		//m.inicialitzaMatvalors(0, 0);//igual que adalt
		m.inicialitzaMatvalors(0,2);//dona bé
		m.inicialitzaMatvalors(0,3);//falla
		
		//forntera
		
		m.inicialitzaMatvalors(-2, 0);//falla
		m.inicialitzaMatvalors(1, 0);//dona bé
		m.inicialitzaMatvalors(2, 0);//dona bé
		m.inicialitzaMatvalors(5, 0);//falla
		
		m.inicialitzaMatvalors(0,-2);//falla
		m.inicialitzaMatvalors(0, 1);//dona bé
		//m.inicialitzaMatvalors(0,1);//igual que l'anterior
		m.inicialitzaMatvalors(0,4);//falla
		
		
		//pairwise
		
		//m.inicialitzaMatvalors(0,0);// valid valid, ja esta fet adalt
		//m.inicialitzaMatvalors(0, -1); valid invalid, ja esta fet adalt
		//m.inicialitzaMatvalors(-1, 0); invalid valid, ja esta fet adalt
		m.inicialitzaMatvalors(-1, -1);// invalid invalid
		
		
		
		
		//fa falta fer el mock per els valor que son valids per comprovar si es pasa tot correctament
	}

	@Test
	void testGetValosr() {
		fail("Not yet implemented");
	}

	@Test
	void testIsBomba() {
		fail("Not yet implemented");
	}

}
