package learn;

/**
 * @author: mayuan
 * @desc: 在Java中会有一个Integer缓存池，缓存的大小是：-128~127
 * @date: 2018/08/04
 */
public class MyInteger {

    /**
     * 使用==的情况：
     * 如果比较Integer变量，默认比较的是地址值。
     * Java的Integer维护了从-128~127的缓存池
     * 如果比较的某一边有操作表达式(例如a+b)，那么比较的是具体数值
     * <p>
     * 使用equals()的情况：
     * 无论是Integer还是Long中的equals()默认比较的是数值。
     * Long的equals()方法，JDK的默认实现：会判断是否是Long类型
     * 注意自动拆箱，自动装箱问题。
     *
     * @param args
     */
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;

        Long g = 3L;
        Long h = 2L;

        // true 引用的是缓存池中相同对象
        System.out.println(c == d);
        // false 该范围不在缓存池中,引用的是不同的对象
        System.out.println(e == f);
        // true 使用 == 判断,并且一边有算术表达式,那么比较的数值
        System.out.println(c == (a + b));
        // true equals 比较的是数值
        System.out.println(c.equals(a + b));
        // true 存在数值表达式,此处比较的是两边的数值是否相等(即等价于下一条语句)
        System.out.println(g == (a + b));
        System.out.println(g.longValue() == a.intValue() + b.intValue());
        // false Long的equals()先判断传递进来的是不是Long类型，如果不是直接返回 false(而此处a+b自动装箱的是Integer类型)
        System.out.println(g.equals(a + b));
        // true (而此处a+h自动装箱的是Long类型)
        System.out.println(g.equals(a + h));

    }

}
