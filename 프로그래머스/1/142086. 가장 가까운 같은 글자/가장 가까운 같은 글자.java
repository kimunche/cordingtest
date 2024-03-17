import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length; i++) {
            if(!map.containsKey(chars[i])){
                answer[i] =  -1;
                map.put(chars[i], i);
            }else{
                answer[i] = i - map.get(chars[i]);
                map.put(chars[i], i);
            }
        }


        return answer;
    }
}