/* 
    Author: Aman Patel
    Date: 21-05-2021
*/


import java.io.*;
import java.util.*;

public class CF721_3 {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();
            int[] nums;
            nums = fs.readArray(n);

            Map<Integer, List<Integer>> indexes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexes.computeIfAbsent(nums[i], k -> new ArrayList<>());
                indexes.get(nums[i]).add(i + 1);
            }

            long result = 0;
            Iterator<Map.Entry<Integer, List<Integer>>> it = indexes.entrySet().iterator();
            while (it.hasNext()) {
                List<Integer> temp = it.next().getValue();
                int len = temp.size();
                if (len == 1)
                    continue;
                long[] prefix = new long[len + 1];
                prefix[len] = 0;
                for (int i = len - 1; i >= 0; i--) {
                    prefix[i] = prefix[i + 1] + (n - temp.get(i) + 1);
                }

                for (int i = 0; i < len - 1; i++) {
                    result += (temp.get(i) * prefix[i + 1]);
                }
            }

            out.println(result);
        }

        out.close();
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
