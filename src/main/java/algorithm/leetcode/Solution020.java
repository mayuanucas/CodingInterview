package algorithm.leetcode;

import java.util.Stack;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/08
 */
public class Solution020 {

    public boolean isValid(String s) {
        if (null == s || (1 == (s.length() & 1))){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || stack.pop() != s.charAt(i)){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return stack.isEmpty();
    }

}
