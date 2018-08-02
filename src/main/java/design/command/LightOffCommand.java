package design.command;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/14
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
