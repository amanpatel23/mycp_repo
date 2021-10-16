import java.io.*;
import java.util.StringTokenizer;

public class MoreCowbell {

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

        int n = fs.nextInt(), k = fs.nextInt();
        int[] bells = new int[n];
        for (int i = 0; i < n; i++)
            bells[i] = fs.nextInt();

        int l = bells[n - 1], r = 2 * bells[n - 1];
        while (r - l > 1) {
            int mid = l + ((r - l) / 2);
            if (check(n, bells, k, mid))
                r = mid;
            else
                l = mid;
        }

        if (check(n, bells, k, l)) {
            fw.out.println(l);
        } else {
            fw.out.println(r);
        }
    }

    private static boolean check(int n, int[] bells, int k, int x) {

        int _count = 0;
        int i = 0, j = n;
        while (true) {
            if (i >= j)
                break;

            _count++;
            j--;
            while (j - i >= 1) {
                if (bells[i] + bells[j] <= x)
                    break;
                _count++;
                j--;
            }

            i++;
        }

        return (_count <= k);
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
