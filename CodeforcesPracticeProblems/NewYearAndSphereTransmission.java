import java.io.*;
import java.util.*;

public class NewYearAndSphereTransmission {
	public static void main(String[] args) {

		FastScanner fs = new FastScanner();
		int n = fs.nextInt();

		ArrayList<Long> result = new ArrayList<Long>();
		for (int i = 1; i * i <= n; i++) {
			if (n % i == 0) {
				int ele1 = n / i;
				result.add(calcSum(ele1, i));
				if (ele1 != i) {
					result.add(calcSum(i, ele1));       
				}
			}
		}

		Collections.sort(result);
		for (long x : result)
			System.out.print(x + " ");
	}

	public static Long calcSum(int ele, int d) {
		long sum = (ele * 1L * (2L + ((ele - 1) * 1L * d))) / 2;
		return sum;
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