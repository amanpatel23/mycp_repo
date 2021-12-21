import java.io.*;
import java.util.*;

public class ConstructingTheArray {

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
        int[] result = new int[n];
        Comparator<Triple> myComp = (o1, o2) -> ((o1.z == o2.z) ? (o1.x - o2.x) : (o2.z - o1.z));
        Queue<Triple> pq = new PriorityQueue<>(myComp);
        pq.add(new Triple(0, n - 1, n));
        int action = 1;
        while (!pq.isEmpty()) {
            Triple top = pq.poll();
            int l = top.x, r = top.y;
            int mid = (l + r) / 2;
            result[mid] = action;
            action++;

            if ((mid - 1) >= l) {
                int len = mid - l;
                pq.add(new Triple(l, mid - 1, len));
            }

            if ((mid + 1) <= r) {
                int len = r - mid;
                pq.add(new Triple(mid + 1, r, len));
            }
        }

        for (int i = 0; i < n; i++)
            fw.out.print(result[i] + " ");
        fw.out.println();
    }

    private static class Triple {
        int x, y, z;

        Triple(int _x, int _y, int _z) {
            this.x = _x;
            this.y = _y;
            this.z = _z;
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
