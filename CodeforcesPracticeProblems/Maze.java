import java.io.*;
import java.util.StringTokenizer;

public class Maze {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, 1, -1};
    private static final int mod = (int) (1e9 + 7);

    private static int n, m, k, s, walls;
    private static char[][] maze;
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

        n = fs.nextInt();
        m = fs.nextInt();
        k = fs.nextInt();

        maze = new char[n][m];
        for (int i = 0; i < n; i++) {
            maze[i] = fs.nextLine().toCharArray();
        }

        s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == '.') {
                    s++;
                    maze[i][j] = 'X';
                }
            }
        }

        walls = s - k;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i, j)) {
                    printMaze();
                    return;
                }
            }
        }
    }

    private static boolean dfs(int i, int j) {

        if (i >= n || i < 0 || j >= m || j < 0 || maze[i][j] == '#' || maze[i][j] == '.')
            return false;

        maze[i][j] = '.';
        walls--;
        if (walls == 0)
            return true;

        for (int idx = 0; idx < 4; idx++) {
            if (dfs(i + dr[idx], j + dc[idx]))
                return true;
        }

        return false;
    }

    private static void printMaze() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                fw.out.print(maze[i][j]);
            fw.out.println();
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
