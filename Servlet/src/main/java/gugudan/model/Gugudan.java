package gugudan.model;

public class Gugudan {
	public int[] gugu(int n) {
		int[] result = new int[9];
		for (int i = 1; i < 10; i++) {
			result[i-1] = n * 1;
		}
		return result;
	}
}
