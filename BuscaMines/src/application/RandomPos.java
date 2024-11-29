package application;

public class RandomPos implements Random {

	@Override
	public int[] Random(int i, int j) {
		java.util.Random random = new java.util.Random();
        int posX = random.nextInt(i);
        int posY = random.nextInt(j);
        return new int[]{posX, posY};
	}

}
