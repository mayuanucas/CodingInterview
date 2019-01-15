package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2019/01/15
 */
public class Solution922 {

    public int[] sortArrayByParityII(int[] A) {
        if (null == A || 1 >= A.length) {
            return A;
        }

        // 偶数指针(even pointer)
        int i = 0;
        // 奇数指针(odd pointer)
        int j = 1;
        while (i < A.length && j < A.length) {
            while (i < A.length && 0 == (A[i] & 1)) {
                i += 2;
            }
            while (j < A.length && 1 == (A[j] & 1)) {
                j += 2;
            }
            if (i < A.length && j < A.length) {
                swap(A, i, j);
            }
        }
        return A;
    }

    public void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

}
