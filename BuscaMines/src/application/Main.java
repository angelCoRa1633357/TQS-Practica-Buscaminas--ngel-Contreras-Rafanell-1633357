package application;


public class Main{

	public static void main(String[] args) {
		Vista v = new VistaBuscamines();
		Teclat t =new TeclatBuscamines();
		Random r = new RandomPos();
		TaulerValors Tv = new BuscaminesTaulerValors(r);
		TaulerDisponibilitat Td = new BuscaminesTaulerDisp();

		int a;
		while(true) {
			System.out.print("dona Amplada");
			a=t.getAmplada();
			if(a>0) {
				break;
			}
		}
		
		int l;
		while(true) {
			System.out.print("dona Llargada");
			l=t.getLlargada();
			if(l>0) {
				break;
			}
		}
		
		int m;
		while(true) {
			System.out.print("dona Mines");
			m=t.getMines();
			if(m>0 && m<l*a) {
				break;
			}
		}
		
		Model mod= new BuscaminesModel(l,a,m,Tv,Td);
		Controlador c = new Controlador(mod,v,t);
		c.jugar();
	}
}
