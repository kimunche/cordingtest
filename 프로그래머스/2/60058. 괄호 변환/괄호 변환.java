import java.util.*;

class Solution {
    public String solution(String p) {

        if(check(p)){
            return p;
        }
        else return dfs(p);
    }

    //올바른 괄호 확인
    private boolean check(String p) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                stack.add(p.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                else stack.pop();
            }
        }

        if(!stack.isEmpty()){ return false;}
        else return true;
    }

    private String dfs(String s){
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(s.isEmpty()) return s;

        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다.
        String u =""; String v ="";
        int left=0; int right =0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }else right++;

            //균형잡힌 문자열일 때 u,v 분리
            if(left >0 && right >0 && left == right){
                u = s.substring(0, i+1);
                if(i< s.length()-1){
                    v = s.substring(i+1);
                }
                break;
            }

        }

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(check(u)){
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u+dfs(v);
        }else{
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            // 4-3. ')'를 다시 붙입니다.
            String tmp = "("+ dfs(v)+ ")";

            // 4-4. u의 첫 번째와 마지막 문자를 제거하고,
            u = u.substring(1, u.length()-1);

            // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            u = u.replace("(", ".");
            u = u.replace(")", "(");
            u = u.replace(".", ")");

            // 4-5. 생성된 문자열을 반환합니다.
            tmp = tmp + u;
            return tmp;
        }

    }
}