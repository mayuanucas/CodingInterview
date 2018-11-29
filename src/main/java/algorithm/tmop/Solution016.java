package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 完美洗牌算法
 * 时间复杂度: O(n)
 * 空间复杂度:
 * @date:
 */
public class Solution016 {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8};

        locationReplace(a);
    }

    /**
     * 下标从1开始计数
     * a1,a2,a3,a4,b1,b2,b3,b4
     * n 为4
     * 1.当 i <= n 时, 该元素在新数组中的下标为: 2*i
     * 2.当 i > n 时, 该元素在新数组中的下标为: (2*i)%(2*n+1)
     *
     * @param a
     */
    public static void locationReplace(int[] a) {
        if (null == a || 0 >= a.length) {
            return;
        }

        int[] b = new int[a.length];
        int n = (a.length - 1) >>> 1;
        int n2 = n * 2;

        for (int i = 1; i < a.length; ++i) {
            if (i <= n) {
                b[2 * i] = a[i];
            } else {
                b[(2 * i) % (n2 + 1)] = a[i];
            }
        }

        for (int num : b) {
            System.out.print(num + " ");
        }
    }

}
