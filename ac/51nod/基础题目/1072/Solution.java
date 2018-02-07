import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int totalTest = sc.nextInt();
        while (0 < totalTest--){
            int min = sc.nextInt();
            int max = sc.nextInt();

            if (min == max){
                System.out.println("A");
            } else{
                // 确保 min变量代表的是两个数字中最小的 max变量代表的是两个数字中最大的
                if (min > max){
                    min ^= max;
                    max ^= min;
                    min ^= max;
                }

                int flag = (int)((max - min) * (1 + Math.sqrt(5)) / 2.0);
                if (min == flag){
                    System.out.println("B");
                }else {
                    System.out.println("A");
                }
            }
        }
    }
}
