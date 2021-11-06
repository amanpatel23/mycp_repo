import java.io.*;
import java.util.*;

public class LinovaAndKingdom {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int mod = (int) (1e9 + 7);

    private static List<ArrayList<Integer>> adjList;
    private static List<Integer> scores;
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

        int n = fs.nextInt(), k = fs.nextInt();
        adjList = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for (int i = 0; i < (n - 1); i++) {
            int a = fs.nextInt() - 1, b = fs.nextInt() - 1;
            addEdge(a, b);
        }

        scores = new ArrayList<>();
        dfs(0, -1, 0);

        Collections.sort(scores, (o1, o2) -> (o2 - o1));
        long result = 0;
        for (int i = 0; i < k; i++)
            result += scores.get(i);
        fw.out.println(result);
    }

    private static int dfs(int curr, int parent, int level) {

        int subtreeSize = 0;
        for (int x: adjList.get(curr)) {
            if (x == parent)
                continue;
            subtreeSize += (1 + dfs(x, curr, level + 1));
        }

        int score = level - subtreeSize;
        scores.add(score);

        return subtreeSize;
    }

    private static void addEdge(int a, int b) {
        adjList.get(a).add(b);
        adjList.get(b).add(a);
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
