import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totatlTest = sc.nextInt(), temp = 0;
        // 做异或运算,最终结果等于0时,先手输,否则后手输
        int ans = 0;
        while (0 < totatlTest--){
            temp = sc.nextInt();
            ans ^= temp;
        }

        if(0 == ans){
            System.out.println("B");
        } else{
            System.out.println("A");
        }
    }
}
