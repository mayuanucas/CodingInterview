/**
 * @author mayuan
 * @desc 代码笔记
 * @date 2018/02/26
 */
public class Notes {

    public static void main(String[] args) {
        swap(6, 9);
    }

    /**
     * 不使用临时变量，直接交换两个数据。
     */
    public static void swap(int a, int b) {
        System.out.println("交换前:");
        System.out.println(a + " " + b);

        a ^= b;
        b ^= a;
        a ^= b;

        System.out.println("交换后:");
        System.out.println(a + " " + b);
    }
}
