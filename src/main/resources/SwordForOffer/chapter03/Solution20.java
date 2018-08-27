package SwordForOffer.chapter03;

/**
 * @author mayuan
 * @desc
 * @date 2018/03/01
 */
public class Solution20 {

    public static void main(String[] args){
        System.out.println(isNumeric("12e"));
        System.out.println(isNumeric("1e3.14"));
        System.out.println(isNumeric("1e-3.14"));
        System.out.println(isNumeric("1e-3"));
        System.out.println(isNumeric("1e3"));
    }

    public static boolean isNumeric(String text){
        if (null == text || 0 >= text.length()){
            return false;
        }
        return text.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }
}
