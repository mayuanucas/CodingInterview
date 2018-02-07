import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int mod = 1000000007;

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matrix = new int[m+1][n+1];

        for (int i=1; i<=m; i++){
            matrix[i][1] = 1;
        }
        for (int j=1; j<=n; j++){
            matrix[1][j] = 1;
        }

        for (int i=2; i<=m; i++){
            for (int j=2; j<=n; j++){
                matrix[i][j] = (matrix[i-1][j] % mod + matrix[i][j-1] % mod) % mod;
            }
        }

        System.out.println(matrix[m][n]);
    }
}
