package design.pattern.chainofresponsibility;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        Request request1 = new Request(RequestType.type1, "request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.type2, "request2");
        handler2.handleRequest(request2);
    }
}
