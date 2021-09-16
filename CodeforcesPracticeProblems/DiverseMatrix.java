import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DiverseMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FastScanner fs = new FastScanner();
		int r = fs.nextInt(), c = fs.nextInt();
		
		if (r == 1 && c == 1) {
			System.out.println(0);
			return;
		}
		
		StringBuilder result = new StringBuilder();
		if (r == 1) {
			for (int i = 0; i < c; i++)
				result.append((i + 2) + " ");
			System.out.println(result);
			return;
		}
		
		if (c == 1) {
			for (int i = 0; i < r; i++)
				result.append((i + 2) + "\n");
			System.out.print(result);
			return;
		}
		
		int firstRow[] = new int[c];
		for (int i = 0; i < c; i++) {
			firstRow[i] = i + 2;
			result.append((i + 2) + " ");
		}
		result.append("\n");
		
		int nextRowGCD = c + 2;
		for (int i = 1; i < r; i++) {
			for (int j = 0; j < c; j++)
				result.append((nextRowGCD * firstRow[j]) + " ");
			result.append("\n");
			nextRowGCD++;
		}
		
		System.out.println(result);
	}

	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");

		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}
	}

}
