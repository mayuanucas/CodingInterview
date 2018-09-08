package bishi;

import java.util.Scanner;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/06
 */
public class Main090703 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        String[] temp = scanner.nextLine().split("\\s+");
        // 香槟总层数
        int n = Integer.parseInt(temp[0]);
        // 指令数
        int m = Integer.parseInt(temp[1]);

        int[] cap = new int[n];
        int[] has = new int[n];
        temp = scanner.nextLine().split("\\s+");
        for (int i = 0; i < n; ++i) {
            cap[i] = Integer.parseInt(temp[i]);
        }

        for (int i = 0; i < m; ++i) {
            temp = scanner.nextLine().split("\\s+");
            if (3 == temp.length) {
                // 第x层
                int x = Integer.parseInt(temp[1]);
                // 导入体积为v
                int v = Integer.parseInt(temp[2]);
                for (int j = x - 1; j < n; ++j) {
                    int canTake = cap[j] - has[j];
                    if (canTake >= v) {
                        has[j] += v;
                        break;
                    } else {
                        v -= canTake;
                        has[j] = cap[j];
                        continue;
                    }
                }
            } else {
                int k = Integer.parseInt(temp[1]);
                System.out.println(has[k - 1]);
            }
        }
    }

}
