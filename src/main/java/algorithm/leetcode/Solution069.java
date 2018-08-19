package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution069 {
    public static void main(String[] args){
        Solution069 test = new Solution069();

        System.out.println(test.mySqrt(1));
        System.out.println(test.mySqrt(2));
        System.out.println(test.mySqrt(3));
        System.out.println(test.mySqrt(4));
        System.out.println(test.mySqrt(9));
    }

    public int mySqrt(int x) {
        if (1 >= x) {
            return x;
        }

        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return sqrt;
            } else if (sqrt < mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
