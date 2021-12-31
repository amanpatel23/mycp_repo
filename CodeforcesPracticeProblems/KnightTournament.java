import java.io.*;
import java.util.*;

public class KnightTournament {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int iMax = (int) (1e9), iMin = (int) (-1e9);
    private static final long lMax = (int) (1e15), lMin = (int) (-1e15);
    private static final int mod = (int) (1e9 + 7);

    private static boolean[] st;
    private static int[] result;

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

    private static void solve() {

        int n = fs.nextInt(), m = fs.nextInt();
        st = new boolean[(4 * n) + 5];
        Arrays.fill(st, false);

        result = new int[n + 5];
        Arrays.fill(result, 0);

        while (m-- > 0) {
            int l = fs.nextInt(), r = fs.nextInt(), x = fs.nextInt();
            update(1, 1, n, l, r, x);
        }

        for (int i = 1; i <= n; i++)
            fw.out.print(result[i] + " ");
        fw.out.println();
    }

    private static boolean update(int si, int ss, int se, int qs, int qe, int x) {

        if (qs > se || qe < ss || st[si])
            return st[si];

        if (ss == se) {
            if (ss == x)
                return false;
            else {
                st[si] = true;
                result[ss] = x;
                return true;
            }
        }

        int mid = (ss + se) / 2;
        boolean l = update((2 * si), ss, mid, qs, qe, x);
        boolean r = update((2 * si) + 1, mid + 1, se, qs, qe, x);

        st[si] = l && r;
        return st[si];
    }

    private static class UnionFind {

        private final int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        private int getParent(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = getParent(parent[i]);
        }

        private void unify(int i, int j) {
            int p1 = getParent(i);
            int p2 = getParent(j);
            if (p1 != p2)
                parent[p1] = p2;
        }
    }

    private static int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }

    private static long pow(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1L) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }

        return result;
    }

    private static int ceilDiv(int a, int b) {
        return ((a + b - 1) / b);
    }

    private static List<Integer> primes(int n) {

        boolean[] primeArr = new boolean[n + 5];
        Arrays.fill(primeArr, true);
        for (int i = 2; (i * i) <= n; i++) {
            if (primeArr[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primeArr[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (primeArr[i])
                primeList.add(i);
        }

        return primeList;
    }

    private static class Pair<U, V> {

        private final U first;
        private final V second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return first.equals(pair.first) && second.equals(pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }

        private Pair(U ff, V ss) {
            this.first = ff;
            this.second = ss;
        }
    }

    private static <T> void randomizeArr(T[] arr, int n) {
        Random r = new Random();
        for (int i = (n - 1); i > 0; i--) {
            int j = r.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    private static Integer[] readIntArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = fs.nextInt();
        return arr;
    }

    private static List<Integer> readIntList(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(fs.nextInt());
        return list;
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static <T> void displayArr(T[] arr) {
        for (T x : arr)
            fw.out.print(x + " ");
        fw.out.println();
    }

    private static <T> void displayList(List<T> list) {
        for (T x : list)
            fw.out.print(x + " ");
        fw.out.println();
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
