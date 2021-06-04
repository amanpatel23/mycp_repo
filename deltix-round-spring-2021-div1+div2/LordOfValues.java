/* 
    Author: Aman Patel
    Date: 31-05-2021
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class LordOfValues {

    static int k;
    static List<ActionInfo> actionArr;

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();

            int[] nums = fs.readArray(n);

            k = 0;
            actionArr = new ArrayList<>();
            for (int i = 0; i < n; i += 2) {
                operation(nums[i], nums[i + 1], i + 1, i + 2);
            }

            out.println(k);
            for (ActionInfo actionInfo : actionArr) {
                out.println(actionInfo.type + " " + actionInfo.i + " " + actionInfo.j);
            }
        }

        out.close();
    }

    static class ActionInfo {
        int type, i, j;

        ActionInfo(int type, int i, int j) {
            this.type = type;
            this.i = i;
            this.j = j;
        }
    }

    static void operation(long a, long b, int i, int j) {

        long tempA = a;
        long tempB = b;

        int _count = 0;
        while (_count < 6) {
            if ((_count & 1) == 0) {
                tempA += tempB;
                actionArr.add(new ActionInfo(1, i, j));
            } else {
                tempB -= tempA;
                actionArr.add(new ActionInfo(2, i, j));
            }

            _count++;
        }

        k += _count;
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
