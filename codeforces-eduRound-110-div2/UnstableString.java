/* 
    Author: Aman Patel
    Date: 04-06-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class UnstableString {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            String s = fs.next();
            int len = s.length();

            long result = 0;
            int _count = 0;
            // '1' at odd position
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '?')
                    _count += 1;
                else if (((i & 1) == 1 && s.charAt(i) == '1') || ((i & 1) == 0 && s.charAt(i) == '0'))
                    _count += 1;
                else {
                    result += (subResult(_count));
                    _count = 0;
                }
            }

            result += subResult(_count);
            _count = 0;

            // '0' at odd position
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '?')
                    _count += 1;
                else if (((i & 1) == 1 && s.charAt(i) == '0') || ((i & 1) == 0 && s.charAt(i) == '1'))
                    _count += 1;
                else {
                    result += (subResult(_count));
                    _count = 0;
                }
            }

            result += (subResult(_count));
            _count = 0;

            // substract overcounted '?'
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == '?')
                    _count += 1;
                else {
                    result -= (subResult(_count));
                    _count = 0;
                }
            }

            result -= (subResult(_count));
            out.println(result);
        }

        out.close();
    }

    static long subResult(int _count) {
        return ((long) (_count) * (_count + 1)) / 2;
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
