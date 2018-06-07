import java.io.*;
import java.util.Stack;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/02
 */
public class Solution1138 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; n > 0; ) {
            n -= i++;

            if (0 == n % i && 0 != n) {
                stack.push(n / i);
            }
        }

        if (stack.isEmpty()) {
            bufferedWriter.write("No Solution\n");
            bufferedWriter.flush();
        } else {
            while (!stack.isEmpty()) {
                bufferedWriter.write(stack.pop() + "\n");
                bufferedWriter.flush();
            }
        }

    }
}
