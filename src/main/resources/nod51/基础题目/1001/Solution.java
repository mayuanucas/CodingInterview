import java.util.Arrays;
import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arrayNumber = new int[n];
        boolean hasResult = false;

        for (int i = 0; i < n; i++) {
            arrayNumber[i] = sc.nextInt();
        }
        Arrays.sort(arrayNumber);

        int begin=0, end=n-1, currentSum=0;
        while (begin < end){
            currentSum = arrayNumber[begin] + arrayNumber[end];
            if (currentSum == k){
                hasResult = true;
                System.out.println(arrayNumber[begin++] + " " + arrayNumber[end--]);
            } else if (currentSum < k){
                begin++;
            } else {
                end--;
            }
        }
        if (!hasResult) {
            System.out.println("No Solution1009");
        }
    }
}
