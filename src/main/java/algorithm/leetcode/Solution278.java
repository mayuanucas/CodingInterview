package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/20
 */
public class Solution278 extends VersionControl {
    public static void main(String[] args) {

    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * 仅作为示例
 */
class VersionControl {
    boolean isBadVersion(int version) {
        return true;
    }
}
