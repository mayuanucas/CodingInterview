import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String originString = sc.next();

        StringBuilder stringBuilder = new StringBuilder("#");
        for (int i=0; i<originString.length(); i++){
            stringBuilder.append(originString.charAt(i));
            stringBuilder.append("#");
        }

        String newString = stringBuilder.toString();
        // rad[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int [] rad = new int[newString.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // mid表示已知的回文中，拥有最右边界的回文的中点坐标（对称轴位置）
        int mid = -1;
        // 2.计算所有的rad
        // 这个算法是O(n)的，因为right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newString.length(); i ++) {
            // 2.1.确定一个最小的半径
            if (i <= right) {
                rad[i] = Math.min(rad[2 * mid - i], mid + rad[mid] - i);
            }
            // 2.2.尝试更大的半径
            while (i - rad[i] >= 0 && i + rad[i] < newString.length() &&
                    newString.charAt(i - rad[i]) == newString.charAt(i + rad[i])) {
                rad[i]++;
            }
            // 2.3.更新边界和回文中心坐标
            if (i + rad[i] - 1> right) {
                right = i + rad[i] - 1;
                mid = i;
            }
        }
        // maxRad代表字符串最长回文字符串的长度
        int maxRad = 0;
        for (int i=0; i<rad.length; i++){
            if (maxRad < rad[i]){
                maxRad = rad[i];
            }
        }
        // maxRad的值减一即为最长回文字符串的长度
        maxRad--;

        System.out.println(maxRad);

    }
}
