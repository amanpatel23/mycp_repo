/* 
    Author: Aman Patel
    Date: 30-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class IHate111 {

    final static int[] oneOne = new int[]{0, 1, 11, 111, 1111, 11111, 111111, 1111111, 11111111, 111111111, 1111111111};

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {

            int x;
            x = fs.nextInt();

            boolean flag = false;
            while (x >= 11) {
                if (x % 11 == 0 || x % 111 == 0) {
                    flag = true;
                    break;
                }

                x -= 111;
            }

            if (flag)
                out.println("YES");
            else
                out.println("NO");
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
