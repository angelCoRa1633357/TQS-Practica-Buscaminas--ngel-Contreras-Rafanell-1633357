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
	void compararMatrius(int[][] mat1, int[][] mat2) {
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[0].length;j++) {
				assertEquals(mat1[i][j],mat2[i][j]);
			}
		}
	}

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
		.thenReturn(new int[] {0,-1,0}).thenReturn(new int[] {0,4,4}).thenReturn(new int[] {0,2,0}).thenReturn(new int[] {0,0,0})
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
		

        
        
        
        

        
        

	}



}
