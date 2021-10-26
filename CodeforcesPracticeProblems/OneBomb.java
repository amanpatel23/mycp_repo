import java.io.*;
import java.util.StringTokenizer;

public class OneBomb {

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

        int n = fs.nextInt(), m = fs.nextInt();
        char[][] grid = new char[n][m];
        int walls = 0;
        for (int i = 0; i < n; i++) {
            grid[i] = fs.next().toCharArray();
        }

        int[] rows = new int[n], cols = new int[m];
        for (int i = 0; i < n; i++) {
            int _count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '*')
                    _count++;
            }
            rows[i] = _count;
            walls += _count;
        }

        for (int j = 0; j < m; j++) {
            int _count = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] == '*')
                    _count++;
            }
            cols[j] = _count;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int curr = rows[i] + cols[j] - ((grid[i][j] == '*') ? 1 : 0);
                if (curr == walls) {
                    fw.out.println("YES");
                    fw.out.println((i + 1) + " " + (j + 1));
                    return;
                }
            }
        }

        fw.out.println("NO");
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
