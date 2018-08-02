package algorithm.leetcode;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/08
 */
public class Solution007 {

    public int reverse(int x) {
        int result = 0;

        while (0 != x){
            int tail = x % 10;
            int newResult = 10 * result + tail;

            if ((newResult - tail) / 10 != result){
                return 0;
            }

            result = newResult;
            x /= 10;
        }
        return result;
    }

}
