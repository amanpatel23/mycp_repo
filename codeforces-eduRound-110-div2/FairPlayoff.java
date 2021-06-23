/* 
    Author: Aman Patel
    Date: 04-06-2021
*/


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FairPlayoff {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int[] skills = new int[4];
            int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
            int temp;
            for (int i = 0; i < 4; i++) {
                temp = fs.nextInt();
                skills[i] = temp;
                if (temp > first) {
                    second = first;
                    first = temp;
                }else if(temp > second)
                    second = temp;
            }

            if ((skills[0] == first && skills[1] == second) || (skills[1] == first && skills[0] == second) || (skills[2] == first && skills[3] == second) || (skills[2] == second && skills[3] == first))
                out.println("NO");
            else
                out.println("YES");

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
