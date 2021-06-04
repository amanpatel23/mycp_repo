/* 
    Author: Aman Patel
    Date: 25-05-2021
*/


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF722_2 {

    static int[] nums;

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();

            nums = fs.readArray(n);
            Arrays.sort(nums);

            int l = 0, r = n - 1;
            while (r - l > 1) {
                int m = (l + r) / 2;
                if (check(m))
                    l = m;
                else
                    r = m;
            }

            if (check(r))
                out.println(r + 1);
            else
                out.println(l + 1);
        }

        out.close();
    }

    static boolean check(int mid) {

        int _min = Integer.MAX_VALUE;
        for (int i = 1; i <= mid; i++) {
            _min = Math.min(_min, Math.abs(nums[i - 1] - nums[i]));
            if (_min < nums[i])
                return false;
        }
        return true;
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
