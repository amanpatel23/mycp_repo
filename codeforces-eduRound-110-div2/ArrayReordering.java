/* 
    Author: Aman Patel
    Date: 04-06-2021
*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ArrayReordering {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();

            List<Integer> odds = new ArrayList<>();
            int evens = 0;

            int temp;
            for (int i = 0; i < n; i++) {
                temp = fs.nextInt();
                if ((temp & 1) == 0)
                    evens += 1;
                else {
                    if (temp != 1)
                        odds.add(temp);
                }
            }

            long result = 0;
            temp = n - 1;
            for (int i = 0; i < evens; i++) {
                result += temp;
                temp--;
            }

            int len = odds.size();
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (gcd(odds.get(i), odds.get(j)) > 1)
                        result += 1;
                }
            }

            out.println(result);
        }

        out.close();
    }

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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
