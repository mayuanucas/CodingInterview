/**
 * @author mayuan
 * @desc
 * @date 2018/02/02
 */
public class Solution {

    public static void main(String[] args){
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
