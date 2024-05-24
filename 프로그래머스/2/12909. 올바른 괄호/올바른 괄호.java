import java.util.*;


class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++){
            if(chars[i] == '('){
                stack.push(chars[i]);
            }else if (chars[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}