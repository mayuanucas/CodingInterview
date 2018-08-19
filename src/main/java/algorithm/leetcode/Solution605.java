package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution605 {
    public static void main(String[] args) {

    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length && cnt < n; ++i) {
            if (1 == flowerbed[i]) {
                continue;
            }

            int pre = (0 == i) ? 0 : flowerbed[i - 1];
            int next = (flowerbed.length - 1 == i) ? 0 : flowerbed[i + 1];
            if (0 == pre && 0 == next) {
                flowerbed[i] = 1;
                ++cnt;
            }
        }
        return cnt >= n;
    }
}
