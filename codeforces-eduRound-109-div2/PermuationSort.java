/* 
    Author: Aman Patel
    Date: 16-05-2021
*/


import java.io.*;
import java.util.StringTokenizer;

public class Ed109 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {

            int n;
            n = fs.nextInt();

            int[] nums = fs.readArray(n);
            int result = 0;
            if (isAscending(nums, n))
                result = 0;
            else if (nums[0] == 1 && nums[n - 1] == n)
                result = 1;
            else if (nums[0] == n && nums[n - 1] == 1)
                result = 3;
            else if(nums[0] == 1 || nums[n - 1] == n)
                result = 1;
            else
                result = 2;

            out.println(result);
        }

        out.close();
    }

    static boolean isAscending(int[] nums, int n) {
        int prev = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < prev)
                return false;

            prev = nums[i];
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
