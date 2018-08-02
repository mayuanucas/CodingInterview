package design.simplefactory;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class SimpleFactory {
    public Product createProduct(int type) {
        if (1 == type) {
            return new ConcreteProduct1();
        } else if (2 == type) {
            return new ConcreteProduct2();
        } else {
            return new ConcreteProduct();
        }
    }
}
