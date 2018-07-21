package my.learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/21
 */
public class MyClass {

    public MyClass(){}

    public MyClass(String str){

    }

    public static void main(String[] args) {
        System.out.println("The class of String is: " + String.class.getName());
        System.out.println("The class of void is: " + void.class.getName());
        printClassName(9);

        Class<MyClass> c1 = MyClass.class;
        try {
            MyClass myClass1 = c1.newInstance();
            myClass1.printClassName(3.14);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void printClassName(Object obj) {
        System.out.println("The class of " + obj +
                " is: " + obj.getClass().getName());
    }
}
