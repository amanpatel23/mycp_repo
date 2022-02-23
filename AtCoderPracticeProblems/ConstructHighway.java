import java.io.*;
import java.util.*;

public class Main {

    static FastScanner fs;
    static FastWriter fw;
    static boolean checkOnlineJudge = /* System.getProperty("ONLINE_JUDGE") == null; */ false;

    private static final int[][] kdir = new int[][]{{-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};
    private static final int[][] dir = new int[][]{{-1, 0}, {1, 0}, {1, 0}, {-1, 0}};
    private static final int iMax = (int) (1e9 + 100), iMin = (int) (-1e9 - 100);
    private static final long lMax = (long) (1e18 + 100), lMin = (long) (-1e18 - 100);
    private static final int mod1 = (int) (1e9 + 7);
    private static final int mod2 = 998244353;

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
        int[] req = new int[n];
        for (int i = 0; i < n; i++)
            req[i] = fs.nextInt();
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int a = fs.nextInt() - 1, b = fs.nextInt() - 1;
            uf.union(a, b);
            req[a]--;
            req[b]--;
        }

        List<List<Integer>> components = new ArrayList<>();
        for (int i = 0; i < n; i++)
            components.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (req[i] < 0) {
                fw.out.println(-1);
                return;
            }
            int parent = uf.find(i);
            for (int j = 0; j < req[i]; j++)
                components.get(parent).add(i);
        }

        Queue<Integer> c1 = new LinkedList<>();
        List<List<Integer>> c2 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (components.get(i).size() == 1)
                c1.offer(components.get(i).get(0));
            else if (components.get(i).size() > 1)
                c2.add(components.get(i));
        }

        List<Pair<Integer, Integer>> result = new ArrayList<>();
        for (List<Integer> x : c2) {
            for (int i = 0; i < x.size() - 1; i++) {
                if (c1.size() == 0) {
                    fw.out.println(-1);
                    return;
                }
                int front = c1.poll();
                uf.union(x.get(i), front);
                result.add(new Pair<>(x.get(i) + 1, front + 1));
            }
            c1.offer(x.get(x.size() - 1));
        }

        if (c1.size() != 2) {
            fw.out.println(-1);
            return;
        }

        int a = c1.poll(), b = c1.poll();
        uf.union(a, b);
        result.add(new Pair<>(a + 1, b + 1));
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++)
            set.add(uf.find(i));
        if (set.size() > 1) {
            fw.out.println(-1);
            return;
        }

        for (Pair<Integer, Integer> x : result)
            fw.out.println(x);
    }

    private static class UnionFind {

        private final int[] parent;
        private final int[] rank;

        UnionFind(int n) {
            parent = new int[n + 5];
            rank = new int[n + 5];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        private int find(int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent[i]);
        }

        private void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b) {
                if (rank[a] < rank[b]) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                parent[b] = a;
                if (rank[a] == rank[b])
                    rank[a]++;
            }
        }
    }

    private static int gcd(int a, int b) {
        return (b == 0 ? a : gcd(b, a % b));
    }

    private static long pow(long a, long b, int mod) {
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

    private static long ceilDiv(long a, long b) {
        return ((a + b - 1) / b);
    }

    private static long getMin(long... args) {
        long min = lMax;
        for (long arg : args)
            min = Math.min(min, arg);
        return min;
    }

    private static long getMax(long... args) {
        long max = lMin;
        for (long arg : args)
            max = Math.max(max, arg);
        return max;
    }

    private static boolean isPalindrome(String s, int l, int r) {

        int i = l, j = r;
        while (j - i >= 1) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
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
            return first + " " + second;
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
