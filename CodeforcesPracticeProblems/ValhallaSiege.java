import java.io.*;
import java.util.StringTokenizer;

public class ValhallaSiege {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

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

        int n = fs.nextInt(), q = fs.nextInt();
        long[] prefixSum = new long[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                prefixSum[i] = fs.nextInt();
            else
                prefixSum[i] = prefixSum[i - 1] + fs.nextInt();
        }

        long prev = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            long arrows = prev + fs.nextLong();
            int idx = binarySearch(n, prefixSum, arrows);
            if (idx == (n - 1)) {
                result.append(n).append("\n");
                prev = 0;
            }else {
                result.append(n - 1 - idx).append("\n");
                prev = arrows;
            }
        }

        fw.out.println(result);
    }

    static int binarySearch(int n, long[] prefixSum, long arrows) {
        int l = 0, r = n - 1;
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (prefixSum[mid] <= arrows)
                l = mid;
            else
                r = mid;
        }

        if (prefixSum[r] <= arrows)
            return r;
        if (prefixSum[l] <= arrows)
            return l;
        return (l - 1);
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
