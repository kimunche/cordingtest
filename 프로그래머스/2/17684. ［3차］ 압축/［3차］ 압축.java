import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();

        for(char c = 'A'; c<='Z'; c++){
            map.put(String.valueOf(c), c-'A'+1);
        }

        List<Integer> list = new ArrayList<>();

        StringBuilder w = new StringBuilder();

        int idx= 27; //마지막 색인 번호가 27

        for(char c : s.toCharArray()){
            w.append(c);
            if(!map.containsKey(w.toString())){
                list.add(map.get(w.substring(0, w.length()-1)));
                map.put(w.toString(),idx);
                idx++;
                w = new StringBuilder(String.valueOf(c));
            }
        }

        list.add(map.get(w.toString()));


        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}