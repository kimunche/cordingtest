import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i =0;i<s.length(); i++){
            if(isValid(s)){
                answer++;
            }
            s = s.substring(1)+ s.charAt(0); // s 회전
        }

        return answer;
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('||s.charAt(i) == '['||s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                if ((s.charAt(i) == ')' && top != '(')
                        || (s.charAt(i) == ']' && top != '[')
                        || (s.charAt(i) == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}