import java.io.*;
import java.util.StringTokenizer;

public class Flowers {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static final int maxV = (int) (1e5);

    public static void main(String[] args) throws IOException {

        fs = new FastScanner();
        fw = new FastWriter();

        int t = 1;
        //t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }

        fw.out.close();
    }

    static void solve() {

        int q = fs.nextInt(), k = fs.nextInt();
        long[] dp = new long[maxV + 5];
        dp[0] = 1;
        for (int i = 1; i <= maxV; i++) {
            dp[i] = (dp[i - 1] + ((i - k >= 0) ? dp[i - k] : 0)) % mod;
        }

        long[] prefixSum = new long[maxV + 5];
        for (int i = 1; i <= maxV; i++) {
            prefixSum[i] = (dp[i] + prefixSum[i - 1]) % mod;
        }

        while (q-- > 0) {
            int a = fs.nextInt(), b = fs.nextInt();
            long result = (prefixSum[b] - prefixSum[a - 1] + mod) % mod;
            fw.out.println(result);
        }
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

    private static class FastWriter {
        PrintWriter out;

        FastWriter() throws IOException {
            if (checkOnlineJudge)
                out = new PrintWriter(new FileWriter("src/output.txt"));
            else
                out = new PrintWriter(System.out);
        }
    }
}
