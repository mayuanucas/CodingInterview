package design.pattern.chainofresponsibility;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public abstract class Handler {
    protected Handler successor;

    public Handler(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handleRequest(Request request);
}
