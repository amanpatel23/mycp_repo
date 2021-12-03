import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CFEdu118 {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static int n;
    private static long h;
    private static int[] seconds;

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

        int x1 = fs.nextInt(), p1 = fs.nextInt();
        int x2 = fs.nextInt(), p2 = fs.nextInt();

        while (true) {
            int digit = x1 % 10;
            if (digit == 0) {
                x1 /= 10;
                p1++;
            } else
                break;
        }

        while (true) {
            int digit = x2 % 10;
            if (digit == 0) {
                x2 /= 10;
                p2++;
            } else
                break;
        }

        if (x1 == x2 && p1 == p2) {
            fw.out.println("=");
            return;
        }

        int d_places1 = p1, d_places2 = p2;
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        while (x1 != 0) {
            list1.add(x1 % 10);
            d_places1++;
            x1 /= 10;
        }

        while (x2 != 0) {
            list2.add(x2 % 10);
            d_places2++;
            x2 /= 10;
        }

        if (d_places1 > d_places2) {
            fw.out.println(">");
            return;
        }

        if (d_places1 < d_places2) {
            fw.out.println("<");
            return;
        }

        Collections.reverse(list1);
        Collections.reverse(list2);
        int len1 = list1.size(), len2 = list2.size();
        for (int i = 0; i < Math.min(len1, len2); i++) {
            if (list1.get(i) > list2.get(i)) {
                fw.out.println(">");
                return;
            }
            if (list1.get(i) < list2.get(i)) {
                fw.out.println("<");
                return;
            }
        }

        if (len1 > len2) {
            fw.out.println(">");
            return;
        }

        fw.out.println("<");
    }

    private static boolean _check(long k) {
        long _count = 0;
        for (int i = 0; i < (n - 1); i++) {
            long r_limit = Math.min(seconds[i] + k, seconds[i + 1]);
            _count += (r_limit - seconds[i]);
        }

        long r_limit = seconds[n - 1] + k;
        _count += (r_limit - seconds[n - 1]);

        //fw.out.println("count: " + _count);
        return (_count >= h);
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
