import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        long answer = 1L;
        for(int i=1; i<=n; i++){
            answer *= i;
            answer %= p;
        }
        System.out.println(answer);
    }
}
