import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(String arr[] : clothes){
            map.put(arr[1], map.getOrDefault(arr[1], 0)+1);
        }

        int sum =1;
        for(String key : map.keySet()){
            sum *= map.get(key)+1;
        }

        return sum-1;
    }
}