package application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

class ControladorTest {
	

	@Test
	void testJugar() {
		//creem una partida normal en la cual es una matriu 4x4, i on es probara casos on el teclat repeteixi pocision, 
		//pocicions invalide(fora de la cuadaricula). Al final a de guanyar en aquest cas de proba.
		Teclat mockTec = mock(Teclat.class);
		Vista mockVist = mock(Vista.class);
		Model mockMod = mock(Model.class);//l'utilitzo mock per poder arribar a la matriu desitjada
		
		when(mockMod.getLlargada()).thenReturn(4);
		when(mockMod.getAmplada()).thenReturn(4);
		when(mockMod.getNumMines()).thenReturn(2);
		when(mockTec.getPosTeclat()).thenReturn(new int[] {0,2,2}).thenReturn(new int[] {0,2,2}).thenReturn(new int[] {0,0,3})
		.thenReturn(new int[] {0,-1,0}).thenReturn(new int[] {0,4,0}).thenReturn(new int[] {2,0,4,4})//erros i condition/decision coberage
		.thenReturn(new int[] {0,0,-1}).thenReturn(new int[] {0,0,4}).thenReturn(new int[] {-1,3,3})//erros i condition/decision coberage
		.thenReturn(new int[] {4,0,0})//erros i condition/decision coberage
		.thenReturn(new int[] {0,2,0}).thenReturn(new int[] {0,0,0})
		.thenReturn(new int[] {0,3,3});
		when(mockMod.isBomba(2, 2)).thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false)
		.thenReturn(false).thenReturn(false).thenReturn(false).thenReturn(false);
		
		when(mockMod.getValosr(2, 2)).thenReturn(new int[][] {{1,2,2}}).thenReturn(new int[][] {{}});
		when(mockMod.getValosr(0, 3)).thenReturn(new int[][] {{0,0,3},{1,0,2},{1,1,2},{0,1,3},{1,2,2},{1,2,3}});
		when(mockMod.getValosr(2, 0)).thenReturn(new int[][] {{0,2,0},{1,1,0},{1,1,1},{1,2,1},{0,3,0},{1,3,1}});
		when(mockMod.getValosr(0, 0)).thenReturn(new int[][] {{1,0,0}});
		when(mockMod.getValosr(3, 3)).thenReturn(new int[][] {{1,3,3}});
		//matriu que es creara
		// 1 -1  1 0
		// 1  1  1 0
		// 0  1  1 1
		// 0  1 -1 1
		
		Controlador c = new Controlador(mockMod, mockVist, mockTec);
		
		c.jugar();
		

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
		//creem una partida normal en la cual es una matriu 2x2, i on es provara ficar banderes, seleccionar la banders(nomes es pot treure
        //si es selecciona un altre cop la banders), treure la banders, i tornar a seleccionar la pos, i perdre clicant a la mina
        //Mirarem el misatges

        
		mockTec = mock(Teclat.class);
		mockVist = mock(Vista.class);
		mockMod = mock(Model.class);//l'utilitzo mock per poder arribar a la matriu desitjada
		
		when(mockMod.getLlargada()).thenReturn(2);
		when(mockMod.getAmplada()).thenReturn(2);
		when(mockMod.getNumMines()).thenReturn(1);
		when(mockTec.getPosTeclat()).thenReturn(new int[] {1,0,1}).thenReturn(new int[] {0,0,1}).thenReturn(new int[] {1,0,1})
		.thenReturn(new int[] {0,0,1}).thenReturn(new int[] {0,1,1});

		when(mockMod.isBomba(0, 1)).thenReturn(false); 
		
		when(mockMod.isBomba(1, 1)).thenReturn(true); 
		
		when(mockMod.getValosr(0, 1)).thenReturn(new int[][] {{1,0,1}});

		//matriu que es creara
		//  1  1 
		// -1  1 
	
		
		c = new Controlador(mockMod, mockVist, mockTec);
		
		c.jugar();
		
		

		assertThrows(AssertionError.class, () -> {//fer saltar asert controlador
			Teclat mockTec2 = mock(Teclat.class);
			Vista mockVist2 = mock(Vista.class);
			Model mockMod2 = mock(Model.class);
			when(mockMod2.getAmplada()).thenReturn(2);		
			when(mockMod2.getLlargada()).thenReturn(-1);
			Controlador c2 = new Controlador(mockMod2, mockVist2, mockTec2);
		});
		

		assertThrows(AssertionError.class, () -> {//fer saltar asert controlador
			Teclat mockTec3 = mock(Teclat.class);
			Vista mockVist3 = mock(Vista.class);
			Model mockMod3 = mock(Model.class);
					
			when(mockMod3.getAmplada()).thenReturn(-1);
			Controlador c3 = new Controlador(mockMod3, mockVist3, mockTec3);
		});
		
		
		assertThrows(AssertionError.class, () -> {//fer saltar asert controlador
			Teclat mockTec4 = mock(Teclat.class);
			Vista mockVist4 = mock(Vista.class);
			Model mockMod4 = mock(Model.class);
					
			when(mockMod4.getLlargada()).thenReturn(2);
			when(mockMod4.getAmplada()).thenReturn(2);
			when(mockMod4.getNumMines()).thenReturn(4);
			Controlador c4 = new Controlador(mockMod4, mockVist4, mockTec4);
		});
		
		

		
		


        
        
        
        

        
        

	}



}
