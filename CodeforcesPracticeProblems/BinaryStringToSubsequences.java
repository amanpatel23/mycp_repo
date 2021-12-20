import java.io.*;
import java.util.*;

public class BinaryStringToSubsequences {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

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
        String str = fs.nextLine();

        int _max = 0;
        Queue<Integer> zero = new LinkedList<>(), one = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '0') {
                if (one.isEmpty()) {
                    _max++;
                    zero.offer(_max);
                    result.append(_max).append(" ");
                } else {
                    int top = one.poll();
                    zero.offer(top);
                    result.append(top).append(" ");
                }
            } else {
                if (zero.isEmpty()) {
                    _max++;
                    one.offer(_max);
                    result.append(_max).append(" ");
                } else {
                    int top = zero.poll();
                    one.offer(top);
                    result.append(top).append(" ");
                }
            }
        }

        fw.out.println(_max);
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
