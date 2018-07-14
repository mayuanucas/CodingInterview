package design.pattern.builder;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class MyStringBuilder extends AbstractStringBuilder {
    public MyStringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(value, 0, count);
    }
}
