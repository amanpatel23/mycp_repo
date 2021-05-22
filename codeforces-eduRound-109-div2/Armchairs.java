/* 
    Author: Aman Patel
    Date: 16-05-2021
*/


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ed109 {

    static int N = 5000;
    static long[][] dp_arr = new long[N + 5][N + 5];

    //static int _count = 0;
    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                dp_arr[i][j] = -1;
            }
        }

        int n;
        n = fs.nextInt();

        ArrayList<Integer> occupied = new ArrayList<>(), empty = new ArrayList<>();
        int temp;
        for (int i = 0; i < n; i++) {
            temp = fs.nextInt();
            if (temp == 1)
                occupied.add(i);
            else
                empty.add(i);
        }

        int n1 = occupied.size(), n2 = empty.size();
        long result = cost(occupied, empty, n1, n2, 0, 0);

        out.println(result);
        //out.println(_count);
        out.close();
    }

    static long cost(ArrayList<Integer> occupied, ArrayList<Integer> empty, int n1, int n2, int i, int j) {
        //_count++;
        if (i == n1)
            return 0;
        else if (j == n2)
            return (long) (1e15);

        if (dp_arr[i][j] != -1)
            return dp_arr[i][j];

        long _min = Math.min(Math.abs(occupied.get(i) - empty.get(j)) + cost(occupied, empty, n1, n2, i + 1, j + 1), cost(occupied, empty, n1, n2, i, j + 1));
        dp_arr[i][j] = _min;
        return dp_arr[i][j];
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreElements())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Long nextLong() {
            return Long.parseLong(next());
        }
    }

    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}
