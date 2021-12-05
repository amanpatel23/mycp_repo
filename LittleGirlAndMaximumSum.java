import java.io.*;
import java.util.*;

public class LittleGirlAndMaximumSum {

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

        int n = fs.nextInt(), q = fs.nextInt();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(fs.nextInt());
        }

        int[] queryRange = new int[n + 5];
        for (int i = 0; i < q; i++) {
            int a = fs.nextInt(), b = fs.nextInt();
            queryRange[a]++;
            queryRange[b + 1]--;
        }

        for (int i = 1; i <= (n + 1); i++) {
            queryRange[i] += queryRange[i - 1];
        }

        List<Integer> times = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            times.add(queryRange[i]);
        times.sort(Collections.reverseOrder());
        nums.sort(Collections.reverseOrder());

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += ((long) nums.get(i) * times.get(i));
        }

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
