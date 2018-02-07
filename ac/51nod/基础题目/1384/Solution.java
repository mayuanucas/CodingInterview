import java.util.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] originString = sc.next().toCharArray();

        // TreeSet会自动按自然排序法给元素排序,即1排在2前,a排在b前
        Set<String> set = new TreeSet<>();

        Arrays.sort(originString);
        Solution.dfs(originString, 0, set);

        for (String str : set){
            System.out.println(str);
        }

    }

    public static void dfs(char[] text, int cnt, Set<String> set) {
        if (cnt == text.length - 1) {
            set.add(new String(text));
        } else {
            for (int i = cnt; i < text.length; i++) {
                // 判断是否是重复字母 如果是重复的字母就不交换 加快程序速度
                if (i != cnt && text[i] == text[cnt]){
                    continue;
                }
                Solution.swap(text, i, cnt);
                dfs(text, cnt + 1, set);
                Solution.swap(text, i, cnt);
            }
        }
    }

    public static void swap(char[] array, int j, int k){
        char temp = array[j];
        array[j] = array[k];
        array[k] = temp;
    }
}
