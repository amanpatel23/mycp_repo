import java.io.*;
import java.util.StringTokenizer;

public class Towers {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);
    private static final int iMax = (int) (1e9);
    private static final int iMin = (int) (-1e9);

    private static int n, k;
    private static int[] heights;

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

        n = fs.nextInt();
        k = fs.nextInt();
        heights = readIntArray(n);

        int operations = 0;
        StringBuilder desc = new StringBuilder();
        while (operations < k) {
            int minIdx = getMinIdx();
            int maxIdx = getMaxIdx();
            if (heights[minIdx] == heights[maxIdx])
                break;

            desc.append(maxIdx + 1).append(" ").append(minIdx + 1).append("\n");
            heights[minIdx]++;
            heights[maxIdx]--;
            operations++;
        }

        int stability = heights[getMaxIdx()] - heights[getMinIdx()];
        fw.out.println(stability + " " + operations);
        fw.out.print(desc);
    }

    private static int getMinIdx() {

        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (heights[i] < heights[idx])
                idx = i;
        }
        return idx;
    }

    private static int getMaxIdx() {

        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (heights[i] > heights[idx])
                idx = i;
        }
        return idx;
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
