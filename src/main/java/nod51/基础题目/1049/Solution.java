import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        int answerStart = 0, answerEnd = 0;     //最大子数组的开始位置 结束位置
        long answerMax = (long)numbers[0];     //最大子数组的总和
        int currentStart = 0;                   //当前子数组开始位置 (当前子数组结束位置可以由i得到)
        long leftArraySum = (long)numbers[0];    //左侧相邻子数组的和(注意！ 左侧相邻子数组的和可能会大于int的表示范围)
        for(int i=1; i<n; i++){
            if(0 < leftArraySum){
                leftArraySum += numbers[i];
            }else{
                currentStart = i;
                leftArraySum = numbers[i];
            }

            if(leftArraySum > answerMax){
                answerMax = leftArraySum;
                answerStart = currentStart;
                answerEnd = i;
            }
        }
//        System.out.println("start:" + answerStart + " end:" + answerEnd);
        System.out.println(answerMax);
        
    }
}
