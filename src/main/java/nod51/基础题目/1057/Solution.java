import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        BigInteger ans = BigInteger.valueOf(1);
        BigInteger temp;

        for (int i=1; i<=number; ++i){
            temp = BigInteger.valueOf(i);
            ans = ans.multiply(temp);
        }

        System.out.println(ans.toString());

    }
}
