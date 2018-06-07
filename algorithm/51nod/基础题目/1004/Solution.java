import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BigInteger n = BigInteger.valueOf(sc.nextInt());

        System.out.println(n.modPow(n, BigInteger.valueOf(10)));
    }
}
