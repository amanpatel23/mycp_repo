import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class YuhaoAndAParenthesis {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);
    private static final int N = (int) (5e5);

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

        int n = fs.nextInt();
        int[] openings = new int[N + 5];
        int[] closings = new int[N + 5];
        int zeroes = 0;
        Arrays.fill(openings, 0);
        Arrays.fill(closings, 0);

        for (int i = 0; i < n; i++) {
            String str = fs.nextLine();
            int ope = 0, clo = 0, pusdoOpe = 0;
            boolean opeReq = false, cloReq = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    ope++;
                    continue;
                }

                if ((ope + pusdoOpe) == clo) {
                    pusdoOpe++;
                    opeReq = true;
                }

                clo++;
            }

            if ((ope + pusdoOpe) > clo) {
                cloReq = true;
            }

            if (opeReq && cloReq)
                continue;
            if (opeReq) {
                openings[clo - ope]++;
                continue;
            }
            if (cloReq) {
                closings[ope - clo]++;
                continue;
            }

            zeroes++;
        }

        int result = 0;
        result += (zeroes / 2);
        for (int i = 1; i <= N; i++) {
            int _min = Math.min(openings[i], closings[i]);
            result += _min;
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
