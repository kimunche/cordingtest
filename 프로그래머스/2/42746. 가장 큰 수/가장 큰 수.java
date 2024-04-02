
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer= "";

        String[] str = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        //내림차순
        //A.compareTo(B)는 A와 B가 같을 경우 0을 리턴, A가 B보다 클 경우 양수로 리턴, A가 B보다 작을 경우 음수로 리턴
        Arrays.sort(str, (a,b)-> (b+a).compareTo(a+b));

        if(str[0].equals("0")){
            return "0";
        }

        for(String s: str){
            answer+=s;
        }

        return answer;
    }
}