import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Connect {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);
    private static final int iMax = (int) (1e9);

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

        int n = fs.nextInt();
        Pair st = new Pair(fs.nextInt() - 1, fs.nextInt() - 1);
        Pair finish = new Pair(fs.nextInt() - 1, fs.nextInt() - 1);

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = fs.next().toCharArray();
        }

        ArrayList<Pair> coord1 = new ArrayList<>();
        ArrayList<Pair> coord2 = new ArrayList<>();
        coord1.add(st);
        coord2.add(finish);
        util(n, matrix, st.a, st.b, coord1);
        util(n, matrix, finish.a, finish.b, coord2);

        int result = iMax;
        for (Pair x : coord1) {
            for (Pair y : coord2) {
                int ff = (x.a - y.a), ss = (x.b - y.b);
                int curr = (ff * ff) + (ss * ss);
                result = Math.min(result, curr);
            }
        }

        fw.out.println(result);
    }

    private static void util(int n, char[][] matrix, int i, int j, ArrayList<Pair> coord) {

        if (i < 0 || i >= n || j < 0 || j >= n)
            return;
        if (matrix[i][j] == '1')
            return;

        matrix[i][j] = '1';
        coord.add(new Pair(i, j));
        util(n, matrix, i - 1, j, coord);
        util(n, matrix, i + 1, j, coord);
        util(n, matrix, i, j - 1, coord);
        util(n, matrix, i, j + 1, coord);
    }

    static class Pair {
        int a, b;

        Pair(int _a, int _b) {
            this.a = _a;
            this.b = _b;
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
