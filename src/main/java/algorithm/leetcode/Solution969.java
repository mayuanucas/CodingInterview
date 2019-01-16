package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 煎饼排序
 * @date: 2019/01/16
 */
public class Solution969 {

    public static void main(String[] args) {
        int[] array = {3, 2, 4, 1};

        for (Integer e : new Solution969().pancakeSort(array)) {
            System.out.println(e);
        }
    }

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new LinkedList<>();

        for (int k = A.length; k > 0; --k) {
            int i = 0;
            while (k != A[i]) {
                ++i;
            }
            reverse(A, i + 1);
            if (0 != i) {
                ans.add(i + 1);
            }
            reverse(A, k);
            if (1 != k) {
                ans.add(k);
            }
        }
        return ans;
    }

    public void reverse(int[] array, int k) {
        for (int i = 0, j = k - 1; i < j; ++i, --j) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}
