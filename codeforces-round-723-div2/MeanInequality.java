/* 
    Author: Aman Patel
    Date: 30-05-2021
*/


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeanInequality {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();

            n *= 2;
            int[] nums = fs.readArray(n);
            Arrays.sort(nums);

            for (int i = 0; i < n / 2; i++) {
                out.print(nums[i] + " " + (nums[n - i - 1]) + " ");
            }
            out.println();

        }

        out.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
