import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = /* System.getProperty("ONLINE_JUDGE") == null; */ false;

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
        int[] arr = new int[3];
        Arrays.fill(arr, 0);
        for (int i = 0; i < n; i++)
            arr[fs.nextInt() % 3]++;
        int sum = arr[1] + (2 * arr[2]);
        if (sum % 3 != 0) {
            fw.out.println(-1);
            return;
        }

        int _min = Math.min(arr[1], arr[2]);
        int cost = _min;
        cost += (2 * (((arr[1] - _min) / 3) + ((arr[2] - _min) / 3)));
        fw.out.println(cost);
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
