/* 
    Author: Aman Patel
    Date: 16-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class Ed109 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int k;
            k = fs.nextInt();

            if (k == 100)
                out.println(1);
            else {
                int x = k;
                int y = 100 - k;

                int _min = Math.min(x, y);
                int _max = Math.max(x, y);

                int d = _min;
                while (d >= 2) {
                    if (_max % d == 0 && _min % d == 0) {
                        _max /= d;
                        _min /= d;
                    }

                    d--;
                }

                out.println(_max + _min);
            }
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
