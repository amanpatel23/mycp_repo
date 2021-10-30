import java.io.*;
import java.util.StringTokenizer;

public class Edu116 {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    public static void main(String[] args) throws IOException {

        fs = new FastScanner();
        fw = new FastWriter();

        int t = 1;
        t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }

        fw.out.close();
    }

    static void solve() {

        long n = fs.nextLong(), k = fs.nextLong();

        long l = 0, r = 61;
        while (r - l > 1) {
            long mid = l + ((r - l) / 2);
            if (check(k, mid))
                r = mid;
            else
                l = mid;
        }

        long temp = (check(k, l) ? l : r);
        long left = Math.max(0, n - pow(2, temp));
        long temp2 = (left + k - 1) / k;
        long result = temp + temp2;
        fw.out.println(result);
    }

    private static boolean check(long k, long x) {
        long result = pow(2L, x);
        return (result >= k);
    }

    private static long pow(long a, long b) {

        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a);
            }

            a *= a;
            b >>= 1;
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
