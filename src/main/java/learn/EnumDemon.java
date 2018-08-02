package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/13
 */
public class EnumDemon {

    public static void main(String[] args) {
        for (Day day : Day.values()) {
            System.out.println("order: " + day.ordinal() + ", name: " + day.name() + ", desc: " + day.getDesc());
        }
    }
}

enum Day {
    /**
     * 周一
     */
    MONDAY("周一"),
    /**
     * 周二
     */
    TUESDAY("周二"),
    /**
     * 周三
     */
    WEDNESDAY("周三"),
    /**
     * 周四
     */
    THURSDAY("周四"),
    /**
     * 周五
     */
    FRIDAY("周五"),
    /**
     * 周六
     */
    SATURDAY("周六"),
    /**
     * 周日
     */
    SUNDAY("周日");

    private String desc;

    private Day(String d) {
        this.desc = d;
    }

    public String getDesc() {
        return desc;
    }
}
