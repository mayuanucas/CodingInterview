/**
 * @author mayuan
 * @desc 面试题4：二维数组中的查找
 * @date 2018/02/04
 */
public class Solution04 {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[][] numbers = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target = 7;
        if (!findNumber(numbers, target)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }

        int[][] numbers2 = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        int target2 = 14;
        if (!findNumber(numbers2, target2)) {
            System.out.println("None");
        } else {
            System.out.println("\n------------------------");
        }
    }

    public static boolean findNumber(int[][] numbers, int target) {
        if (null == numbers || 0 == numbers.length) {
            return false;
        }

        int rows = numbers.length;
        int column = numbers[0].length;
        int r = 0;
        int c = column - 1;
        boolean flag = false;

        while (r < rows && 0 <= c) {
            if (numbers[r][c] == target) {
                System.out.print(target);
                flag = true;
                break;
            } else if (numbers[r][c] > target) {
                --c;
            } else {
                ++r;
            }
        }
        return flag;
    }

}
