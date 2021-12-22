import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinaryStringReconstruction {

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

        char[] arr = fs.nextLine().toCharArray();
        int x = fs.nextInt();

        int n = arr.length;
        char[] result = new char[n];
        Arrays.fill(result, '2');

        for (int i = 0; i < n; i++) {
            if (arr[i] == '1') {
                if (i - x >= 0) {
                    if (result[i - x] == '1')
                        continue;
                    if (result[i - x] == '2') {
                        result[i - x] = '1';
                        continue;
                    }
                }

                if (i + x < n) {
                    if (result[i + x] == '1')
                        continue;
                    if (result[i + x] == '2') {
                        result[i + x] = '1';
                        continue;
                    }
                }

                fw.out.println(-1);
                return;
            } else {
                if ((i - x >= 0 && result[i - x] == '1') || (i + x < n && result[i + x] == '1')) {
                    fw.out.println(-1);
                    return;
                }

                if (i - x >= 0)
                    result[i - x] = '0';
                if (i + x < n)
                    result[i + x] = '0';
            }
        }

        for (int i = 0; i < n; i++)
            fw.out.print(result[i] == '0' ? '0' : '1');
        fw.out.println();
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
