/* 
    Author: Aman Patel
    Date: 10-06-2021
*/


import java.io.*;
import java.util.*;

public class CF725_DIV3 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();
        while (t-- > 0) {

            int n, l, r;
            n = fs.nextInt();
            l = fs.nextInt();
            r = fs.nextInt();

            List<Integer> nums = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                int temp = fs.nextInt();
                nums.add(temp);
            }
            Collections.sort(nums);
            long result = 0;
            for (int i = 0; i < n - 1; i++) {
                int ele = nums.get(i);
                int leftIdx = -1, rightIdx = -1;

                // to find leftIdx
                int lIdx = i + 1, rIdx = n - 1;
                while (rIdx - lIdx > 1) {
                    int m = (lIdx + rIdx) / 2;
                    if (ele + nums.get(m) >= l) {
                        rIdx = m;
                    } else {
                        lIdx = m;
                    }
                }

                if (ele + nums.get(lIdx) >= l)
                    leftIdx = lIdx;
                else if (ele + nums.get(rIdx) >= l)
                    leftIdx = rIdx;

                // to find rightIdx
                lIdx = i + 1;
                rIdx = n - 1;
                while (rIdx - lIdx > 1) {
                    int m = (lIdx + rIdx) / 2;
                    if (ele + nums.get(m) <= r) {
                        lIdx = m;
                    } else {
                        rIdx = m;
                    }
                }

                if (ele + nums.get(rIdx) <= r)
                    rightIdx = rIdx;
                else if (ele + nums.get(lIdx) <= r)
                    rightIdx = lIdx;

                if (leftIdx == -1 || rightIdx == -1)
                    continue;

                result += (rightIdx - leftIdx + 1);
            }

            out.println(result);

        }

        out.close();
    }

    static class Pair {
        int l, r;

        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static boolean check(int n, long sum) {
        return Math.ceil(sum / (n * 1.)) == Math.floor(sum / (n * 1.));
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
