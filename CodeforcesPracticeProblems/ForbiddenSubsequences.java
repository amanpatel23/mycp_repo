import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ForbiddenSubsequences {

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

        String s = fs.nextLine(), t = fs.nextLine();
        int n = s.length();
        int[] freq = new int[26];
        Arrays.fill(freq, 0);
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        //fw.out.println(freq[0]);
        StringBuilder result = new StringBuilder();
        result.append("a".repeat(Math.max(0, freq[0])));
        if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0 && t.equals("abc")) {
            result.append("c".repeat(freq[2]));
            result.append("b".repeat(freq[1]));
        } else {
            result.append("b".repeat(Math.max(0, freq[1])));
            result.append("c".repeat(Math.max(0, freq[2])));
        }

        for (int i = 3; i < 26; i++) {
            result.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, freq[i])));
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
