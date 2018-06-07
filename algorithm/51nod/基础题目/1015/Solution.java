import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        // 直接输出预先算出来的水仙花数
        int[] arrayAnswer = new int[]{153, 370, 371, 407, 1634, 8208, 9474, 54748, 92727, 93084, 548834};
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();

        for (int i=0; i<arrayAnswer.length; i++){
            if (arrayAnswer[i] >= m){
                System.out.println(arrayAnswer[i]);
                break;
            }
        }




//        for (int i=101; i<1000000; i++){
//            if (i == Solution1009.calculateNumber(i)){
//                System.out.print(i + ", ");
//            }
//        }
    }

    public static int calculateNumber(int number){
        int bit = String.valueOf(number).length();

        double ans = 0.0D;
        while (0 < number){
            ans += Math.pow(number % 10, bit);
            number /= 10;
        }
        return (int)ans;
    }
}
