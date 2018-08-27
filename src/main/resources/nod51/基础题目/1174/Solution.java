import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int lenthOfArray = sc.nextInt();
        int[] numberArray = new int[lenthOfArray];

        for (int i=0; i<lenthOfArray; i++){
            numberArray[i] = sc.nextInt();
        }

        int query = sc.nextInt();
        while (0 < query--){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int maxOfArray = numberArray[end];
            for (int j=start; j<end; j++){
                if (maxOfArray < numberArray[j]){
                    maxOfArray = numberArray[j];
                }
            }

            System.out.println(maxOfArray);
        }
    }
}
