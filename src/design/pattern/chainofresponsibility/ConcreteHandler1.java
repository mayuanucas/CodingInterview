package design.pattern.chainofresponsibility;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type1) {
            System.out.println(request.getName() + " is handle by ConcreteHandler1");
            return;
        }
        if (null != successor) {
            successor.handleRequest(request);
        }
    }
}
