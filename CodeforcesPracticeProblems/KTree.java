import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KTree {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static int n, k, d;
    private static long[][] dp;

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

        n = fs.nextInt();
        k = fs.nextInt();
        d = fs.nextInt();

        dp = new long[n + 5][2];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);

        long result = ways(0, 0);
        fw.out.println(result);
    }

    static long ways(int sum, int check) {

        if (sum > n)
            return 0;
        if (sum == n)
            return ((check == 1) ? 1 : 0);

        if (dp[sum][check] != -1)
            return dp[sum][check];

        long ans = 0;
        for (int i = 1; i <= k; i++) {
            int temp = (i >= d) ? 1 : 0;
            ans = (ans + ways(sum + i, (check | temp)) % mod) % mod;
        }

        return dp[sum][check] = ans;
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
