import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class KefaAndCompany {

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

        int n = fs.nextInt(), d = fs.nextInt();
        List<Pair> friends = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            friends.add(new Pair(fs.nextInt(), fs.nextInt()));
        }

        Comparator<Pair> myComp = Comparator.comparingInt(o -> o.x);
        friends.sort(myComp);

        long[] prefixSum = new long[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = (i == 0 ? 0 : prefixSum[i - 1]) + friends.get(i).y;
        }

        long result = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = i;
            while (r - l > 1) {
                int mid = l + ((r - l) / 2);
                if (friends.get(i).x - friends.get(mid).x < d)
                    r = mid;
                else
                    l = mid;
            }

            int idx = ((friends.get(i).x - friends.get(l).x) < d ? l : r);
            result = Math.max(result, prefixSum[i] - (idx == 0 ? 0 : prefixSum[idx - 1]));
        }

        fw.out.println(result);
    }

    private static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
