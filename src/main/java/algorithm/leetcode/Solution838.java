package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 推多米诺
 * @date: 2019/01/11
 */
public class Solution838 {

    /**
     * 1. 'R......R' => 'RRRRRRRR'
     * 2. 'R......L' => 'RRRRLLLL' or 'RRRR.LLLL'
     * 3. 'L......R' => 'L......R'
     * 4. 'L......L' => 'LLLLLLLL'
     *
     * @param dominoes
     * @return
     */
    public String pushDominoes(String dominoes) {
        if (null == dominoes || 1 >= dominoes.length()) {
            return dominoes;
        }

        // 将所有情况统一处理为以上4种类型
        String d = "L" + dominoes + "R";
        StringBuilder stringBuilder = new StringBuilder();
        // i指针在左侧, j指针在右侧
        // i指针始终指向左侧的L或R, j指针始终指向右侧的L或R
        for (int j = 1, i = 0; j < d.length(); ++j) {
            if (d.charAt(j) == '.') {
                continue;
            }
            // 指i指针与j指针中间元素的个数
            int middle = j - i - 1;
            // 任何情况都需先将最左侧字符加入结果中
            if (0 < i) {
                stringBuilder.append(d.charAt(i));
            }
            if (d.charAt(i) == d.charAt(j)) {
                for (int k = 0; k < middle; ++k) {
                    stringBuilder.append(d.charAt(i));
                }
            } else if ('L' == d.charAt(i) && 'R' == d.charAt(j)) {
                for (int k = 0; k < middle; ++k) {
                    stringBuilder.append('.');
                }
            } else {
                for (int k = 0; k < middle / 2; ++k) {
                    stringBuilder.append(d.charAt(i));
                }
                if (1 == (middle & 1)) {
                    stringBuilder.append('.');
                }
                for (int k = 0; k < middle / 2; ++k) {
                    stringBuilder.append(d.charAt(j));
                }
            }
            i = j;
        }
        return stringBuilder.toString();
    }

}
