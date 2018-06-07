/**
 * @author mayuan
 * @desc
 * @date 2018/02/05
 */
public class Solution05 {

    public static void main(String[] args){
        test();
    }

    public static void test() {
        String replace = "%20";

        String testStr = "hello world!";
        String testStr2 = " hello world!";
        String testStr3 = "hello    world!";
        String testStr4 = "hello    world! ";

        String output = null;

        output = replaceBlank(testStr, replace);
        if (null == output) {
            System.out.println("None");
        } else {
            System.out.println(output);
            System.out.println("------------------------");
        }

        output = replaceBlank(testStr2, replace);
        if (null == output) {
            System.out.println("None");
        } else {
            System.out.println(output);
            System.out.println("------------------------");
        }

        output = replaceBlank(testStr3, replace);
        if (null == output) {
            System.out.println("None");
        } else {
            System.out.println(output);
            System.out.println("------------------------");
        }

        output = replaceBlank(testStr4, replace);
        if (null == output) {
            System.out.println("None");
        } else {
            System.out.println(output);
            System.out.println("------------------------");
        }
    }

    public static String replaceBlank(String originStr, String replaceStr) {
        if (null == originStr || 0 == originStr.length()){
            return null;
        }

        return originStr.replaceAll("\\s", replaceStr);
    }

}
