import java.io.*;
import java.util.Arrays;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/27
 */
public class Solution1432 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");

        int humans = Integer.parseInt(temp[0]);
        int maxLoad = Integer.parseInt(temp[1]);
        int[] weight = new int[humans];

        for (int i = 0; i < humans; i++) {
            weight[i] = Integer.parseInt(bufferedReader.readLine());
        }
        Arrays.sort(weight);

        //最少需要的独木舟数量
        int ships = 0;
        for (int head = 0, tail = humans - 1; head <= tail; ) {
            //把最后一人单独放到独木舟上
            if (head == tail) {
                ships++;
                break;
            }
            if (weight[tail] + weight[head] <= maxLoad) {
                head++;
                tail--;
            } else {
                tail--;
            }
            ships++;
        }
        bufferedWriter.write(ships + "\n");
        bufferedWriter.flush();
    }

}
