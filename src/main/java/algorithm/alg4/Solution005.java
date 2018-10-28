package algorithm.alg4;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/10/28
 */
public class Solution005 {

    public static void main(String[] args) {
        String str1 = "( 1.2 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        System.out.println(str1 + " == " + calculate(str1));
    }

    /**
     * 双栈算术表达式求值 (支持 sqrt)
     *
     * @param str
     * @return
     */
    public static double calculate(String str) {
        String[] strs = str.split("\\s+");

        // 运算符栈
        Deque<String> ops = new ArrayDeque<>();
        // 操作数栈
        Deque<Double> values = new ArrayDeque<>();

        for (String s : strs) {
            //忽略左括号
            if ("(".equals(s)) {
                continue;
            } else if ("+".equals(s) ||
                    "-".equals(s) ||
                    "*".equals(s) ||
                    "/".equals(s) ||
                    "sqrt".equals(s) ||
                    "SQRT".equals(s)) {
                ops.offerLast(s);
            } else if (")".equals(s)) {
                //遇到右括号,弹出运算符和操作数,计算并将结果压入栈中
                String op = ops.pollLast();
                double val = values.pollLast();

                //根据运算符选择不同的运算
                if ("+".equals(op)) {
                    val += values.pollLast();
                } else if ("-".equals(op)) {
                    val -= values.pollLast();
                } else if ("*".equals(op)) {
                    val *= values.pollLast();
                } else if ("/".equals(op)) {
                    val /= values.pollLast();
                } else if ("sqrt".equals(op) || "SQRT".equals(op)) {
                    val = Math.sqrt(val);
                }

                // 将运算结果压入栈中
                values.offerLast(val);
            } else {
                // 如果该字符既不是运算符也不是括号,将它作为double 值压入栈
                values.offerLast(Double.parseDouble(s));
            }
        }

        return values.pollLast();
    }

}
