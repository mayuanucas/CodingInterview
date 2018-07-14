package design.pattern.simplefactory;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        Product product = simpleFactory.createProduct(1);
    }
}
