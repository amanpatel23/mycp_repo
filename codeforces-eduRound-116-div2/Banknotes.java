import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Banknotes {

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

        int n = fs.nextInt(), k = fs.nextInt();
        ArrayList<Integer> tenPows = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int ai = fs.nextInt();
            tenPows.add(pow(10, ai));
        }

        long result = 0;
        int req = k + 1;
        for (int i = 0; i < (n - 1); i++) {
            int max = ((tenPows.get(i + 1)) / tenPows.get(i)) - 1;
            int taken = Math.min(max, req);
            result += ((long) taken * tenPows.get(i));
            req -= taken;
        }

        result += ((long) req * tenPows.get(n - 1));
        fw.out.println(result);
    }

    private static int pow(int a, int b) {

        int result = 1;
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
