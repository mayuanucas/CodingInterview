import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(Solution.phi(n));

    }

    public static int phi(int n){
        int re = n;
        for (int i=2; i*i <= n; i++){
            if (0 == n%i){
                re = re - re/i;
            }
            while (0 == n%i){
                n /= i;
            }
        }

        if (1 < n){
            re = re - re / n;
        }
        return re;
    }
}
