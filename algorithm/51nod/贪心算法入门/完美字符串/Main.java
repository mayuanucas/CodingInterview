import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String text = sc.next().toLowerCase();
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                int count = map.containsKey(c) ? map.get(c) : 0;
                map.put(c, ++count);
            }

            List<Integer> list = new ArrayList<>();
            map.forEach((k, v)-> list.add(v));
            Collections.sort(list, Comparator.reverseOrder());      // 使用从大到小的排序规则

            BigInteger sum = new BigInteger("0");                // 设定初始值为0
            Integer current = 0;
            int seq = 26;
            for(Integer i : list){
                current = i * (seq--);
                sum = sum.add(BigInteger.valueOf(current.longValue()));
            }
            System.out.println(sum.toString());
        }
    }
}