package application;

public class VistaBuscamines implements Vista {

	@Override
	public void mostrarTauler(int[][] mat) {
	    String reset = "\u001B[0m";  // Reset de color
	    String green = "\u001B[32m"; // Verd
	    String red = "\u001B[31m";   // Vermell
	    String yellow = "\u001B[33m"; // Groc
	    String blue = "\u001B[34m";  // Blau

	    System.out.println("Tauler actual:");
	    System.out.print("   "); // 
	    
	    for (int col = 0; col < mat[0].length; col++) {
	        System.out.printf("%2d ", col);
	    }
	    System.out.println();
	    for (int fila = 0; fila < mat.length; fila++) {
	        System.out.printf("%2d ", fila);
	        for (int celda : mat[fila]) {
	            if (celda == -2) {
	                System.out.print(blue + " ■ " + reset); 
	            } else if (celda == -3) {
	                System.out.print(yellow + " ⚑ " + reset); 
	            } else if (celda == -1) {
	                System.out.print(red + " ✹ " + reset); 
	            } else {
	                System.out.printf(green + "%2d " + reset, celda); 
	            }
	        }
	        System.out.println();
	    }
	    System.out.println();
	}

	@Override
	public void mostrarTitol() {
	    String[] colors = {
	            "\u001B[31m", // Vermell
	            "\u001B[33m", // Groc
	            "\u001B[32m", // Verd
	            "\u001B[36m", // Cian
	            "\u001B[34m", // Blau
	            "\u001B[35m", // Magenta
	        };
	        String reset = "\u001B[0m"; // Reset de color
		String[] titol = {
		        "██████╗  ██╗  ██╗███████╗ ██████╗ █████╗ ███╗   ███╗██╗███╗   ██╗███████╗███████╗\n" +
		        "██╔══██╗ ██║  ██║██╔════╝██╔════╝██╔══██╗████╗ ████║██║████╗  ██║██╔════╝██╔════╝\n" +
		        "██████╔╝ ██║  ██║███████╗██║     ███████║██╔████╔██║██║██╔██╗ ██║█████╗  ███████╗\n" +
		        "██   ██╗ ██║  ██║╚════██║██║     ██╔══██║██║╚██╔╝██║██║██║╚██╗██║██╔══╝  ╚════██║\n" +
		        "██████╔╝ ██████╔╝███████║╚██████╗██║  ██║██║ ╚═╝ ██║██║██║ ╚████║███████╗███████╗\n" +
		        "╚═════╝  ╚═════╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝╚═╝  ╚═══╝╚══════╝╚══════╝\n"
		};
		
	    System.out.println();
	    for (int i = 0; i < titol.length; i++) {
	        // Alterna colors: cada línia té un color diferent
	        System.out.println(colors[i % colors.length] + titol[i] + reset);
	    }
	    System.out.println();

	}

	@Override
	public void mostrarInfo() {
        System.out.println("Introduïu acció (0 = descobrir, 1 = bandera), fila i columna.");
        System.out.println("⚑ = bandera, ✹ = bomba, ■ = cel·la no descoberta.");

	}

	@Override
	public void mostrarError(String msg) {
		System.out.println("Error: " + msg);
	}

	@Override
	public void flush() {
		System.out.flush();
	}

	@Override
	public void flushNumLins(int n) {
		// TODO Auto-generated method stub

	}

	@Override
	public void demanrPos() {
		System.out.println("Introduïu la vostra següent posició:");
	}

	@Override
	public void demanarTamanys() {
        System.out.println("Introduïu les dimensions del tauler i el nombre de mines:");

	}

	@Override
	public void mostrarPerdut() {
	    String red = "\u001B[31m"; // Vermell
	    String reset = "\u001B[0m";  // Reset de color
		System.out.println(red  +
		        "██╗  ██╗ █████╗ ███████╗   ██████╗ ███████╗██████╗  █████══╗  ██╗  ██╗████████╗\n" +
		        "██║  ██║██╔══██╗██╔════╝   ██╔══██╗██╔════╝██╔══██╗ ██   ██╚╗ ██║  ██║╚══██╔══╝\n" +
		        "███████║███████║███████╗   ██████╔╝█████╗  ██████╔╝ ██    ██║ ██║  ██║   ██║\n" +
		        "██╔══██║██╔══██║╚════██║   ██╔═══╝ ██╔══╝  ██  ██╚╗ ██   ██╔╝ ██║  ██║   ██║\n" +
		        "██║  ██║██║  ██║███████║   ██║     ███████╗██  ███║ ██████╔╝  ██████╔╝   ██║\n" +
		        "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝     ╚══════╝╚══════╝ ╚═════╝    ╚════╝ \n" +
		        reset
		    );

	}

	@Override
	public void mostrarGuanyat() {
	    String green = "\u001B[32m"; // Verd
	    String reset = "\u001B[0m";  // Reset de color
		System.out.println(green +
		        "██╗  ██╗ █████╗ ███████╗    ██████╗ ██╗  ██╗ █████╗ ███╗   ██╗██╗   ██╗ █████╗ ████████╗\n" +
		        "██║  ██║██╔══██╗██╔════╝   ██╔════╝ ██║  ██║██╔══██╗████╗  ██║██║   ██║██╔══██╗╚══██╔══╝\n" +
		        "███████║███████║███████╗   ██║  ███╗██║  ██║███████║██╔██╗ ██║╚██╗ ██╔╝███████║   ██║\n" +
		        "██╔══██║██╔══██║╚════██║   ██║   ██║██║  ██║██╔══██║██║╚██╗██║  ╚██╔═╝ ██╔══██║   ██║\n" +
		        "██║  ██║██║  ██║███████║   ╚██████╔╝██████╔╝██║  ██║██║ ╚████║   ██║   ██║  ██║   ██║\n" +
		        "╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝     ╚═════╝╚═════╝  ╚═════╝ ╚═╝  ╚═╝╚   ╚═╝    ╚═════╝   ╚═╝ \n" +
		        reset
		    );

	}

}
