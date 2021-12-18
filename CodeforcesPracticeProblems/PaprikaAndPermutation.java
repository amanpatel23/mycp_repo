import java.io.*;
import java.util.*;

public class PaprikaAndPermutation {

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
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = fs.nextInt();
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Set<Integer> _set = new HashSet<>();
        List<Integer> nums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> x: freq.entrySet()) {
            int k = x.getKey(), v = x.getValue();
            if (k <= n) {
                _set.add(k);
                v--;
            }
            for (int i = 0; i < v; i++)
                nums.add(k);
        }

        Collections.sort(nums);
        int result = 0;
        int num = 1;
        for (int curr : nums) {
            while (_set.contains(num))
                num++;

            int div = curr / 2;
            if ((curr & 1) == 0)
                div--;
            if (div < num) {
                fw.out.println(-1);
                return;
            }

            result++;
            num++;
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