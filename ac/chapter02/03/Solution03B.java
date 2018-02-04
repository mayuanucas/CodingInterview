import java.util.HashSet;
import java.util.Set;

/**
 * @author mayuan
 * @desc 面试题3（一）：找出数组中重复的数字
 * @date 2018/02/02
 */
public class Solution03B {

    /**
     * 找出数组中所有的重复的数字，直接输出(每个重复的数字仅输出一遍)
     * 没有重复的数字则输出 None
     *
     * @param args
     */
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] numbers = {2, 4, 3, 1, 4};
        if (!duplicate(numbers)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }

        int[] numbers2 = {2, 1, 3, 1, 4};
        if (!duplicate(numbers2)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }

        int[] numbers3 = {2, 4, 2, 1, 4};
        if (!duplicate(numbers3)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }

        int[] numbers4 = {2, 1, 3, 0, 4};
        if (!duplicate(numbers4)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }

    }

    public static boolean duplicate(int[] numbers) {
        if (null == numbers || 0 == numbers.length) {
            return false;
        }

        for (int i = 0; i < numbers.length; ++i) {
            if (0 > numbers[i] || (numbers.length - 1 < numbers[i])) {
                return false;
            }
        }

        boolean flag = false;
        int[] count = new int[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            count[numbers[i]]++;
        }

        for (int i = 1; i < numbers.length; ++i) {
            if (1 < count[i]){
                flag = true;
                System.out.print(i + " ");
            }
        }
        return flag;
    }

}
