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
		
		// -2 si no esta descoberta, -3 si es bandera,-1 es bomba(no mes surt cuan perds ), 0-8 esl valors
        int[][] mat1 = {{-2,-2,-2,-2}, {-2,-2,-2,-2},{-2,-2,-2,-2},{-2,-2,-2,-2}};//matriu inicial que es mostra
        int[][] mat2 = {{-2,-2,-2,-2}, {-2,-2,-2,-2},{-2,-2,1,-2},{-2,-2,-2,-2}};
        int[][] mat3 = {{-2,-2,-2,-2}, {-2,-2,-2,-2},{-2,-2,1,-2},{-2,-2,-2,-2}};//el tecla fa la mateixa pos que a mat2
        int[][] mat4 = {{-2,-2,1,0}, {-2,-2,1,0},{-2,-2,1,1},{-2,-2,-2,-2}};
        int[][] mat5 = {{-2,-2,1,0}, {1,1,1,0},{0,1,1,1},{0,1,-2,-2}};
        int[][] mat6 = {{1,-2,1,0}, {1,1,1,0},{0,1,1,1},{0,1,-2,-2}};
        int[][] mat7 = {{1,-2,1,0}, {1,1,1,0},{0,1,1,1},{0,1,-2,1}};
        
 
		
		ArgumentCaptor<int[][]> captor = ArgumentCaptor.forClass(int[][].class);
        verify(mockVist, times(7)).mostrarTauler(captor.capture());
      
        
        List<int[][]> matVista = captor.getAllValues();


        compararMatrius(mat1,matVista.get(0));
        compararMatrius(mat2,matVista.get(1));
        compararMatrius(mat3,matVista.get(2));
        compararMatrius(mat4,matVista.get(3));
        compararMatrius(mat5,matVista.get(4));
        compararMatrius(mat6,matVista.get(5));
        compararMatrius(mat7,matVista.get(6));
        
        
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

		when(mockMod.isBomba(2, 2)).thenReturn(false).thenReturn(true); 
		
		when(mockMod.getValosr(2, 2)).thenReturn(new int[][] {{1,2,2}}).thenReturn(new int[][] {{}});
		when(mockMod.getValosr(0, 3)).thenReturn(new int[][] {{0,0,3},{1,0,2},{1,1,2},{0,1,3},{1,2,2},{1,2,3}});
		when(mockMod.getValosr(2, 0)).thenReturn(new int[][] {{0,2,0},{1,1,0},{1,1,1},{1,2,1},{0,3,0},{1,3,1}});
		when(mockMod.getValosr(0, 0)).thenReturn(new int[][] {{1,0,0}});
		when(mockMod.getValosr(3, 3)).thenReturn(new int[][] {{1,3,3}});
		//matriu que es creara
		//  1  1 
		// -1  1 
	
		
		c = new Controlador(mockMod, mockVist, mockTec);
		
		c.jugar();
		
		// -2 si no esta descoberta, -3 si es bandera,-1 es bomba(no mes surt cuan perds ), 0-8 esl valors
        mat1 = new int[][]{{-2,-2}, {-2,-2}};//matriu inicial que es mostra
        mat2 = new int[][]{{-2,-3}, {-2,-2}};
        mat3 = new int[][]{{-2,-3}, {-2,-2}};
        mat4 = new int[][]{{-2,-2}, {-2,-2}};
        mat5 = new int[][]{{-2, 1}, {-2,-2}};
        mat6 = new int[][]{{1,1}, {-1,1}};

		
		captor = ArgumentCaptor.forClass(int[][].class);
        verify(mockVist, times(6)).mostrarTauler(captor.capture());
      

        matVista = captor.getAllValues();


        compararMatrius(mat1,matVista.get(0));
        compararMatrius(mat2,matVista.get(1));
        compararMatrius(mat3,matVista.get(2));
        compararMatrius(mat4,matVista.get(3));
        compararMatrius(mat5,matVista.get(4));
        compararMatrius(mat6,matVista.get(5));
        
        
        
        
        

        
        

	}



}
