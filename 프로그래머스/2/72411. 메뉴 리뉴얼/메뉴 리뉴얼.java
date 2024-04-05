import java.util.*;

class Solution {
    Map<String, Integer> map;
    int max;
    List<String> result;
    
    public String[] solution(String[] orders, int[] course) {

        result = new ArrayList<>();

        for(int courseLen : course){
            max =0;
            map = new HashMap<>();
            for(String order : orders){
                char[] arr = order.toCharArray();
                Arrays.sort(arr);
                combination(arr, map,"",0, courseLen);
            }
            if(max<2){
                continue;
            }
            for(String key : map.keySet()){
                if(map.get(key) == max){
                    result.add(key);
                }
            }

        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public void combination(char[] arr, Map<String, Integer> map, String letter, int startIdx, int courseLen){
        if(letter.length() == courseLen){
            map.put(letter, map.getOrDefault(letter,0)+1);
            max = Math.max(max, map.get(letter));
            return;
        }

        for(int i=startIdx; i<arr.length; i++){
            combination(arr, map, letter+arr[i], i+1, courseLen);
        }
    }
}