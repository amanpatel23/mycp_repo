import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RestoringPainting {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);
    private static final int iMax = (int) (1e9);
    private static final int iMin = (int) (-1e9);

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
        int a = fs.nextInt(), b = fs.nextInt(), c = fs.nextInt(), d = fs.nextInt();

        int _max = iMin, _min = iMax;
        int sum1 = a + b;
        int sum2 = a + c;
        int sum3 = b + d;
        int sum4 = c + d;
        List<Integer> list = Arrays.asList(sum1, sum2, sum3, sum4);
        for (int i = 0; i < 4; i++) {
            _max = Math.max(_max, list.get(i));
            _min = Math.min(_min, list.get(i));
        }

        int diff = _max - _min;
        long result = (long) n * Math.max(0, n - diff);
        fw.out.println(result);
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
