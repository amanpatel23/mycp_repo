/* 
    Author: Aman Patel
    Date: 10-10-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class RubicksCubeColoring1 {

    static FastScanner fs;
    static PrintWriter out;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {

        fs = new FastScanner();
        if (checkOnlineJudge)
            out = new PrintWriter(new FileWriter("src/output.txt"));
        else
            out = new PrintWriter(System.out);

        int t = 1;
        //t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }

        out.close();
    }

    static void solve() {
        int k = fs.nextInt();
        long nodes = (1L << k) - 1;
        long result = (6 * (pow(4, nodes - 1))) % mod;
        out.println(result);
    }

    static long pow(long _a, long _b) {

        long a = _a, b = _b;
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }

            a = (a * a) % mod;
            b = b >> 1;
        }

        return result;
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
