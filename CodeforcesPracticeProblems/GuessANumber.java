import java.io.*;
import java.util.StringTokenizer;

public class GuessANumber {

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

        int n = fs.nextInt();
        int a = (int) (-2e9), b = (int) (2e9);
        while (n-- > 0) {
            String ineq = fs.next();
            int x = fs.nextInt();
            char resp = fs.next().charAt(0);
            if (resp == 'N') {
                switch (ineq) {
                    case ">=": ineq = "<";
                    break;
                    case ">": ineq = "<=";
                    break;
                    case "<=": ineq = ">";
                    break;
                    default: ineq = ">=";
                }
            }

            if (ineq.length() == 1) {
                if (ineq.equals(">")) {
                    ineq = ">=";
                    x++;
                } else {
                    ineq = "<=";
                    x--;
                }
            }

            if (ineq.equals(">=")) {
                a = Math.max(a, x);
            } else {
                b = Math.min(b, x);
            }

            //fw.out.println(ineq + " " + a + " " + b);
        }

        if (b >= a) {
            fw.out.println(a);
        } else {
            fw.out.println("Impossible");
        }
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
