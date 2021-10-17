import java.io.*;
import java.util.*;

public class OptimalPointOnALine {

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
        ArrayList<Pair> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(new Pair(fs.nextInt(), i));
        }

        Collections.sort(nums, Comparator.comparingInt(o -> o.a));

        if ((n & 1) == 1) {
            fw.out.println(nums.get(n / 2).a);
        } else {
            int idx1 = (n / 2) - 1;
            long dist1 = distSum(nums, nums.get(idx1).a);

            int idx2 = idx1 + 1;
            long dist2 = distSum(nums, nums.get(idx2).a);

            if (dist1 <= dist2) {
                fw.out.println(nums.get(idx1).a);
            } else {
                fw.out.println(nums.get(idx2).a);
            }
        }
    }

    private static long distSum(ArrayList<Pair> nums, int ele) {
        long sum = 0;
        for (Pair x : nums)
            sum += Math.abs(ele - x.a);
        return sum;
    }

    static class Pair {
        int a, b;

        Pair(int _a, int _b) {
            this.a = _a;
            this.b = _b;
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
