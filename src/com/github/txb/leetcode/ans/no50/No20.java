package com.github.txb.leetcode.ans.no50;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NO.20. Valid Parentheses
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order,
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * Created by tanghui on 2018/1/30.
 */
public class No20 {

    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<>();

        // 括号匹配对
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('[', ']');
        charMap.put('{', '}');

        if (null != s && s.length() > 0) {

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(' :
                    case '[' :
                    case '{' :
                        charStack.push(c);
                        break;
                    case ')' :
                    case ']' :
                    case '}' :
                        // 如果为空 或者 栈顶和当前元素不匹配 则不合法
                        if (charStack.isEmpty() || c != charMap.get(charStack.pop())) {
                            return false;
                        }
                }
            }
        }

        return charStack.isEmpty();
    }


    public static void main(String[] args) {
        No20 no20 = new No20();

        String str = "[]()[]";
        String str1 = "[]{{)";

        System.out.println(no20.isValid(str));
        System.out.println(no20.isValid(str1));
    }

}
