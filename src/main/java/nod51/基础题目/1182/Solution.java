import java.util.*;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.next().toLowerCase();

        Map<Character, Integer> map = new HashMap<>(text.length());

        for (int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            int count = map.containsKey(c)? map.get(c): 0;
            map.put(c, ++count);
        }

        List<Integer> list = new ArrayList<>();
        map.forEach((k, v) -> list.add(v));
        Collections.sort(list, Comparator.reverseOrder());

        int ans = 0, value=26;
        for (Integer i : list){
            ans += i * (value--);
        }

        System.out.println(ans);
    }
}
