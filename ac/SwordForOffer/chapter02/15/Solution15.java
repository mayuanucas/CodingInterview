/**
 * @author mayuan
 * @desc
 * @date 2018/02/28
 */
public class Solution15 {

    public static void main(String[] args) {
        System.out.println(numberOfOne(9));
    }

    public static int numberOfOne(int number) {
        int count = 0;
        while (0 != number) {
            number = (number - 1) & number;
            count++;
        }
        return count;
    }
}
