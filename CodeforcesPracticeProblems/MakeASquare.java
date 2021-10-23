import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class MakeASquare {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    static Set<Long> squares = new HashSet<>();

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

        long n = fs.nextLong();
        long i = 1;
        while ((i * i) <= n) {
            squares.add((i * i));
            i++;
        }

        String str = Long.toString(n);
        int len = str.length();

        int result = util(str, len, 0, "");
        if (result < 0) {
            fw.out.println(-1);
            return;
        }

        fw.out.println((len - result));
    }

    private static int util(String str, int len, int i, String curr) {

        if (i >= len) {
            if (curr.equals(""))
                return -100;

            long currNum = Long.parseLong(curr);
            //fw.out.println(currNum);
            if (squares.contains(currNum)) {
                int noOfDigits = 0;
                long x = currNum;
                while (x > 0) {
                    x /= 10;
                    noOfDigits++;
                }

                return noOfDigits;
            }

            return -100;
        }

        return Math.max(util(str, len, i + 1, curr), util(str, len, i + 1, (curr + str.charAt(i))));
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
