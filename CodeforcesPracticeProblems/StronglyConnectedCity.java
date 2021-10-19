import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StronglyConnectedCity {

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
        String str1 = fs.next();
        String str2 = fs.next();

        int[][] grid = new int[n][m];

        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int[] row: grid)
                    Arrays.fill(row, 0);
                dfs(grid, str1, str2, n, m, i, j);

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        //fw.out.print(grid[x][y] + " ");
                        result &= grid[x][y];
                    }
                    //fw.out.println();
                }

                //fw.out.println();
                if (result == 0) {
                    fw.out.println("NO");
                    return;
                }
            }
        }

        fw.out.println("YES");
    }

    static void dfs(int[][] grid, String str1, String str2, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        if (grid[i][j] == 1)
            return;

        grid[i][j] = 1;
        if (str1.charAt(i) == '<')
            dfs(grid, str1, str2, n, m, i, j - 1);
        else
            dfs(grid, str1, str2, n, m, i, j + 1);

        if (str2.charAt(j) == '^')
            dfs(grid, str1, str2, n, m, i - 1, j);
        else
            dfs(grid, str1, str2, n, m, i + 1, j);
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
