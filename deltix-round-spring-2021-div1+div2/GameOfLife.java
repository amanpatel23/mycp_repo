/* 
    Author: Aman Patel
    Date: 30-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class HadChange {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {

            int n, m;
            n = fs.nextInt();
            m = fs.nextInt();

            String s;
            StringBuilder newStr = new StringBuilder();
            s = fs.next();
            while (m-- > 0) {

                boolean hadChange = false;
                for (int i = 0; i < n; i++) {
                    if (s.charAt(i) == '0') {

                        if (i == 0) {
                            if (s.charAt(i + 1) == '1') {
                                newStr.append("1");
                                hadChange = true;
                            } else
                                newStr.append("0");
                        } else if (i == n - 1) {
                            if (s.charAt(i - 1) == '1') {
                                newStr.append("1");
                                hadChange = true;
                            } else
                                newStr.append("0");
                        } else if ((s.charAt(i - 1) == '1' && s.charAt(i + 1) == '0') || (s.charAt(i - 1) == '0' && s.charAt(i + 1) == '1')) {
                            hadChange = true;
                            newStr.append("1");
                        } else
                            newStr.append("0");
                    } else
                        newStr.append(s.charAt(i));
                }

                if (!hadChange)
                    break;

                s = newStr.toString();
                newStr = new StringBuilder();
            }

            out.println(s);
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
