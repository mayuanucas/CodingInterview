import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int m = a, n = b;
        while (0 != n){
            int rem = m % n;
            m = n;
            n = rem;
        }

        long mul = (long)a * b / m;
        System.out.println(mul);
        
    }
}
