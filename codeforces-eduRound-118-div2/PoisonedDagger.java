import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CFEdu118 {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static int n;
    private static long h;
    private static int[] seconds;

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

        n = fs.nextInt();
        h = fs.nextLong();

        seconds = new int[n];
        for (int i = 0; i < n; i++)
            seconds[i] = fs.nextInt();

        long l = 0, r = h;
        while (r - l > 1) {
            long mid = l + ((r - l) / 2);
            //fw.out.println(l + " " + r + " " + mid);
            if (_check(mid))
                r = mid;
            else
                l = mid;
        }

        long result = (_check(l) ? l : r);
        fw.out.println(result);
    }

    private static boolean _check(long k) {
        long _count = 0;
        for (int i = 0; i < (n - 1); i++) {
            long r_limit = Math.min(seconds[i] + k, seconds[i + 1]);
            _count += (r_limit - seconds[i]);
        }

        long r_limit = seconds[n - 1] + k;
        _count += (r_limit - seconds[n - 1]);

        //fw.out.println("count: " + _count);
        return (_count >= h);
    }

    private static int[] readIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = fs.nextInt();
        return arr;
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
