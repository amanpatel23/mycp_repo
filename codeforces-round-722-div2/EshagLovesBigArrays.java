/* 
    Author: Aman Patel
    Date: 24-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class CF722_1 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();

            int[] nums;
            nums = fs.readArray(n);

            int _min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] < _min)
                    _min = nums[i];
            }

            int result = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > _min)
                    result++;
            }

            out.println(result);
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
