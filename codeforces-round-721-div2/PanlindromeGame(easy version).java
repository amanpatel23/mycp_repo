/* 
    Author: Aman Patel
    Date: 20-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class CF721_2 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();
            String s;
            s = fs.next();

            int _zero = countZero(s, n);
            if ((n & 1) == 1) {
                if (_zero == 1)
                    out.println("BOB");
                else {
                    if (s.charAt(n / 2) == '0')
                        out.println("ALICE");
                    else
                        out.println("BOB");
                }
            } else {
                out.println("BOB");
            }
        }

        out.close();
    }

    static int countZero(String s, int n) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0')
                result += 1;
        }

        return result;
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
