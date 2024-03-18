import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<keymap.length; i++){
            for(int j=0; j<keymap[i].length(); j++){
                char c = keymap[i].charAt(j);
                if(map.containsKey(c)){
                    map.put(c, Math.min(j+1, map.get(c)));
                }else{
                    map.put(c,j+1);
                }
            }
        }

        for(int i =0; i< targets.length; i++){
            int sum =0;
            for(int j=0; j<targets[i].length(); j++){
                char t = targets[i].charAt(j);
                if(map.containsKey(t)){
                    sum += map.get(t);
                }else{
                    sum = -1;
                    break;
                }
            }
            answer[i] = sum;
        }

        return answer;
    }
}