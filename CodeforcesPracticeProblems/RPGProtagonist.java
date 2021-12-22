import java.io.*;
import java.util.*;

public class RPGProtagonist {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = System.getProperty("ONLINE_JUDGE") == null;

    private static final int iMax = (int) (1e9), iMin = (int) (-1e9);
    private static final long lMax = (int) (1e15), lMin = (int) (-1e15);
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

    private static void solve() {

        long p = fs.nextInt(), f = fs.nextInt();
        Long[] counts = {fs.nextLong(), fs.nextLong()};
        Long[] sizes = {fs.nextLong(), fs.nextLong()};
        if (sizes[1] < sizes[0]) {
            swap(counts, 0, 1);
            swap(sizes, 0, 1);
        }

        long global = 0;
        long x = Math.min(counts[0], p / sizes[0]);
        while (x >= 0) {
            long y = Math.min(counts[1], (p - (sizes[0] * x)) / sizes[1]);
            long left_1 = counts[0] - x;
            long left_2 = counts[1] - y;
            long _x = Math.min(left_1, f / sizes[0]);
            long _y = Math.min(left_2, (f - (sizes[0] * _x)) / sizes[1]);

            global = Math.max(global, x + y + _x + _y);
            x--;
        }

        x = Math.min(counts[0], f / sizes[0]);
        while (x >= 0) {
            long y = Math.min(counts[1], (f - (sizes[0] * x)) / sizes[1]);
            long left_1 = counts[0] - x;
            long left_2 = counts[1] - y;
            long _x = Math.min(left_1, p / sizes[0]);
            long _y = Math.min(left_2, (p - (sizes[0] * _x)) / sizes[1]);

            global = Math.max(global, x + y + _x + _y);
            x--;
        }

        fw.out.println(global);
    }

    private static class UnionFind {

        private final int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        private int getAbsoluteParent(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = getAbsoluteParent(parent[i]);
        }

        private void unify(int i, int j) {
            int p1 = getAbsoluteParent(i);
            int p2 = getAbsoluteParent(j);
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

        boolean[] primeArr = new boolean[n + 1];
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

    private static <T> void displayP(T x) {
        fw.out.println(x);
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
