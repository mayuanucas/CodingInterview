import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totalTest = sc.nextInt();
        int[] p = new int[totalTest];
        int[] m = new int[totalTest];

        for (int i=0; i<totalTest; i++){
            p[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }

        int lcm = 1;
        int ans = m[0];
        for (int i=0; i<totalTest-1; i++){
            lcm *= p[i];
            while (ans % p[i+1] != m[i+1]){
                ans += lcm;
            }
        }

        System.out.println(ans);
    }
}
