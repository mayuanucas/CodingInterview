package design.chainofresponsibility;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class Request {
    private RequestType type;
    private String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }

    public RequestType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }
}
