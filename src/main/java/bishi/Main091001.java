package bishi;

import java.util.*;

/**
 */
public class Main091001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().trim();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        int time = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            set.add(entry.getValue());
            if (entry.getValue() < time) {
                time = entry.getValue();
            }
        }

        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == time) {
                list.add(entry.getKey());
            }
        }

        if (set.size() <= 1) {
            System.out.println("");
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!list.contains(c)) {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}