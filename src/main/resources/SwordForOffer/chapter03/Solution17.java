package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution17 {

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }

    public static void print1ToMaxOfNDigits(int num) {
        if (num <= 0) {
            return;
        }

        StringBuilder number = new StringBuilder(num);
        for (int i = 0; i < num; i++) {
            number.append('0');
        }
        while (increment(number)) {
            printNumber(number);
        }
    }

    public static boolean increment(StringBuilder str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) < '9' && str.charAt(i) >= '0') {
                str.setCharAt(i, (char) (str.charAt(i) + 1));
                return true;
            } else if (str.charAt(i) == '9') {
                str.setCharAt(i, '0');
            } else {
                return false;
            }
        }
        return false;
    }

    public static void printNumber(StringBuilder number) {
        boolean flag = false;
        for (int i = 0; i < number.length(); i++) {
            if (flag) {
                System.out.print(number.charAt(i));
            } else {
                if (number.charAt(i) != '0') {
                    flag = true;
                    System.out.print(number.charAt(i));
                }
            }
        }
        System.out.println();
    }
}
