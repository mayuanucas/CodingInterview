import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstStr = sc.nextLine().trim();
        String secondStr = sc.nextLine().trim();
        int[][] dp = new int[firstStr.length() + 1][secondStr.length() + 1];
        int[][] flag = new int[firstStr.length() + 1][secondStr.length() + 1];

        for (int i = 0; i < firstStr.length(); i++) {
            for (int j = 0; j < secondStr.length(); j++) {
                if (firstStr.charAt(i) == secondStr.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                    flag[i+1][j+1] = 1;     //行 列都回溯
                } else if(dp[i][j+1] >= dp[i+1][j]){
                    dp[i+1][j+1] = dp[i][j+1];
                    flag[i+1][j+1] = 2;     //行 回溯
                } else{
                    dp[i+1][j+1] = dp[i+1][j];
                    flag[i+1][j+1] = 3;     //列 回溯
                }
            }
        }

        int maxCommonLength = dp[firstStr.length()][secondStr.length()];
        int i = firstStr.length(), j = secondStr.length();
        char[] answer = new char[maxCommonLength];
        for(; i>0 && j>0; ){
            if(1 == flag[i][j]){    //只有标志位为1 相应位置上的字符才为公共字符
                answer[maxCommonLength-1] = firstStr.charAt(i-1);
                maxCommonLength--;
                i--;
                j--;
            }else if(2 == flag[i][j]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(answer);
    }
}
