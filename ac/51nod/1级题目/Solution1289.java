import java.io.*;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author mayuan
 * @desc 思路：
 * <p>
 * 向左走的可能会被向右走的吃，向右走的可能被向左的吃,栈中存向右的小鱼。
 * <p>
 * 如果当前鱼向左，则依次与栈顶鱼比较大小，如果能吃光则能存活(否则其也不能存活)；如果当前鱼向右，则加入栈。
 * <p>
 * 最后栈中鱼的数量加上向左走存活的数量就是所有能存活的。
 * @date 2017/11/29
 */
public class Solution1289 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        int death = 0;
        for (int i = 0; i < n; i++) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            int weight = Integer.parseInt(temp[0]);
            int direction = Integer.parseInt(temp[1]);

            if (1 == direction) {
                stack.push(weight);
            }
            if (0 == direction) {
                while (!stack.isEmpty() && stack.peek() < weight) {
                    stack.pop();
                    death++;
                }
                /**
                 * 如果跳出循环的原因为：该条小鱼无法吃掉对象的小鱼，则可知这条小鱼也无法活下去（它会被对象的大鱼吃掉）
                 */
                if (!stack.empty()) {
                    death++;
                }
            }
        }
        bufferedWriter.write(n - death + "\n");
        bufferedWriter.flush();
    }
}