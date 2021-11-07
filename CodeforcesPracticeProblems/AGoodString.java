import java.io.*;
import java.util.StringTokenizer;

public class AGoodString {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static String str;

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

        int n = fs.nextInt();
        str = fs.nextLine();

        int result = minMoves(n, 0, n - 1, 'a');
        fw.out.println(result);
    }

    private static int minMoves(int len, int left, int right, char _char) {

        //fw.out.println(len + " " + left + " " + right + " " + _char);
        if (len == 1) {
            return cost(left, right, _char);
        }

        len /= 2;
        int mid = left + len;
        char nextChar = (char) (_char + 1);
        //fw.out.println(nextChar);
        return Math.min(cost(left, mid - 1, _char) + minMoves(len, mid, right, nextChar),
                cost(mid, right, _char) + minMoves(len, left, mid - 1, nextChar));
    }

    private static int cost(int left, int right, char _char) {

        int len = right - left + 1;
        int cnt = 0;
        for (int i = left; i <= right; i++) {
            if (str.charAt(i) == _char)
                cnt++;
        }

        return (len - cnt);
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
