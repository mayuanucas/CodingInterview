package bishi;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/06
 */
public class Main090602 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        int t = Integer.parseInt(temp[2]);

        int[] numbers = new int[n];

        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            int num = scanner.nextInt();
            numbers[i] = num;
            map.put(num, map.getOrDefault(map, 0) + 1);
        }

        List<Integer> target = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= t) {
                target.add(entry.getKey());
            }
        }

        int ans = 0;
        for (int i = 0; i <= n - k; ++i) {
            if (hasValue(numbers, t, target, i, i + k - 1)) {
                ++ans;
            }
        }

        System.out.println(ans);

    }

    private static boolean hasValue(int[] array, int t, List<Integer> list, int left, int right) {
        Map<Integer, Integer> current = new HashMap<>(right - left + 1);
        for (int i = left; i <= right; ++i) {
            current.put(array[i], current.getOrDefault(array[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
            if (entry.getValue() >= t) {
                return true;
            }
        }

        return false;
    }
}
