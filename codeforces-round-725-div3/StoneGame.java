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

            int[] nums = fs.readArray(n);
            int minIdx = -1, minVal = Integer.MAX_VALUE;
            int maxIdx = -1, maxVal = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] > maxVal) {
                    maxVal = nums[i];
                    maxIdx = i;
                }

                if (nums[i] < minVal) {
                    minVal = nums[i];
                    minIdx = i;
                }
            }

            int a = Math.min(maxIdx, minIdx);
            int b = Math.max(maxIdx, minIdx);

            //out.println(a + " " + b);
            int temp1 = b + 1;
            int temp2 = n - a;
            int temp3 = a + 1 + (n - b);

            //out.println(temp1 + " " + temp2 + " " + temp3);
            int result = Math.min(Math.min(temp1, temp2), temp3);
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
