package application;

public interface Vista {
	void mostrarTauler(int[][] mat);
	void mostrarTitol();
	void mostrarInfo();
	void mostrarError(String msg);
	void flush();
	void flushNumLins(int n);
	void demanrPos();
	void demanarTamanys();
	void mostrarPerdut();
	void mostrarGuanyat();

}
