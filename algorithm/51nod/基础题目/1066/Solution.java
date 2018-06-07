import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totalTest = sc.nextInt();
        while (0 < totalTest--){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if (0 == n % (k + 1)){
                System.out.println("B");
            } else{
                System.out.println("A");
            }
        }
    }
}
