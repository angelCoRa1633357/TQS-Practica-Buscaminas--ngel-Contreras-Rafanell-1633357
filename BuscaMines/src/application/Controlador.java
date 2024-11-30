package application;

public class Controlador {
	
	Model mod;
	Vista vis;
	Teclat tec;
	int desc=0;
	int[][] mat;
	
	Controlador(Model m,Vista v,Teclat t){
		this.mod=m;
		this.vis=v;
		this.tec=t;
		this.mat=new int[m.getAmplada()][m.getLlargada()];
		for(int i=0;i<m.getAmplada();i++) {
			for(int j=0;j<m.getLlargada();j++) {
				this.mat[i][j]=-2;
			}
		}
		
	}
	
	public void jugar() {
		
		vistaPlatilla();
		
		while(true) {
			int[] pos=getPos();
			
	        assert pos.length == 3;
	        assert pos[0] == 0 || pos[0] == 1;
	        assert pos[1] >= 0 && pos[1] < mod.getAmplada();
	        assert pos[2] >= 0 && pos[2] < mod.getLlargada();
	        
            int accio = pos[0]; 
            int fila = pos[1];
            int columna = pos[2];
            
            if(accio==0) {
            	//System.out.print(fila + " " + columna);
            	if(this.desc==0) {
        			this.mod.inicialitzaMatvalors(fila, columna);
        		}
            	if(mat[fila][columna]==-3) {
                    vis.mostrarError("No pots descobrir una cel·la marcada amb una bandera.");
            	}else if(mod.isBomba(fila, columna)) {
            		vis.mostrarPerdut();
            		vis.mostrarTauler(mod.getMatVals());
            		
            		break;
            	}else {
            		
            		int[][] valors = mod.getValosr(fila, columna);
            		actualitzarMatriu(valors);
            		
            		if(haGuanyat()) {
            			this.vis.mostrarGuanyat();
            			break;
            		}else {
            			vistaPlatilla();
            		}
            	}
            		
            	}else {
            		if(mat[fila][columna]==-3) {
            			mat[fila][columna]=-2;
            		}else {
            			mat[fila][columna]=-3;
            		}
            		
            		vistaPlatilla();
            	}
            }
			
		}
		
		
		
	
	
	private boolean haGuanyat() {
		
		if(this.desc == (mod.getAmplada()*mod.getLlargada()-mod.getNumMines())) {
		
			return true;
		}else {
			return false;
		}
	}
	
	private void vistaPlatilla() {
		this.vis.flush();
		this.vis.mostrarTitol();
		this.vis.mostrarInfo();
		this.vis.mostrarTauler(this.mat);
		this.vis.demanrPos();
		
	}
	
	private int[] getPos(){
		int[] pos;
		
		while(true) {
			pos = this.tec.getPosTeclat();
			if(pos.length==3) {
				if(pos[0]>1 ||pos[0]<0||pos[1]>this.mod.getAmplada()-1 || pos[1]<0 ||pos[2]>this.mod.getLlargada()-1 || pos[2]<0 ) {
					String msgError="El format ha de ser: Descobrir(0)/Bandera(1) fila columna. Ex 1 2.";
					String msgError2="La fila ha de ser un numero del 0 al " + (mod.getAmplada()-1) ;
					String msgError3="La columna ha de ser un numero del 0 al " + (mod.getLlargada()-1) ;
					this.vis.flushNumLins(2);
					this.vis.mostrarError(msgError);
					this.vis.mostrarError(msgError2);
					this.vis.mostrarError(msgError3);
					this.vis.demanrPos();
				}else {
					return pos;
				}
				
			}
			
		}
	}
	
	private void actualitzarMatriu(int[][] valors) {
		
        for (int i=0;i<valors.length;i++) {
            if(valors[i].length==3) {
            	int fila = valors[i][1];
                int columna = valors[i][2];
                int valorCelda = valors[i][0];
                
                assert fila >= 0 && fila < this.mat.length ;
                assert columna >= 0 && columna < this.mat[0].length;
                if(this.mat[fila][columna]!=valorCelda) {
                	this.mat[fila][columna] = valorCelda;
                	this.desc++;
                }
                
            	
            }
            
        }
	

}
}
