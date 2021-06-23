/* 
    Author: Aman Patel
    Date: 10-06-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class CF725_DIV3 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();
        while (t-- > 0) {

            int n;
            n = fs.nextInt();

            long sum = 0;
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = fs.nextInt();
                sum += nums[i];
            }

            if (check(n, sum)) {
                long div = (sum / n);
                long result = 0;
                for (int i = 0; i < n; i++) {
                    if (nums[i] > div)
                        result++;
                }

                out.println(result);
            } else
                out.println(-1);
        }

        out.close();
    }

    static boolean check(int n, long sum) {
        return Math.ceil(sum / (n * 1.)) == Math.floor(sum / (n * 1.));
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
