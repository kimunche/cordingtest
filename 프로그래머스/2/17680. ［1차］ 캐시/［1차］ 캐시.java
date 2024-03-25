import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        int hit =0;
        int miss =0;

        Queue<String> queue = new ArrayDeque<>();

        for(String c : cities){
            String city = c.toLowerCase();
            if(!queue.contains(city)){
                miss++;
            }else {
                queue.remove(city);
                hit++;
            }
            queue.add(city);

            if(queue.size() > cacheSize){
                queue.poll();
            }

        }

        answer += hit +miss*5;

        return answer;
    }
}