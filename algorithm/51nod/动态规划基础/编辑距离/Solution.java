import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        System.out.println(Solution.editDistance(a, b));
//        System.out.println(Solution1009.edit_distance(a.toCharArray(), b.toCharArray()));
    }

    public static int minOfThere(int x, int y, int z){
        int min = (x < y) ? x : y;
        min = (min < z) ? min : z;
        return min;
    }

    public static int editDistance(String aString, String bString) {
        char[] a = aString.toCharArray();
        char[] b = bString.toCharArray();
        /**
         * d[0][*]存储上次最优结果，也就是d[i-1][j]
         * d[1][*]存储这次最优结果，也就是d[i][j]
         */
        int[][] d = new int[2][b.length + 1];

        int i, j;
        //初始化d[0][*] 与 d[1][0]
        for (j = 0; j <= b.length; j++) {
            d[0][j] = j;
        }
        d[1][0] = 1;

        for (i = 1; i <= a.length; i++) {
            // 当前行的首元素值与该行编号相等
            d[1][0] = i;
            for (j = 1; j <= b.length; j++) {
                // 算法中 a, b 字符串下标从 1 开始，java 从 0 开始，所以 -1
                if (a[i - 1] == b[j - 1]) {
                    d[1][j] = d[0][j - 1];
                } else {
                    d[1][j] = Solution.minOfThere(d[0][j] + 1, d[1][j-1] + 1, d[0][j-1] + 1);
                }
            }
            for (int k = 0; k <= b.length; k++) {
                d[0][k] = d[1][k];
            }
        }

        return d[1][b.length];
    }

    /**
     * 对问题进行分治求解 缺点是效率低下
     * @param a
     * @param b
     * @return
     */
    public static int edit_distance(char[] a, char[] b)
    {
        int lena = a.length;
        int lenb = b.length;
        int[][] d = new int[lena+1][lenb+1];
        int i, j;

        for (i = 0; i <= lena; i++) {
            d[i][0] = i;
        }
        for (j = 0; j <= lenb; j++) {
            d[0][j] = j;
        }

        for (i = 1; i <= lena; i++) {
            for (j = 1; j <= lenb; j++) {
                // 算法中 a, b 字符串下标从 1 开始，c 语言从 0 开始，所以 -1
                if (a[i-1] == b[j-1]) {
                    d[i][j] = d[i-1][j-1];
                } else {
                    d[i][j] = Solution.minOfThere(d[i-1][j]+1, d[i][j-1]+1, d[i-1][j-1]+1);
                }
            }
        }
        return d[lena][lenb];
    }

}
