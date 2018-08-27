import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1119 {
    static long max;
    static long[] prim;
    static long mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int m = Integer.parseInt(temp[0]), n = Integer.parseInt(temp[1]);

        long a = (m - 1) + (n - 1);
        long min = m > n ? n - 1 : m - 1;
        max = a;
        prim = produce_prim_number(max + 1);
        long out = c(a, min);

        bufferedWriter.write(out + "\n");
        bufferedWriter.flush();
    }

    static long c(long n, long m) {
        long ans = 1;
        int num;
        for (int i = 0; i < prim.length && prim[i] <= n && prim[i] != 0; ++i) {
            num = Cal(n, prim[i]) - Cal(m, prim[i]) - Cal(n - m, prim[i]);
            ans = (ans * Pow(prim[i], num, mod)) % mod;
        }
        return ans;
    }

    static long Pow(long n, int k, long m) {
        long ans = 1;
        while (k != 0) {
            if ((k & 1) != 0) {
                ans = (ans * n) % m;
            }
            n = (n * n) % m;
            k >>= 1;
        }
        return ans;
    }

    static int Cal(long x, long p) {
        int ans = 0;
        long rec = p;
        //System.out.println("xxxxxxxxxxxxx="+x);
        while (x >= rec) {
            //	System.out.println("rec="+ rec);
            ans += x / rec;
            //	System.out.println("ans="+ans);
            rec *= p;
        }
        return ans;
    }

    static long[] produce_prim_number(long max) {
        long[] prim_number = new long[(int) max];
        boolean[] isPrim = new boolean[(int) max + 1];
        int i = 2;
        int j = 2;
        isPrim[0] = isPrim[1] = true;
        while (i <= max) {
            if (isPrim[i] == false) {
                j = 2;
                while (i * j <= max) {
                    isPrim[i * j] = true;
                    j++;
                }
            }
            i++;
        }
        i = 2;
        j = 0;
        while (i <= max) {
            if (isPrim[i] == false) {
                prim_number[j] = i;
                j++;
            }
            i++;
        }

        return prim_number;
    }
}