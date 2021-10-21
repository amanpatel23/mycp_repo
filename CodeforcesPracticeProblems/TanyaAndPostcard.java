import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class TanyaAndPostcard {

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

        String s = fs.nextLine(), t = fs.nextLine();
        int n1 = s.length(), n2 = t.length();

        HashMap<Character, Integer> sFreq = new HashMap<>();
        HashMap<Character, Integer> tFreq = new HashMap<>();

        for (int i = 0; i < n1; i++) {
            char _char = s.charAt(i);
            sFreq.put(_char, sFreq.getOrDefault(_char, 0) + 1);
        }

        for (int i = 0; i < n2; i++) {
            char _char = t.charAt(i);
            tFreq.put(_char, tFreq.getOrDefault(_char, 0) + 1);
        }

        int yay = 0, whoop = 0;
        for (Map.Entry<Character, Integer> x : sFreq.entrySet()) {
            char k = x.getKey();
            int v = x.getValue();
            int v2 = tFreq.getOrDefault(k, 0);
            int min = Math.min(v, v2);
            yay += min;

            sFreq.put(k, v - min);
            tFreq.put(k, v2 - min);
        }

        for (Map.Entry<Character, Integer> x: sFreq.entrySet()) {
            char k = x.getKey();
            int v = x.getValue();
            char ch = (Character.isLowerCase(k)) ? Character.toUpperCase(k) : Character.toLowerCase(k);
            int v2 = tFreq.getOrDefault(ch, 0);
            int min = Math.min(v, v2);
            whoop += min;
        }

        fw.out.println(yay + " " + whoop);
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
