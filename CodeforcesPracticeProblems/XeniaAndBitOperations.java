import java.io.*;
import java.util.StringTokenizer;

public class XeniaAndBitOperations {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static int[] nums;

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

        int n = fs.nextInt(), m = fs.nextInt();
        n = 1 << n;
        nums = new int[n + 5];
        for (int i = 1; i <= n; i++)
            nums[i] = fs.nextInt();

        SegmentTree segTree = new SegmentTree(n);
        while (m-- > 0) {
            int p = fs.nextInt(), b = fs.nextInt();
            nums[p] = b;
            segTree.updateST(1, 1, n, p);
            int result = segTree.queryST();
            fw.out.println(result);
        }
    }

    private static class SegmentTree {

        private final int[] st;

        SegmentTree(int _n) {
            st = new int[(4 * _n) + 5];
            buildST(1, 1, _n);
        }

        private int buildST(int si, int ss, int se) {

            if (ss == se) {
                st[si] = nums[ss];
                return 1;
            }

            int mid = ss + ((se - ss) / 2);
            int l = buildST(2 * si, ss, mid);
            int r = buildST((2 * si) + 1, mid + 1, se);

            if (l == 1)
                st[si] = st[2 * si] | st[(2 * si) + 1];
            else
                st[si] = st[2 * si] ^ st[(2 * si) + 1];

            return (l ^ 1);
        }

        private int queryST() {

            return st[1];
        }

        private int updateST(int si, int ss, int se, int qi) {
            if (ss == se) {
                st[si] = nums[ss];
                return 1;
            }

            int mid = (ss + se) / 2;
            int temp;
            if (qi <= mid)
                temp = updateST(2 * si, ss, mid, qi);
            else
                temp = updateST((2 * si) + 1, mid + 1, se, qi);

            if (temp == 1)
                st[si] = st[2 * si] | st[(2 * si) + 1];
            else
                st[si] = st[2 * si] ^ st[(2 * si) + 1];

            return (temp ^ 1);
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
