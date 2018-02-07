import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            int humans = sc.nextInt();
            int maxLoad = sc.nextInt();
            int[] weight = new int[humans];

            for (int i=0; i<humans; i++){
                weight[i] = sc.nextInt();
            }
            Arrays.sort(weight);

            int ships = 0;          //最少需要的独木舟数量
            for(int head=0, tail=humans-1; head<=tail;){
                if(head == tail){           //把最后一人单独放到独木舟上
                    ships++;
                    break;
                }
                if (weight[tail] + weight[head] <= maxLoad){
                    head++;
                    tail--;
                } else {
                    tail--;
                }
                ships++;
            }
            System.out.println(ships);
        }
    }
}
