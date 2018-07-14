package design.pattern.chainofresponsibility;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handleRequest(Request request) {
        if (request.getType() == RequestType.type2) {
            System.out.println(request.getName() + " is handle by ConcreteHandler2");
            return;
        }
        if (null != successor) {
            successor.handleRequest(request);
        }
    }
}
