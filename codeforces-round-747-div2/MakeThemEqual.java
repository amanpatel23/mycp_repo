/* 
    Author: Aman Patel
    Date: 10-10-2021
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakeThenEqual {

    static FastScanner fs;
    static PrintWriter out;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    public static void main(String[] args) throws IOException {

        fs = new FastScanner();
        if (checkOnlineJudge)
            out = new PrintWriter(new FileWriter("src/output.txt"));
        else
            out = new PrintWriter(System.out);

        int t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.close();
    }

    static void solve() {
        int n = fs.nextInt();
        char c = fs.next().charAt(0);
        String str = fs.nextLine();

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) != c) {
                flag = false;
                break;
            }
        }

        if (flag) {
            out.println(0);
            return;
        }

        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (str.charAt(i - 1) != c)
                continue;

            flag = true;
            for (int j = i; j <= n; j += i) {
                if (str.charAt(j - 1) != c) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                idx = i;
                break;
            }
        }

        if (idx != 0) {
            out.println(1);
            out.println(idx);
            return;
        }

        out.println(2);
        out.println(n + " " + (n - 1));
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() throws IOException {
            if (checkOnlineJudge)
                this.br = new BufferedReader(new FileReader("src/input.txt"));
            else
                this.br = new BufferedReader(new InputStreamReader(System.in));

            this.st = new StringTokenizer("");
        }

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException err) {
                    err.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            if (st.hasMoreTokens()) {
                return st.nextToken("").trim();
            }
            try {
                return br.readLine().trim();
            } catch (IOException err) {
                err.printStackTrace();
            }
            return "";
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
