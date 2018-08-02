package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/26
 */
public class MyString {

    public static void main(String[] args) {
        String s1 = new String("aaa");
        String s2 = "aaa";
        // false
        System.out.println(s1 == s2);

        s1 = new String("bbb").intern();
        s2 = "bbb";
        // true
        System.out.println(s1 == s2);

        s1 = new String("ccc").intern();
        s2 = new String("ccc").intern();
        // true
        System.out.println(s1 == s2);

        s1 = "abcd";
        s2 = "ab" + "cd";
        // true
        System.out.println(s1 == s2);

        String temp = "hh";
        s1 = "a" + temp;
        s2 = "ahh";
        // false
        System.out.println(s1 == s2);

        temp = "hh";
        s1 = ("a" + temp).intern();
        s2 = "ahh";
        // true
        System.out.println(s1 == s2);

        // 同时会生成堆中的对象 以及 常量池中1的对象，但是此时s1是指向堆中的对象的
        s1 = new String("1");
        // 字符串常量池中已经存在 字符串"1"
        s1.intern();
        s2 = "1";
        // false
        System.out.println(s1 == s2);

        // 此时生成了四个对象->常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11")
        String s3 = new String("1") + new String("1");
        // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，此时会直接将s3的地址存储在常量池
        s3.intern();
        // jdk1.7之后，常量池中的地址其实就是s3的地址, 此时 s4 的值为 s3 的地址
        String s4 = "11";
        // jdk1.7之前false， jdk1.7之后true
        System.out.println(s3 == s4);

        s3 = new String("2") + new String("2");
        // 常量池中不存在字符串"22"，所以会新开辟一个存储"22"对象的常量池地址
        s4 = "22";
        // 字符串常量池中已经存在字符串"22",所以会返回"22"的引用(但此处并没有更新s3,s3依然是堆上对象的引用)
        s3.intern();
        // false
        System.out.println(s3 == s4);

    }
}
