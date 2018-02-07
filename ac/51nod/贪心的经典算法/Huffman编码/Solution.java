import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int minPower = 0;
            Queue<Integer> queue = new PriorityQueue<>();

            for(int i=0; i<n; i++){
                queue.add(sc.nextInt());
            }

            int first = 0, second = 0, temp = 0;
            while (queue.size() > 1){
                first = queue.poll();
                second = queue.poll();
                temp = first + second;
                queue.add(temp);

                minPower += temp;
            }
            System.out.println(minPower);
        }
    }
}
