/* 
    Author: Aman Patel
    Date: 08-06-2021
*/


import java.io.*;
import java.util.*;

public class OmkarAndBadStory {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {

            int n;
            n = fs.nextInt();

            boolean flag = false;
            HashSet<Integer> numsSet = new HashSet<>();
            List<Integer> nums = new ArrayList<>();
            int temp;
            for (int i = 0; i < n; i++) {
                temp = fs.nextInt();
                if (temp < 0)
                    flag = true;
                numsSet.add(temp);
                nums.add(temp);
            }

            if (flag)
                out.println("NO");
            else {
                for (int i = 0; i < nums.size(); i++) {
                    for (int j = 0; j < nums.size(); j++) {
                        if(i == j)
                            continue;
                        temp = Math.abs(nums.get(i) - nums.get(j));
                        if (numsSet.contains(temp))
                            continue;

                        numsSet.add(temp);
                        nums.add(temp);
                    }
                }

                out.println("YES");
                out.println(numsSet.size());
                for (Integer integer : numsSet) out.print(integer + " ");
                out.println();
            }
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
