/* 
    Author: Aman Patel
    Date: 08-06-2021
*/


import java.io.*;
import java.util.*;

public class CF724_B {

    public static void main(String[] args) {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = fs.nextInt();

        while (t-- > 0) {
            int n;
            n = fs.nextInt();
            String s;
            s = fs.next();

            List<TreeSet<String>> substrings = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                substrings.add(i, new TreeSet<>());
            }

            StringBuilder substr = new StringBuilder();
            int len = 1;
            for (int i = 0; i < n; i++) {
                substr.append(s.charAt(i));
                substrings.get(len).add(substr.toString());
                for (int j = i + 1; j < n; j++) {
                    substr.append(s.charAt(j));
                    len++;
                    substrings.get(len).add(substr.toString());
                }

                len = 1;
                substr = new StringBuilder();
            }

            List<String> substrLen1 = new ArrayList<>();
            for(int i = 0; i < 26; i++)
            {
                String temp = "" +  (char) (97 + i);
                substrLen1.add(temp);
            }

            boolean flag = false;

            Iterator<String> it = substrings.get(1).iterator();
            for (String value : substrLen1) {
                if(it.hasNext())
                {
                    String tempIt = it.next();
                    if((!value.equals(tempIt)))
                    {
                        out.println(value);
                        flag = true;
                        break;
                    }
                }else
                {
                    out.println(value);
                    flag = true;
                    break;
                }
            }

            if(flag)
                continue;

            List<String> substrLen2 = new ArrayList<>();
            for(int i = 0; i < 26; i++)
            {
                for(int j = 0; j < 26; j++)
                {
                    substrLen2.add(substrLen1.get(i) + substrLen1.get(j));
                }
            }

            it = substrings.get(2).iterator();
            for (String value : substrLen2) {
                if(it.hasNext()) {
                    String tempIt = it.next();
                    if ((!value.equals(tempIt))) {
                        out.println(value);
                        flag = true;
                        break;
                    }
                }else
                {
                    out.println(value);
                    flag = true;
                    break;
                }
            }

            if(flag)
                continue;

            it = substrings.get(3).iterator();
            for(int i = 0; i < 26; i++)
            {
                for (String value : substrLen2) {
                    String temp = substrLen1.get(i) + value;
                    if (it.hasNext()) {
                        String tempIt = it.next();
                        if ((!temp.equals(tempIt))) {
                            out.println(temp);
                            i = 27;
                            break;
                        }
                    } else {
                        out.println(temp);
                        i = 27;
                        break;
                    }
                }
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
