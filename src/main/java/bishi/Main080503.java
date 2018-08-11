package bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/05
 */
public class Main080503 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] temp = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(temp[0]);
            int targetID = Integer.parseInt(temp[1]);

            String[][] matrix = new String[n][];

            // 存储矩阵
            for (int i = 0; i < n; i++) {
                matrix[i] = scanner.nextLine().split("\\s+");
            }

            int answerID = -1;
            int answerSameValue = 0;
            String[] targetString = matrix[targetID];

            for (int i = 0; i < n; i++) {
                if (i == targetID) {
                    continue;
                }

                int currentSameValue = countSame(targetID, targetString, i, matrix[i]);
                if (currentSameValue > answerSameValue) {
                    answerSameValue = currentSameValue;
                    answerID = i;
                }
            }

            System.out.println(answerID);
        }
    }

    private static int countSame(int tID, String[] tString, int dID, String[] dString) {
        int ans = 0;
        Set<String> t = new HashSet<>(tString.length);
        for (String temp : tString) {
            t.add(temp);
        }

        Set<String> d = new HashSet<>(dString.length);
        for (String temp : dString) {
            d.add(temp);
        }

        // 是朋友关系
        if (t.contains(String.valueOf(dID))) {
            return ans;
        }

        // 求交集
        d.retainAll(t);
        return d.size();
    }
}
