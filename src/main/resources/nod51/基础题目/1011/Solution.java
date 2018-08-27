import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a == b){
            System.out.println(a);
            return;
        }

        while (0 != b){
            int rem = a % b;
            a = b;
            b = rem;
        }
        System.out.println(a);
    }
}
