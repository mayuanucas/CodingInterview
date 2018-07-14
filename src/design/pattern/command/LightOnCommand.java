package design.pattern.command;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
