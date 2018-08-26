import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        double ans = 0.0D;

        for (int i=1; i<=number; ++i){
            ans += Math.log10(i * 1.0);
        }
        ans++;

        System.out.println((int)ans);

    }
}
