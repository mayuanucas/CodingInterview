import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arrayNumber = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                arrayNumber[i][j] = sc.nextInt();
                if (0 < i){
                    if (0 == j){
                        arrayNumber[i][j] += arrayNumber[i-1][j];
                    } else if (i > j){
                        arrayNumber[i][j] += Math.max(arrayNumber[i-1][j-1], arrayNumber[i-1][j]);
                    } else {
                        arrayNumber[i][j] += arrayNumber[i-1][j-1];
                    }
                }
            }
        }

        int ans = 0;
        for (int j=0; j<n; j++){
            if (ans < arrayNumber[n-1][j]){
                ans = arrayNumber[n-1][j];
            }
        }

        System.out.println(ans);

    }
}
