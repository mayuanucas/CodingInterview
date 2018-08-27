import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int testNumber = sc.nextInt();
        while (0 < testNumber--){
            int n = sc.nextInt();

            long ans = (long)(0.5 * Math.log10(2.0 * Math.PI * n) + n * Math.log10(1.0 * n / Math.E) + 1);

            System.out.println(ans);
        }

    }
}
