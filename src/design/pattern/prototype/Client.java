package design.pattern.prototype;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class Client {
    public static void main(String[] args) {
        Prototype prototype = new ConcretePrototype("abc");
        Prototype clone = prototype.myClone();
        System.out.println(clone);
    }
}
