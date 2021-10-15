import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MikeAndFun {

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

        int n = fs.nextInt(), m = fs.nextInt(), q = fs.nextInt();
        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                grid[i][j] = fs.nextInt();
        }

        Comparator<Integer> myComp = (o1, o2) -> (o2 - o1);
        int[] prevLongest = new int[n];
        int[] freq = new int[m + 5];
        Arrays.fill(freq, 0);
        PriorityQueue<Integer> pq = new PriorityQueue<>(myComp);

        for (int i = 0; i < n; i++) {
            int substr = longestSubstr(grid, i);
            prevLongest[i] = substr;
            freq[substr]++;
            if (freq[substr] == 1)
                pq.add(substr);
        }

        while (q-- > 0) {
            int i = fs.nextInt() - 1, j = fs.nextInt() - 1;
            int prev = prevLongest[i];
            freq[prev]--;
            grid[i][j] ^= 1;

            int curr = longestSubstr(grid, i);
            freq[curr]++;
            if (freq[curr] == 1)
                pq.add(curr);

            while (true) {
                int top = pq.peek();
                if (freq[top] == 0) {
                    pq.poll();
                    continue;
                }

                fw.out.println(top);
                break;
            }

            prevLongest[i] = curr;
        }
    }

    private static int longestSubstr(int[][] grid, int row) {
        int global = 0, curr = 0;
        for (int x : grid[row]) {
            if (x == 1) {
                curr++;
                continue;
            }

            global = Math.max(global, curr);
            curr = 0;
        }

        global = Math.max(global, curr);
        return global;
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
