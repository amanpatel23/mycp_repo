import java.io.*;
import java.util.StringTokenizer;

public class VupsenPupsenAnd0 {

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
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = fs.nextInt();
        int[] b = new int[n];

        if ((n & 1) == 1) {
            for (int i = 0; i < 2; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (a[i] + a[j] == 0)
                        continue;

                    int k = 0;
                    while (i == k || j == k) {
                        k++;
                    }

                    b[i] = a[k];
                    b[j] = a[k];
                    b[k] = -(a[i] + a[j]);
                    util(a, n, 3, b);
                    printArr(b, n);
                    return;
                }
            }
        }


        util(a, n, 0, b);
        printArr(b, n);
    }

    private static void util(int[] a, int n, int st, int[] b) {

        for (int i = st; i < n; i += 2) {
            b[i] = -a[i + 1];
            b[i + 1] = a[i];
        }
    }

    private static void printArr(int[] b, int n) {
        for (int i = 0; i < n; i++)
            fw.out.print(b[i] + " ");
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
