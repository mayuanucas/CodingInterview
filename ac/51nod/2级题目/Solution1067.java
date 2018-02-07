import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/25
 *  博弈论的关键: 局面逆转, 如果能把当前局面逆转为必输局面, 先手就获胜. (让对手面临必输局面)

我们先列出石子为1-20的情况

1 A// 全部撸走

2 B //只能拿1, 3, 4 所以先手只能拿1个, 局面无法逆转, 先手输

3 A // 全部撸走

4 A // 全部撸走

5 A // 先手拿3个, 然后变成N=2的情况, 这是一个必输局面, 所以先手获胜

6 A // 先手拿4个, 然后变成N=3的情况, 这是一个必输局面, 所以先手获胜

7 B // 拿1, 3, 4都无法逆转为必输局面, 所以先手跪

8 A // 先手拿1个, 然后变成N=7的情况, 这是一个必输局面, 所以先手获胜

9 B // 拿1, 3, 4都无法逆转为必输局面, 所以先手跪

10 A ....

11 A ....

12 A ....

13 A

14 B

15 A

16 B

17 A

18 A

19 A

20 A

...

写的过程中我们发现, 石子数为N时, 输赢和N-1, N-3, N-4有关. 如果N-1, N-3, N-3存在必输局面, 先手获胜.

进一步观察, 发现存在循环.

当N大于等于2时, 都是在循环 B A A A A B A这个序列. 所以, 答案就出来了.
 */
public class Solution1067 {

    public static void main(String[] main) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        char flag[] = {'B', 'A', 'A', 'A', 'A', 'B', 'A'};

        int t = Integer.parseInt(bufferedReader.readLine());
        while (0 < t--) {
            int n = Integer.parseInt(bufferedReader.readLine());

            if (1 == n) {
                bufferedWriter.write("A\n");
                bufferedWriter.flush();
                continue;
            }

            n -= 2;
            bufferedWriter.write(flag[n % 7] + "\n");
            bufferedWriter.flush();

        }

    }
}
