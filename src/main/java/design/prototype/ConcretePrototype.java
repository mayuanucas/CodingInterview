package design.prototype;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class ConcretePrototype extends Prototype {

    private String field;

    public ConcretePrototype(String f) {
        this.field = f;
    }

    @Override
    Prototype myClone() {
        return new ConcretePrototype(field);
    }

    @Override
    public String toString() {
        return field;
    }
}
