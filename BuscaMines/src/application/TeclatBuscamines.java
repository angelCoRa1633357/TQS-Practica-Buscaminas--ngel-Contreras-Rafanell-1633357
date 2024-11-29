package application;
import java.util.Scanner;
public class TeclatBuscamines implements Teclat {
	private Scanner scanner = new Scanner(System.in);
	@Override
	public int[] getPosTeclat() {

        String input = scanner.nextLine();
        String[] parts = input.split(" ");
		
		return new int[] {Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2])};
	}

	@Override
	public int getMines() {
        return Integer.parseInt(scanner.nextLine());
	}

	@Override
	public int getAmplada() {
        return Integer.parseInt(scanner.nextLine());
	}

	@Override
	public int getLlargada() {
        return Integer.parseInt(scanner.nextLine());
	}

}
