package design.builder;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class Client {
    public static void main(String[] args) {
        MyStringBuilder msb = new MyStringBuilder();
        final int count = 26;
        for (int i = 0; i < count; i++) {
            msb.append((char) ('A' + i));
        }
        System.out.println(msb.toString());
    }
}
