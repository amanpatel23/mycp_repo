import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SeaAndIslands {

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
        if (n == 1) {
            if (k > 1)
                fw.out.println("NO");
            else {
                fw.out.println("YES");
                fw.out.println((k == 0) ? 'S' : 'L');
            }
            return;
        }

        int maxIslands = 0;
        if ((n & 1) == 1) {
            maxIslands = ((n / 2 + 1) * (n / 2 + 1)) + ((n / 2) * (n / 2));
        }else {
            maxIslands = n * (n / 2);
        }

        //fw.out.println(maxIslands);
        if (k > maxIslands) {
            fw.out.println("NO");
            return;
        }

        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(result[i], 'S');

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (k == 0) {
                    fw.out.println("YES");
                    printGrid(result, n);
                    return;
                }
                if ((i & 1) == (j & 1)) {
                    result[i][j] = 'L';
                    k--;
                }
            }
        }

        fw.out.println("YES");
        printGrid(result, n);
    }

    private static void printGrid(char[][] grid, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fw.out.print(grid[i][j]);
            }
            fw.out.println();
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