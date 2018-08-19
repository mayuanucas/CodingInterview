package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution744 {
    public static void main(String[] args) {
        char[] array = {'c', 'f', 'j'};

        Solution744 test = new Solution744();
        System.out.println(test.nextGreatestLetter(array, 'd'));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // 找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
        return (left < letters.length) ? letters[left] : letters[0];
    }
}
