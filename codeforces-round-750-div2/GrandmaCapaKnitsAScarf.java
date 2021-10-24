import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class CF750 {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);
    private static final int iMax = (int) (1e9);

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
        String s = fs.nextLine();

        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < n; i++)
            charSet.add(s.charAt(i));

        int result = iMax;
        for (char curr : charSet) {
            int currResult = util(s, n, curr);
            result = Math.min(result, currResult);
        }

        fw.out.println((result >= iMax) ? -1 : result);
    }

    private static int util(String s, int n, char curr) {

        int i = 0, j = n - 1;
        int deleted = 0;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }

            if (s.charAt(i) == curr) {
                i++;
                deleted++;
                continue;
            }

            if (s.charAt(j) == curr) {
                j--;
                deleted++;
                continue;
            }

            return iMax;
        }

        return deleted;
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
